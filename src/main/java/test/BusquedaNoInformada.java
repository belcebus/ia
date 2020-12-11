package test;

import busqueda.noinformada.AlgoritmoBusqueda;
import utilidades.exploradores.ExploradorLineal;
import utilidades.exploradores.ExploradorViajante;
import utilidades.exploradores.ExploradorVuelos;
import utilidades.exploradores.IExplorador;
import utilidades.GeneradorConexiones;
import utilidades.Solucion;

public class BusquedaNoInformada {

    public static void main(String[] args){

        System.out.println ("\nLeyenda: " +
                "\n* Visitados: Uso de tiempo (complejidad temporal)" +
                "\n* Explorados: Uso de memoria (complejidad espacial)" +
                "\n* Profundidad: Calidad de la solución" +
                "\n* Camino: Ruta desde la raiz a la solución" +
                "\n* Tiempo: Tiempo empleado en el algoritmo");

        /*
            PROBLEMA DEL PUZZLE LINEAL
         */

        AlgoritmoBusqueda algoritmoBusqueda = new AlgoritmoBusqueda();
        String datosIniciales="7654321";
        String solucionFinal ="1234567";
        int limiteProfundidad=100;
        long tiempoComienzo;
        long tiempoFinal;

        System.out.println("\n_-_- Puzzle lineal exploración en amplitud [" + datosIniciales + "->"+ solucionFinal + "] -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionPuzzleAmplitud = algoritmoBusqueda.run(
                datosIniciales,
                solucionFinal,
                new ExploradorLineal(IExplorador.AMPLITUD));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionPuzzleAmplitud.getProfundidad() +
                            "\nCamino:      " + solucionPuzzleAmplitud.getCamino() +
                            "\nVisitados:   " + solucionPuzzleAmplitud.getNodosVisitados() +
                            "\nExplorados:  " + solucionPuzzleAmplitud.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");

        System.out.println("\n_-_- Puzzle lineal exploración en profundidad [" + datosIniciales + "->"+ solucionFinal + "] -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionPuzzleProfundidad = algoritmoBusqueda.run(
                datosIniciales,
                solucionFinal,
                new ExploradorLineal(IExplorador.PROFUNDIDAD));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionPuzzleProfundidad.getProfundidad() +
                            "\nCamino:      " + solucionPuzzleProfundidad.getCamino()+
                            "\nVisitados:   " + solucionPuzzleProfundidad.getNodosVisitados() +
                            "\nExplorados:  " + solucionPuzzleProfundidad.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");

        System.out.println("\n_-_- Puzzle lineal exploración en profundidad limitada [" + datosIniciales + "->"+ solucionFinal
                + " | Limite Profundidad: "+ limiteProfundidad + "] -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionPuzzleProfundidadLimitada = algoritmoBusqueda.run(
                datosIniciales,
                solucionFinal,
                new ExploradorLineal(IExplorador.PROFUNDIDAD_LIMITADA,limiteProfundidad));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionPuzzleProfundidadLimitada.getProfundidad() +
                            "\nCamino:      " + solucionPuzzleProfundidadLimitada.getCamino()+
                            "\nVisitados:   " + solucionPuzzleProfundidadLimitada.getNodosVisitados() +
                            "\nExplorados:  " + solucionPuzzleProfundidadLimitada.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");

        /*
            PROBLEMA CONEXIONES O TRANSBORDOS EN VUELOS
         */

        String ciudadOrigen="MALAGA";
        String ciudadDestino="SANTIAGO";
        int limiteProfundidadVuelos=3;

        System.out.println("\n_-_- Conexiones vuelo en amplitud ["+ciudadOrigen+"->"+ciudadDestino+"] -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionVuelosAmplitud = algoritmoBusqueda.run(
                ciudadOrigen,
                ciudadDestino,
                new ExploradorVuelos(IExplorador.AMPLITUD, GeneradorConexiones.getConexionesVuelos()));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionVuelosAmplitud.getProfundidad() +
                            "\nCamino:      " + solucionVuelosAmplitud.getCamino()+
                            "\nVisitados:   " + solucionVuelosAmplitud.getNodosVisitados() +
                            "\nExplorados:  " + solucionVuelosAmplitud.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");

        System.out.println("\n_-_- Conexiones vuelo en profundidad ["+ciudadOrigen+"->"+ciudadDestino+"] -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionVuelosProfundidad = algoritmoBusqueda.run(
                ciudadOrigen,
                ciudadDestino,
                new ExploradorVuelos(IExplorador.PROFUNDIDAD, GeneradorConexiones.getConexionesVuelos()));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionVuelosProfundidad.getProfundidad() +
                            "\nCamino:      " + solucionVuelosProfundidad.getCamino() +
                            "\nVisitados:   " + solucionVuelosProfundidad.getNodosVisitados() +
                            "\nExplorados:  " + solucionVuelosProfundidad.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");

        System.out.println("\n_-_- Conexiones vuelo en profundidad limitada ["+ciudadOrigen+"->"+ciudadDestino+"] -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionVuelosProfundidadLimitada = algoritmoBusqueda.run(
                ciudadOrigen,
                ciudadDestino,
                new ExploradorVuelos(IExplorador.PROFUNDIDAD_LIMITADA, GeneradorConexiones.getConexionesVuelos(), limiteProfundidadVuelos));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionVuelosProfundidadLimitada.getProfundidad() +
                            "\nCamino:      " + solucionVuelosProfundidadLimitada.getCamino() +
                            "\nVisitados:   " + solucionVuelosProfundidadLimitada.getNodosVisitados() +
                            "\nExplorados:  " + solucionVuelosProfundidadLimitada.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");

        /*
            PROBLEMA DEL VIAJANTE DE COMERCIO: TRAVEL SALESMAN PROBLEM (TPS)
         */


        String ciudadOrigenViajante="SEVILLA";
        String ciudadDestinoViajante="SANTIAGO";

        System.out.println("\n_-_- Viajante en coste uniforme ["+ciudadOrigenViajante+"->"+ciudadDestinoViajante+"] -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionViajanteCosteUniforme = algoritmoBusqueda.run(
                ciudadOrigenViajante,
                ciudadDestinoViajante,
                new ExploradorViajante(IExplorador.COSTE_UNIFORME, GeneradorConexiones.getConexionesViajante()));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionViajanteCosteUniforme.getProfundidad() +
                "\nCoste        " + solucionViajanteCosteUniforme.getCoste() +
                "\nCamino:      " + solucionViajanteCosteUniforme.getCamino() +
                "\nVisitados:   " + solucionViajanteCosteUniforme.getNodosVisitados() +
                "\nExplorados:  " + solucionViajanteCosteUniforme.getNodosExplorados() +
                "\nTiempo:      " + tiempoFinal + " ms");
    }

}