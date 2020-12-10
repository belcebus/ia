package test;

import busqueda.noinformada.AlgoritmoBusqueda;
import factoria.ExploradorLineal;
import factoria.ExploradorVuelos;
import factoria.IExplorador;
import utilidades.Nodo;
import utilidades.Solucion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BusquedaNoInformada {

    public static void main(String[] args){

        System.out.println ("\nLeyenda: " +
                "\n* Visitados: Uso de tiempo (complejidad temporal)" +
                "\n* Explorados: Uso de memoria (complejidad espacial)" +
                "\n* Profundidad: Calidad de la solución" +
                "\n* Camino: Ruta desde la raiz a la solución" +
                "\n* Tiempo: Tiempo empleado en el algoritmo");

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

        HashMap<String, ArrayList<String>> conexiones = new HashMap<>();
        conexiones.put("MALAGA", new ArrayList<>(Arrays.asList("SALAMANCA","MADRID","BARCELONA")));
        conexiones.put("SEVILLA", new ArrayList<>(Arrays.asList("SANTIAGO","MADRID")));
        conexiones.put("GRANADA", new ArrayList<>(Arrays.asList("VALENCIA")));
        conexiones.put("VALENCIA", new ArrayList<>(Arrays.asList("BARCELONA")));
        conexiones.put("MADRID", new ArrayList<>(Arrays.asList("SALAMANCA","SEVILLA","MALAGA","BARCELONA","SANTANDER")));
        conexiones.put("SALAMANCA", new ArrayList<>(Arrays.asList("MALAGA","MADRID")));
        conexiones.put("SANTIAGO", new ArrayList<>(Arrays.asList("SEVILLA","SANTANDER","BARCELONA")));
        conexiones.put("SANTANDER", new ArrayList<>(Arrays.asList("SANTIAGO","MADRID")));
        conexiones.put("ZARAGOZA", new ArrayList<>(Arrays.asList("BARCELONA")));
        conexiones.put("BARCELONA", new ArrayList<>(Arrays.asList("ZARAGOZA","SANTIAGO","MADRID","MALAGA","VALENCIA")));


        System.out.println("\n_-_- Conexiones vuelo en amplitud -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionVuelosAmplitud = algoritmoBusqueda.run(
                "MALAGA",
                "SANTANDER",
                new ExploradorVuelos(IExplorador.AMPLITUD, conexiones));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionVuelosAmplitud.getProfundidad() +
                            "\nCamino:      " + solucionVuelosAmplitud.getCamino()+
                            "\nVisitados:   " + solucionVuelosAmplitud.getNodosVisitados() +
                            "\nExplorados:  " + solucionVuelosAmplitud.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");

        System.out.println("\n_-_- Conexiones vuelo en profundidad -_-_");
        tiempoComienzo = System.currentTimeMillis();
        Solucion solucionVuelosProfundidad = algoritmoBusqueda.run(
                "MALAGA",
                "SANTANDER",
                new ExploradorVuelos(IExplorador.PROFUNDIDAD, conexiones));
        tiempoFinal = System.currentTimeMillis() - tiempoComienzo;
        System.out.println("Profundidad: " + solucionVuelosProfundidad.getProfundidad() +
                            "\nCamino:      " + solucionVuelosProfundidad.getCamino() +
                            "\nVisitados:   " + solucionVuelosProfundidad.getNodosVisitados() +
                            "\nExplorados:  " + solucionVuelosProfundidad.getNodosExplorados() +
                            "\nTiempo:      " + tiempoFinal + " ms");
    }
}
