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

    public static HashMap<String, HashMap<String, Integer>> getConexionesVuelos(){

        HashMap<String, HashMap<String, Integer>> conexionesVuelos = new HashMap<>();

        HashMap<String,Integer> conexionesMalaga = new HashMap<>();
        conexionesMalaga.put("SALAMANCA",0);
        conexionesMalaga.put("MADRID", 0);
        conexionesMalaga.put("BARCELONA", 0);
        conexionesVuelos.put("MALAGA", conexionesMalaga);

        HashMap<String,Integer> conexionesSevilla = new HashMap<>();
        conexionesSevilla.put("SANTIAGO",0);
        conexionesSevilla.put("MADRID", 0);
        conexionesVuelos.put("SEVILLA", conexionesSevilla);

        HashMap<String,Integer> conexionesGranada = new HashMap<>();
        conexionesGranada.put("VALENCIA",0);
        conexionesVuelos.put("GRANADA", conexionesGranada);

        HashMap<String,Integer> conexionesValencia = new HashMap<>();
        conexionesValencia.put("BARCELONA",0);
        conexionesVuelos.put("VALENCIA", conexionesValencia);


        HashMap<String,Integer> conexionesMadrid = new HashMap<>();
        conexionesMadrid.put("SALAMANCA",0);
        conexionesMadrid.put("SEVILLA",0);
        conexionesMadrid.put("MALAGA",0);
        conexionesMadrid.put("BARCELONA",0);
        conexionesMadrid.put("SANTANDER",0);
        conexionesVuelos.put("MADRID", conexionesMadrid);

        HashMap<String,Integer> conexionesSalamanca = new HashMap<>();
        conexionesSalamanca.put("MALAGA",0);
        conexionesSalamanca.put("MADRID",0);
        conexionesVuelos.put("SALAMANCA", conexionesSalamanca);

        HashMap<String,Integer> conexionesSantiago = new HashMap<>();
        conexionesSantiago.put("SEVILLA",0);
        conexionesSantiago.put("SANTANDER",0);
        conexionesSantiago.put("BARCELONA",0);
        conexionesVuelos.put("SANTIAGO", conexionesSantiago);

        HashMap<String,Integer> conexionesSantander = new HashMap<>();
        conexionesSantander.put("SANTIAGO",0);
        conexionesSantander.put("MADRID",0);
        conexionesVuelos.put("SANTANDER", conexionesSantander);

        HashMap<String,Integer> conexionesZaragoza = new HashMap<>();
        conexionesZaragoza.put("BACERLONA",0);
        conexionesVuelos.put("ZARAGOZA", conexionesZaragoza);

        HashMap<String,Integer> conexionesBarcelona = new HashMap<>();
        conexionesBarcelona.put("ZARAGOZA",0);
        conexionesBarcelona.put("SANTIAGO",0);
        conexionesBarcelona.put("MADRID",0);
        conexionesBarcelona.put("MALAGA",0);
        conexionesBarcelona.put("VALENCIA",0);
        conexionesVuelos.put("BARCELONA", conexionesBarcelona);

        return conexionesVuelos;
    }
}
