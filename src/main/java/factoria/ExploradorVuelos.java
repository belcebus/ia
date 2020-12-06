package factoria;

import utilidades.Nodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ExploradorVuelos implements IExplorador {

    private HashMap<String, ArrayList<String>> conexiones;

    public ExploradorVuelos(HashMap<String, ArrayList<String>> conexiones) {
        this.conexiones = conexiones;
    }

    @Override
    public LinkedList explorarFrontera(Nodo nodo) {
        LinkedList<Nodo> listaNodosHijo = new LinkedList<>();

        Iterator hijos = conexiones.get((String)nodo.getValor()).iterator();
        while(hijos.hasNext()){
            Nodo hijo = new Nodo(nodo, (String)hijos.next());
            listaNodosHijo.add(hijo);
        }

        return listaNodosHijo;
    }
}
