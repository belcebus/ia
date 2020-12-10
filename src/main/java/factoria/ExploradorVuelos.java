package factoria;

import utilidades.Nodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ExploradorVuelos implements IExplorador {

    private HashMap<String, ArrayList<String>> conexiones;
    private String metodoExploracion;
    private int limiteProfundidad;

    public ExploradorVuelos(String metodoExploracion,HashMap<String, ArrayList<String>> conexiones) {
        this.metodoExploracion = metodoExploracion;
        this.conexiones = conexiones;
    }

    public ExploradorVuelos(String metodoExploracion, HashMap<String, ArrayList<String>> conexiones, int limiteProfundidad) {
        this.conexiones = conexiones;
        this.metodoExploracion = metodoExploracion;
        this.limiteProfundidad = limiteProfundidad;
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
        } else if(this.metodoExploracion.equalsIgnoreCase(PROFUNDIDAD_LIMITADA)){
            Nodo aux = nodosFrontera.removeLast(); //LIFO
            if(aux.getProfundidad()>limiteProfundidad){
                return null;
            }else{
                return aux;
            }
        }else {
            System.out.println("Metodo no valido: " + this.metodoExploracion);
            return null;
        }
    }
}
