package busqueda.noinformada;

import factoria.IExplorador;
import utilidades.Nodo;

import java.util.LinkedList;
import java.util.List;

public class AlgoritmoBusqueda {

    public static final String AMPLITUD = "amplitud";
    public static final String PROFUNDIDAD = "profundidad";

    /**
     *
     * @param datosIniciales
     * @param sol
     * @param method
     * @param explorador
     * @return
     */
    public Nodo run(String datosIniciales, String sol, String method, IExplorador explorador) {

        Nodo root = new Nodo(null, datosIniciales);
        Nodo solucion = new Nodo(null, sol);
        LinkedList<Nodo> nodosFrontera = new LinkedList<Nodo>();
        List<Nodo> nodosVisitados = new LinkedList<Nodo>();

        nodosFrontera.add(root); //En la primera iteración se utiliza el nodo raíz como frontera
        Nodo nodoActual;

        while (!nodosFrontera.isEmpty()) { //Procesamos la lista de nodos frontera hasta vaciarla o encontrar solucion.

            if (method.equalsIgnoreCase(AMPLITUD)) {
                nodoActual = nodosFrontera.removeFirst(); //FIFO
            } else if (method.equalsIgnoreCase(PROFUNDIDAD)) {
                nodoActual = nodosFrontera.removeLast(); //LIFO
            } else {
                System.out.println("Metodo no valido: " + method);
                return null;
            }

            if(!nodosVisitados.contains(nodoActual)){ //Solamente se procesan los nodos no visitados.

                nodosVisitados.add(nodoActual);

                if (nodoActual.equals(solucion)) { //Verificamos si el nodo actual es una solución
                    return nodoActual;
                }
                nodosFrontera.addAll(explorador.explorarFrontera(nodoActual)); //Calculo de la nueva frontera.
            }
        }
        return null;
    }
}
