package utilidades.exploradores;

import utilidades.Nodo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ExploradorViajante implements IExplorador{

    private HashMap<String, HashMap<String, Integer>> conexiones;
    private String metodoExploracion;

    public ExploradorViajante( String metodoExploracion, HashMap<String, HashMap<String, Integer>> conexiones) {
        this.conexiones = conexiones;
        this.metodoExploracion = metodoExploracion;
    }

    @Override
    public LinkedList explorarFrontera(Nodo nodo) {
        LinkedList<Nodo> nuevaFrontera = new LinkedList<>();
        HashMap<String, Integer> destinos = conexiones.get(nodo.getValor());

        Iterator<String> it = destinos.keySet().iterator();
        String destino;
        while(it.hasNext()){
            destino=it.next();
            Nodo nuevoDestino = new Nodo(nodo, destino, nodo.getCoste() + destinos.get(destino));
            nuevaFrontera.add(nuevoDestino);
        }
        return nuevaFrontera;
    }

    @Override
    public Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera) {
        //debería retornar el nodo con menor coste.

        Iterator<Nodo> it = nodosFrontera.iterator();
        Nodo nodoActual;
        Nodo nodoMinimo=null;
        int costeMinimo=Integer.MAX_VALUE;

        while(it.hasNext()) {
            nodoActual=it.next();
            if(nodoActual.getCoste()<costeMinimo){
                nodoMinimo=nodoActual;
                costeMinimo=nodoActual.getCoste();
            }
        }

        nodosFrontera.remove(nodoMinimo);
        return nodoMinimo;
    }
}
