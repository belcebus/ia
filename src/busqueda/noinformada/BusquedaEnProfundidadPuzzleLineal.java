package busqueda.noinformada;

import utilidades.Nodo;
import utilidades.Utils;

import java.util.LinkedList;

public class BusquedaEnProfundidadPuzzleLineal {

    public void run (String datosIniciales, String solucion){

        String[] opciones = {"I", "C", "D"}; //izquierda,derecha,centro

        Nodo raiz = new Nodo(null, null, datosIniciales);

        LinkedList<Nodo> nodosFrontera = new LinkedList<>();
        LinkedList<Nodo> nodosVisitados = new LinkedList<>();

        nodosFrontera.add(raiz);
        Nodo nodoActual;
        boolean solucionEncontrada = false;
        while(!nodosFrontera.isEmpty() && !solucionEncontrada) {
            nodoActual = nodosFrontera.removeLast();

            if(!Utils.nodoPresenteEnLista(nodoActual,nodosVisitados)){
                nodosVisitados.add(nodoActual);

                if(Utils.esSolucion(nodoActual, solucion)){
                    Utils.solucionEncontrada(nodoActual,nodosVisitados);
                    break;
                }

                for (int i = 0; i < opciones.length; i++) {
                    Nodo hijo = new Nodo(null, nodoActual, nodoActual.getValor());
                    intercambiar(hijo, opciones[i]);
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
            }
        }
    }
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
