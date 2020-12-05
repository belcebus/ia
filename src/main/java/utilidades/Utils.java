package utilidades;

import java.util.Iterator;
import java.util.List;

public class Utils {

    public static void solucionEncontrada(Nodo nodo, List<Nodo> nodosVisitados) {
        nodosVisitados.add(nodo);
        //System.out.println("Solucion encontrada: " + nodo);
        System.out.println("\nNodos descubiertos: " + nodosVisitados.size() + " -> " + nodosVisitados);
        System.out.print("Camino: "); nodo.camino();
    }

    public static boolean nodoPresenteEnLista(Nodo nodo, List<Nodo> nodos) {
        Iterator<Nodo> it = nodos.iterator();
        boolean nodoPresente = false;
        while (it.hasNext()) {
            if (it.next().getValor().equalsIgnoreCase(nodo.getValor())) {
                nodoPresente = true;
                break;
            }
        }
        return nodoPresente;
    }

    public static boolean esSolucion(Nodo nodoActual, String solucion) {
        return nodoActual.getValor().equalsIgnoreCase(solucion);
    }
}
