package factoria;

import utilidades.Nodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ExploradorVuelos implements IExplorador {

    private HashMap<String, ArrayList<String>> conexiones;
    private String metodoExploracion;

    public ExploradorVuelos(String metodoExploracion,HashMap<String, ArrayList<String>> conexiones) {
        this.metodoExploracion = metodoExploracion;
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

    @Override
    public Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera) {

        if (this.metodoExploracion.equalsIgnoreCase(IExplorador.AMPLITUD)) {
            return nodosFrontera.removeFirst(); //FIFO
        } else if (this.metodoExploracion.equalsIgnoreCase(PROFUNDIDAD)) {
            return nodosFrontera.removeLast(); //LIFO
        } else {
            System.out.println("Metodo no valido: " + this.metodoExploracion);
            return null;
        }
    }
}
