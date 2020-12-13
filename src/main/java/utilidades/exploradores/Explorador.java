package utilidades.exploradores;

import utilidades.Nodo;

import java.util.LinkedList;

public abstract class Explorador implements IExplorador{

    protected final String metodoExploracion;
    protected int limiteProfundidad;

    public Explorador(String metodoExploracion) {
        this.metodoExploracion = metodoExploracion;
    }

    public Explorador(String metodoExploracion, int limiteProfundidad) {
        this.metodoExploracion = metodoExploracion;
        this.limiteProfundidad = limiteProfundidad;
    }

    @Override
    public abstract LinkedList<Nodo> explorarFrontera(Nodo nodo);

    @Override
    public Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera) {
        if (this.metodoExploracion.equalsIgnoreCase(IExplorador.AMPLITUD)) {
            return nodosFrontera.removeFirst(); //FIFO
        } else if (this.metodoExploracion.equalsIgnoreCase(PROFUNDIDAD)) {
            return nodosFrontera.removeLast(); //LIFO
        } else if (this.metodoExploracion.equalsIgnoreCase(PROFUNDIDAD_LIMITADA)){
            Nodo aux = nodosFrontera.removeLast(); //LIFO
            if(aux.getProfundidad()>limiteProfundidad){
                return null;
            }else{
                return aux;
            }
        } else if(metodoExploracion.equalsIgnoreCase(IExplorador.COSTE_UNIFORME)){
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
