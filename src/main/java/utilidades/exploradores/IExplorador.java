package utilidades.exploradores;

import utilidades.Nodo;

import java.util.LinkedList;

public interface IExplorador {

    String AMPLITUD = "amplitud";
    String PROFUNDIDAD = "profundidad";
    String PROFUNDIDAD_LIMITADA = "profundidadlimitada";
    String COSTE_UNIFORME = "costeuniforme";

    LinkedList<Nodo> explorarFrontera(Nodo nodo);

    Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera);
}
