package run;

import algoritmo.IAlgoritmo;
import algoritmo.busqueda.IBusqueda;
import algoritmo.busqueda.noinformada.AlgoritmoBusquedaNoInformada;
import algoritmo.busqueda.noinformada.IProblema;
import org.apache.commons.cli.*;
import utilidades.Coordenada;
import utilidades.Solucion;
import utilidades.exploradores.FactoriaExploradores;
import utilidades.exploradores.IExplorador;

import java.util.Arrays;
import java.util.List;

public class CommandLineRunner {

    public static void main(String[] args) {
        Options commandLineOptions = new Options();

        //obligatorios
        commandLineOptions.addOption("a", "algoritmo", true,
                "Tipo de algoritmo a utilizar. [busqueda]");
        commandLineOptions.addOption("t", "tipo", true,
                "Tipo de algoritmo. [noinformada]");
        commandLineOptions.addOption("v", "variacion", true,
                "Variación del algoritmo. [amplitud | profundidad | profundidadlimitada | costeunitario");
        commandLineOptions.addOption("p", "problema", true,
                "Tipo de problema a solucionar con el algoritmo seleccionada [puzzle | conexiones | viajante]");
        commandLineOptions.addOption("i", "inicio", true,
                "Datos iniciales. Dependiente del problema");
        commandLineOptions.addOption("s", "solucion", true,
                "Solución buscada. Dependiente del problema");


        //opcionales o dependientes
        commandLineOptions.addOption("l", "limite",true,
                "limite de niveles en caso de una variación con limite de profundidad");
        //commandLineOptions.addOption("c", "conexiones",true, "fichero de conexiones");

        List<String> obligatorios = Arrays.asList("a","t","v","p","i","s");
        List<String> opcionales = Arrays.asList("l");

        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();

        try {
            // Validar el número de parámetros obligatorios
            CommandLine cmd = parser.parse(commandLineOptions, args, false);

            if (cmd.getOptions().length < obligatorios.size()) { //todas los parametros obligatorios
                String uso = "java -jar algoritmos.jar";
                String ejemplo = "ejemplo: java -jar algoritmo.jar " +
                        "--algoritmo busqueda " +
                        "--tipo noinformada " +
                        "--variacion amplitud " +
                        "--problema lineal " +
                        "--inicio 4321 " +
                        "--solucion 1234";

                formatter.printHelp(uso, "opciones:", commandLineOptions, ejemplo,true);

                return;
            }

            String algoritmo = cmd.getOptionValue("a");
            String tipoAlgoritmo = cmd.getOptionValue("t");
            String variacionAlgoritmo = cmd.getOptionValue("v");
            String problema = cmd.getOptionValue("p");
            String inicio = cmd.getOptionValue("i");
            String solucion = cmd.getOptionValue("s");
            String limite = cmd.getOptionValue("l");

            if(variacionAlgoritmo.equalsIgnoreCase(IExplorador.PROFUNDIDAD_LIMITADA) && limite == null ||
            limite!=null && !variacionAlgoritmo.equalsIgnoreCase(IExplorador.PROFUNDIDAD_LIMITADA)){
                throw new ParseException("Parámetro \"l\" obligatorio para variación de algoritmo "
                        + IExplorador.PROFUNDIDAD_LIMITADA + " o si se ha especificado el parámetro \"l\" " +
                        "la variacion no es " + IExplorador.PROFUNDIDAD_LIMITADA + " " + variacionAlgoritmo);
            }

            for (Option o : cmd.getOptions()) {
                System.out.println(o.getLongOpt() + ": " + cmd.getOptionValue(o.getOpt()));
            }

            Solucion sol = null;
            if (algoritmo.equalsIgnoreCase(IAlgoritmo.BUSQUEDA)) {
                if (tipoAlgoritmo.equalsIgnoreCase(IBusqueda.NO_INFORMADA)) {
                    AlgoritmoBusquedaNoInformada abni = new AlgoritmoBusquedaNoInformada();
                    FactoriaExploradores factoria = new FactoriaExploradores(problema, variacionAlgoritmo,limite);

                    if(problema.equalsIgnoreCase(IProblema.BUSQUEDA_Y_RESCATE)){
                        //transformar la entrada en coordendadas
                        Coordenada coordenadaInicio = new Coordenada(inicio);
                        Coordenada coordenadaSolucion = new Coordenada(solucion);
                        sol = abni.run(coordenadaInicio, coordenadaSolucion, factoria.crearExplorador());

                    }else{
                        sol = abni.run(inicio, solucion, factoria.crearExplorador());
                    }

                } else {
                    System.out.println("Tipo de algoritmo no implementado para " + algoritmo + ": " + tipoAlgoritmo);
                }
            } else {
                System.out.println("Algoritmo no implementando: " + algoritmo);
            }

            System.out.println(sol);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
