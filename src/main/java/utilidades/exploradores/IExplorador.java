package utilidades.exploradores;

import utilidades.Nodo;

import java.util.LinkedList;

public interface IExplorador {

    String AMPLITUD = "amplitud";
    String PROFUNDIDAD = "profundidad";
    String PROFUNDIDAD_LIMITADA = "profundidad_limitada";
    String COSTE_UNIFORME = "coste_uniforme";

    LinkedList<Nodo> explorarFrontera(Nodo nodo);

    Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera);
}
