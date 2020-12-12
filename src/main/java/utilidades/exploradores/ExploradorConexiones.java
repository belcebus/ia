package utilidades.exploradores;

import utilidades.Nodo;

import java.util.HashMap;
import java.util.LinkedList;

public class ExploradorConexiones implements IExplorador{

    private final HashMap<String, HashMap<String, Integer>> conexiones;
    private final String metodoExploracion;
    private int limiteProfundidad;

    public ExploradorConexiones(String metodoExploracion, HashMap<String, HashMap<String, Integer>> conexiones) {
        this.conexiones = conexiones;
        this.metodoExploracion = metodoExploracion;
    }

    public ExploradorConexiones(String metodoExploracion, HashMap<String, HashMap<String, Integer>> conexiones, int limiteProfundidad) {
        this.conexiones = conexiones;
        this.metodoExploracion = metodoExploracion;
        this.limiteProfundidad = limiteProfundidad;
    }

    @Override
    public LinkedList<Nodo> explorarFrontera(Nodo nodo) {
        LinkedList<Nodo> nuevaFrontera = new LinkedList<>();
        HashMap<String, Integer> destinos = conexiones.get(nodo.getValor());

        String destino;
        for (String s : destinos.keySet()) {
            destino = s;
            Nodo nuevoDestino = new Nodo(nodo, destino, nodo.getCoste() + destinos.get(destino));
            nuevaFrontera.add(nuevoDestino);
        }
        return nuevaFrontera;
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
        }else if(metodoExploracion.equalsIgnoreCase(IExplorador.COSTE_UNIFORME)){
            // COLA CON PRIORIDAD.
            Nodo nodoMinimo=null;
            int costeMinimo=Integer.MAX_VALUE;

            Nodo nodoActual;
            for (Nodo nodo : nodosFrontera) {
                nodoActual = nodo;
                if (nodoActual.getCoste() < costeMinimo) {
                    nodoMinimo = nodoActual;
                    costeMinimo = nodoActual.getCoste();
                }
            }
            nodosFrontera.remove(nodoMinimo);
            return nodoMinimo;
        }else{
            System.out.println("Metodo no valido: " + this.metodoExploracion);
            return null;
        }
    }
}
