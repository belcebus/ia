package factoria;

import utilidades.Nodo;

import java.util.LinkedList;

public interface IExplorador {

    public static final String AMPLITUD = "amplitud";
    public static final String PROFUNDIDAD = "profundidad";

    public LinkedList explorarFrontera(Nodo nodo);

    public Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera);
}
