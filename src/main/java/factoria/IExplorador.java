package factoria;

import utilidades.Nodo;

import java.util.LinkedList;

public interface IExplorador {

    public static final String AMPLITUD = "amplitud";
    public static final String PROFUNDIDAD = "profundidad";
    public static final String PROFUNDIDAD_LIMITADA = "profundidad_limitada";
    public static final String PROFUNDIDAD_ITERATIVA = "profundidad_iterativa";

    public LinkedList explorarFrontera(Nodo nodo);

    public Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera);
}
