package run;

import org.apache.commons.cli.*;

public class Run {

    public static void main(String[] args){
        Options options = new Options();

        //obligatorios
        options.addOption("a","algoritmo",true,"noinformada");
        options.addOption("t","tipo",true,"anchura|profundidad|limitada");
        options.addOption("p","problema", true,"puzzle|transbordos|viajante");
        options.addOption("i","inicio",true,"datos iniciales");
        options.addOption("s","solucion", true,"solucion buscada");
        //opcionales con dependientes

        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();

        try {
            // Validar el número de parámetros obligatorios
            CommandLine cmd = parser.parse( options, args, false);
            if(cmd.getOptions().length != options.getOptions().size()){ //todas los parametros obligatorios
                String uso="java -jar algoritmos.jar [options]";
                formatter.printHelp( uso, "options:" ,options, "" );
                return;
            }
            String algoritmo = cmd.getOptionValue("a");
            String problema = cmd.getOptionValue("p");
            String inicio = cmd.getOptionValue("i");
            String solucion = cmd.getOptionValue("s");

            System.out.println(algoritmo + " " + problema + " " + inicio + " " + solucion );

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
