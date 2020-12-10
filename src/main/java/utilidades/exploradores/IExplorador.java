package utilidades.exploradores;

import utilidades.Nodo;

import java.util.LinkedList;

public interface IExplorador {

    public static final String AMPLITUD = "amplitud";
    public static final String PROFUNDIDAD = "profundidad";
    public static final String PROFUNDIDAD_LIMITADA = "profundidad_limitada";
    public static final String COSTE_UNIFORME = "coste_uniforme";

    public LinkedList explorarFrontera(Nodo nodo);

    public Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera);
}
