package test;

import busqueda.noinformada.BusquedaEnProfundidadVuelos;
import busqueda.noinformada.ConexionesVuelos;
import busqueda.noinformada.PuzzleLineal;
import utilidades.Nodo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BusquedaNoInformada {

    public static void main(String[] args){

        System.out.println("##### AMPLITUD En Puzzle Lineal #####");
        PuzzleLineal puzzleLineal = new PuzzleLineal();

        Nodo solucionPuzzleAmplitud = puzzleLineal.run("7654321","1234567", PuzzleLineal.AMPLITUD);
        System.out.println("Profundidad: " + solucionPuzzleAmplitud.getProfundidad() + " camino: " + solucionPuzzleAmplitud.getCamino());


        System.out.println("\n##### PROFUNDIDAD En Puzzle Lineal #####");
        Nodo solucionPuzzleProfundidad = puzzleLineal.run("4321","1234", PuzzleLineal.PROFUNDIDAD);
        System.out.println("Profundidad: " + solucionPuzzleProfundidad.getProfundidad() + " camino: " + solucionPuzzleProfundidad.getCamino());


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

        String estadoInicial= "MALAGA";
        String solucion = "SANTANDER";

        System.out.println("\n\n##### En AMPLITUD En Conexiones Vuelo #####");
        ConexionesVuelos bav = new ConexionesVuelos();
        bav.run(estadoInicial,solucion,conexiones);

        System.out.println("\n\n##### En PROFUNDIDAD En Conexiones Vuelo #####");
        BusquedaEnProfundidadVuelos bpv = new BusquedaEnProfundidadVuelos();
        bpv.run(estadoInicial,solucion,conexiones);

    }
}
