package busqueda.noinformada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BusquedaNoInformada {

    public static void main(String[] args){

        System.out.println("##### AMPLITUD En Puzzle Lineal #####");
        BusquedaEnAmplitudPuzzleLineal bapl = new BusquedaEnAmplitudPuzzleLineal();
        bapl.run("4321","1234");

        System.out.println("\n\n##### PROFUNDIDAD En Puzzle Lineal #####");
        BusquedaEnProfundidadPuzzleLineal bppl = new BusquedaEnProfundidadPuzzleLineal();
        bppl.run("4321","1234");

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
        BusquedaEnAmplitudVuelos bav = new BusquedaEnAmplitudVuelos();
        bav.run(estadoInicial,solucion,conexiones);

        System.out.println("\n\n##### En PROFUNDIDAD En Conexiones Vuelo #####");
        BusquedaEnProfundidadVuelos bpv = new BusquedaEnProfundidadVuelos();
        bpv.run(estadoInicial,solucion,conexiones);

    }
}
