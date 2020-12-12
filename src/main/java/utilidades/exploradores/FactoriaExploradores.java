package utilidades.exploradores;

import algoritmo.busqueda.noinformada.IProblema;
import utilidades.GeneradorConexiones;

public class FactoriaExploradores {

    private final String problema;
    private final String variacion;

    public FactoriaExploradores(String problema, String variacion) {
        this.problema = problema;
        this.variacion = variacion;
    }

    public IExplorador crearExplorador(){

        if(problema.equalsIgnoreCase(IProblema.PUZZLE_LINEAL)){
            return new ExploradorLineal(variacion);
        }else if(problema.equalsIgnoreCase(IProblema.CONEXIONES)){
            return new ExploradorConexiones(variacion, GeneradorConexiones.getConexionesVuelos());
        }else if(problema.equalsIgnoreCase(IProblema.VIAJANTE)){
            return new ExploradorConexiones(variacion, GeneradorConexiones.getConexionesViajante());
        }else{

            System.out.println("Variación:" + variacion + " o problema:" + problema + " no implementado");
        }

        return null;
    }
}
