package busqueda.noinformada;

import utilidades.Nodo;
import utilidades.Utils;

import java.util.LinkedList;
import java.util.List;

public class PuzzleLineal {

    public static final String AMPLITUD = "amplitud";
    public static final String PROFUNDIDAD = "profundidad";

    /**
     * Retorna el nodo solución del arbol de posibles soluciones.
     *
     * @param datosIniciales Cadena con las 4 piezas del puzzle
     * @param solucion       Cadena con las 4 piezas del puzle solucionado, el resultado buscado
     * @return Nodo con  la solucion
     */
    public Nodo run(String datosIniciales, String solucion, String method) {

        //Creación del nodo raiz
        Nodo root = new Nodo(null, datosIniciales);
        //Creación de los nodos frontera, cola FIFO
        LinkedList<Nodo> nodosFrontera = new LinkedList<Nodo>();
        //Creación de los nodos visitados
        List<Nodo> nodosVisitados = new LinkedList<Nodo>();

        //La primera iteración se introduce el nodo raiz como frontera
        nodosFrontera.add(root);
        Nodo nodoActual;

        //Se procesa la lista de nodos frontera hasta que ésta está vacía o se encuentra una solución

        while (!nodosFrontera.isEmpty()) {

            if (method.equalsIgnoreCase(AMPLITUD)) {
                //FIFO
                nodoActual = nodosFrontera.removeFirst();
            } else if (method.equalsIgnoreCase(PROFUNDIDAD)) {
                //LIFO
                nodoActual = nodosFrontera.removeLast();
            } else {
                System.out.println("Metodo no valido: " + method);
                return null;
            }

            //Solamente se procesan los nodos no visitados.
            if(!nodosVisitados.contains(nodoActual)){

                nodosVisitados.add(nodoActual);

                //Verificamos si el nodo actual es una solución
                if (Utils.esSolucion(nodoActual, solucion)) {
                    return nodoActual;
                }

                nodosFrontera.addAll(expandir(nodoActual));
            }
        }
        return null;
    }

    private LinkedList<Nodo> expandir(Nodo nodo) {
        LinkedList<Nodo> listaNodosHijos = new LinkedList<Nodo>();
        //debemos intercambiar todas las posisciones del valor del nodo
        for (int i = 0; i < nodo.getValor().length() - 1; i++) {
            char[] valor = nodo.getValor().toCharArray();

            char aux = valor[i + 1];
            valor[i + 1] = valor[i];
            valor[i] = aux;

            listaNodosHijos.add(new Nodo(nodo, String.valueOf(valor)));
        }

        return listaNodosHijos;
    }
}
