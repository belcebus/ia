package test;

import busqueda.noinformada.AlgoritmoBusqueda;
import factoria.ExploradorLineal;
import factoria.ExploradorVuelos;
import utilidades.Nodo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BusquedaNoInformada {

    public static void main(String[] args){

        System.out.println("##### AMPLITUD En Puzzle Lineal #####");
        AlgoritmoBusqueda algoritmoBusqueda = new AlgoritmoBusqueda();

        Nodo solucionPuzzleAmplitud = algoritmoBusqueda.run(
                "4321",
                "1234",
                AlgoritmoBusqueda.AMPLITUD,
                new ExploradorLineal());
        System.out.println("Profundidad: " + solucionPuzzleAmplitud.getProfundidad() +
                           " camino: " + solucionPuzzleAmplitud.getCamino());

        System.out.println("\n##### PROFUNDIDAD En Puzzle Lineal #####");
        Nodo solucionPuzzleProfundidad = algoritmoBusqueda.run(
                "4321",
                "1234",
                AlgoritmoBusqueda.PROFUNDIDAD,
                new ExploradorLineal());
        System.out.println("Profundidad: " + solucionPuzzleProfundidad.getProfundidad() +
                           " camino: " + solucionPuzzleProfundidad.getCamino());

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


        System.out.println("\n##### En AMPLITUD En Conexiones Vuelo #####");
        Nodo solucionVuelosAmplitud = algoritmoBusqueda.run(
                "MALAGA",
                "SANTANDER",
                AlgoritmoBusqueda.AMPLITUD,
                new ExploradorVuelos(conexiones));
        System.out.println("Profundidad: " + solucionVuelosAmplitud.getProfundidad() +
                           " camino: " + solucionVuelosAmplitud.getCamino());

        System.out.println("\n##### En PROFUNDIDAD En Conexiones Vuelo #####");
        Nodo solucionVuelosProfundidad = algoritmoBusqueda.run(
                "MALAGA",
                "SANTANDER",
                AlgoritmoBusqueda.PROFUNDIDAD,
                new ExploradorVuelos(conexiones));
        System.out.println("Profundidad: " + solucionVuelosProfundidad.getProfundidad() +
                           " camino: " + solucionVuelosProfundidad.getCamino());
    }
}
