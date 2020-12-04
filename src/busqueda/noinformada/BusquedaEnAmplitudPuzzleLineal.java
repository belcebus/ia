package busqueda.noinformada;

import utilidades.Nodo;
import utilidades.Utils;

import java.util.*;

//Puzzle Lineal
public class BusquedaEnAmplitudPuzzleLineal {

    public void run(String datosIniciales, String solucion) {

        String[] opciones = {"I", "C", "D"}; //izquierda,derecha,centro

        //Creación del nodo raiz
        Nodo root = new Nodo(null, null, datosIniciales);
        //Creación de los nodos frontera, cola FIFO
        LinkedList<Nodo> nodosFrontera = new LinkedList<Nodo>();
        //Creación de los nodos visitados
        List<Nodo> nodosVisitados = new LinkedList<Nodo>();

        //La primera iteración se introduce el nodo raiz como frontera
        nodosFrontera.add(root);
        Nodo nodoActual;

        //Se procesa la lista de nodos frontera hasta que ésta está vacía o se encuentra una solución
        boolean solucionEncontrada = false;
        while (!nodosFrontera.isEmpty() && !solucionEncontrada) {

            //System.out.println("Nodos Frontera: " + nodosFrontera);

            //Recuperamos un nodo frontera de la lista (FIFO)
            nodoActual = nodosFrontera.removeFirst();

            //Si el nodo se encuentra entre la lita de visitados, lo saltaremos para no caer en un posible bucle.
            if (!Utils.nodoPresenteEnLista(nodoActual, nodosVisitados)) {
                //System.out.println("Procesando nodo: " + nodoActual);
                nodosVisitados.add(nodoActual);

                //Verificamos si el nodo actual es una solución
                if (Utils.esSolucion(nodoActual, solucion)) {
                    Utils.solucionEncontrada(nodoActual, nodosVisitados);
                    break;
                }

                //Como el nodo actual no es una solución, expandimos. La expansión se hace mediante la aplicación de los
                //operadores disponibles.
                for (int i = 0; i < opciones.length; i++) {
                    Nodo hijo = new Nodo(null, nodoActual, nodoActual.getValor());
                    intercambiar(hijo, opciones[i]);
                    //un nuevo nodo fruto de la expansion es añadido a la lista de fronteras si no existía previmente o
                    // no había sido explorado.
                    if (!Utils.nodoPresenteEnLista(hijo, nodosVisitados) && !Utils.nodoPresenteEnLista(hijo, nodosFrontera )) {
                        //System.out.println("Hijo: " + hijo + " añadido a la frontera");
                        nodosFrontera.add(hijo);
                    }
                    //podemos verificar si una expasión ya es solución
                    if (Utils.esSolucion(hijo, solucion)) {
                        Utils.solucionEncontrada(hijo, nodosVisitados);
                        solucionEncontrada=true;
                        break;
                    }
                }
            } else {
                System.out.println("El nodo " + nodoActual + " ya había sido visitado, saltando");
            }
        }
    }

    /*
        FUNCIONES DE APOYO Y PARA EL CALCULO DE LA EXPACION DEL NODO.
     */
    private void intercambiar(Nodo nodo, String opcion) {
        //System.out.println("Aplicando opcion: " + opcion);
        char[] caracteres = nodo.getValor().toCharArray();
        char aux;
        if (opcion.equalsIgnoreCase("D")) {
            aux = caracteres[3];
            caracteres[3] = caracteres[2];
            caracteres[2] = aux;
        } else if (opcion.equalsIgnoreCase("I")) {
            aux = caracteres[0];
            caracteres[0] = caracteres[1];
            caracteres[1] = aux;
        } else if (opcion.equalsIgnoreCase("C")) {
            aux = caracteres[1];
            caracteres[1] = caracteres[2];
            caracteres[2] = aux;
        } else {
            System.out.println("opcion no reconocida");
        }

        nodo.setValor(String.copyValueOf(caracteres));
    }
}
