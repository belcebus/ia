package test;

import busqueda.noinformada.AlgoritmoBusqueda;
import factoria.ExploradorLineal;
import factoria.ExploradorVuelos;
import factoria.IExplorador;
import utilidades.Nodo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BusquedaNoInformada {

    public static void main(String[] args){
        AlgoritmoBusqueda algoritmoBusqueda = new AlgoritmoBusqueda();
        String datosIniciales="54321";
        String solucionFinal ="12345";

        System.out.println("\n_-_- Puzzle lineal exploracion en amplitud [" + datosIniciales + "->"+ solucionFinal + "]-_-_");
        Nodo solucionPuzzleAmplitud = algoritmoBusqueda.run(
                datosIniciales,
                solucionFinal,
                new ExploradorLineal(IExplorador.AMPLITUD));
        System.out.println("Profundidad: " + solucionPuzzleAmplitud.getProfundidad() +
                           " camino: " + solucionPuzzleAmplitud.getCamino());

        System.out.println("\n_-_- Puzzle lineal exploracion en profundidad [" + datosIniciales + "->"+ solucionFinal + "]-_-_");
        Nodo solucionPuzzleProfundidad = algoritmoBusqueda.run(
                datosIniciales,
                solucionFinal,
                new ExploradorLineal(IExplorador.PROFUNDIDAD));
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


        System.out.println("\n_-_- Conexiones vuelo en amplitud -_-_");
        Nodo solucionVuelosAmplitud = algoritmoBusqueda.run(
                "MALAGA",
                "SANTANDER",
                new ExploradorVuelos(IExplorador.AMPLITUD, conexiones));
        System.out.println("Profundidad: " + solucionVuelosAmplitud.getProfundidad() +
                           " camino: " + solucionVuelosAmplitud.getCamino());

        System.out.println("\n_-_- Conexiones vuelo en profundidad -_-_");
        Nodo solucionVuelosProfundidad = algoritmoBusqueda.run(
                "MALAGA",
                "SANTANDER",
                new ExploradorVuelos(IExplorador.PROFUNDIDAD, conexiones));
        System.out.println("Profundidad: " + solucionVuelosProfundidad.getProfundidad() +
                           " camino: " + solucionVuelosProfundidad.getCamino());
    }
}
