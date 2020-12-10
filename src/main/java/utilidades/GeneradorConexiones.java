package utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GeneradorConexiones {

    public static HashMap<String, HashMap<String, Integer>> getConexionesViajante(){

        HashMap<String, HashMap<String, Integer>> conexionesViajante = new HashMap<>();

        HashMap<String,Integer> conexionesMalaga = new HashMap<>();
        conexionesMalaga.put("MADRID",513);
        conexionesMalaga.put("GRANADA", 125);
        conexionesViajante.put("MALAGA", conexionesMalaga);

        HashMap<String, Integer> conexionesSevilla = new HashMap<>();
        conexionesSevilla.put("MADRID", 514);
        conexionesViajante.put("SEVILLA",conexionesSevilla);

        HashMap<String,Integer> conexionesGranada = new HashMap<>();
        conexionesGranada.put("MADRID",423);
        conexionesGranada.put("VALENCIA",491);
        conexionesViajante.put("GRANADA",conexionesGranada);

        HashMap<String,Integer> conexionesValencia = new HashMap<>();
        conexionesValencia.put("MADRID", 355);
        conexionesValencia.put("GRANADA", 491);
        conexionesValencia.put("ZARAGOZA", 309);
        conexionesValencia.put("BARCELONA", 346);
        conexionesViajante.put("VALENCIA",conexionesValencia);

        HashMap<String, Integer> conexionesMadrid = new HashMap<>();
        conexionesMadrid.put("SANTANDER",437);
        conexionesMadrid.put("ZARAGOZA",313);
        conexionesMadrid.put("BARCELONA",603);
        conexionesMadrid.put("VALENCIA",355);
        conexionesMadrid.put("GRANADA",423);
        conexionesMadrid.put("MALAGA",513);
        conexionesMadrid.put("SEVILLA",514);
        conexionesMadrid.put("SALAMANCA",203);
        conexionesMadrid.put("SANTIAGO",599);
        conexionesViajante.put("MADRID",conexionesMadrid);

        HashMap<String,Integer> conexionesSalamanca = new HashMap<>();
        conexionesSalamanca.put("MADRID",203);
        conexionesSalamanca.put("SANTIAGO",390);
        conexionesViajante.put("SALAMANCA",conexionesSalamanca);

        HashMap<String,Integer> conexionesSantiago = new HashMap<>();
        conexionesSantiago.put("SALAMANCA", 390);
        conexionesSantiago.put("MADRID",509);
        conexionesViajante.put("SANTIAGO",conexionesSantiago);

        HashMap<String,Integer> conexionesSantander = new HashMap<>();
        conexionesSantander.put("MADRID",437);
        conexionesSantander.put("ZARAGOZA",394);
        conexionesViajante.put("SANTANDER",conexionesSantander);

        HashMap<String,Integer> conexionesZaragoza = new HashMap<>();
        conexionesZaragoza.put("SANTANDER", 394);
        conexionesZaragoza.put("MADRID", 313);
        conexionesZaragoza.put("BARCELONA", 296);
        conexionesZaragoza.put("VALENCIA", 309);
        conexionesViajante.put("ZARAGOZA",conexionesZaragoza);

        HashMap<String,Integer> conexionesBarcelona = new HashMap<>();
        conexionesBarcelona.put("ZARAGOZA",296);
        conexionesBarcelona.put("MADRID",603);
        conexionesBarcelona.put("VALENCIA",346);
        conexionesViajante.put("BARCELONA",conexionesBarcelona);

        return conexionesViajante;
    }

    public static HashMap<String, ArrayList<String>> getConexionesVuelos(){
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

        return conexiones;
    }
}
