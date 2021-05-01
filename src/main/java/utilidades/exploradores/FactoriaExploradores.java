package utilidades.exploradores;

import algoritmo.busqueda.noinformada.Problema;
import utilidades.GeneradorConexiones;

public class FactoriaExploradores {

    private final String problema;
    private final String variacion;
    private int limiteProfundidad=0;

    public FactoriaExploradores(String problema, String variacion) {
        this.problema = problema;
        this.variacion = variacion;
    }

    public FactoriaExploradores(String problema, String variacion, String limiteProfundidad) {
        this.problema = problema;
        this.variacion = variacion;
        if(limiteProfundidad!=null){
            this.limiteProfundidad = Integer.parseInt(limiteProfundidad);
        }
    }

    public IExplorador crearExplorador(){

        if(problema.equalsIgnoreCase(Problema.PUZZLE_LINEAL)){
            return new ExploradorLineal(variacion,limiteProfundidad);
        }else if(problema.equalsIgnoreCase(Problema.CONEXIONES)){
            return new ExploradorConexiones(variacion, GeneradorConexiones.getConexionesVuelos(),limiteProfundidad);
        }else if(problema.equalsIgnoreCase(Problema.VIAJANTE)){
            return new ExploradorConexiones(variacion, GeneradorConexiones.getConexionesViajante(),limiteProfundidad);
        }else if(problema.equalsIgnoreCase(Problema.BUSQUEDA_Y_RESCATE)){
            return new ExploradorBusquedaRescate(variacion,limiteProfundidad);
        }else{
            System.out.println("Variación:" + variacion + " o problema:" + problema + " no implementado");
        }

        return null;
    }
}