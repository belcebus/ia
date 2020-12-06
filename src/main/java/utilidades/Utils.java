package utilidades;

import java.util.List;

public class Utils {

    public static void solucionEncontrada(Nodo nodo, List<Nodo> nodosVisitados) {
        //nodosVisitados.add(nodo);
        //System.out.println("Solucion encontrada: " + nodo);
        //System.out.println("\nNodos descubiertos: " + nodosVisitados.size() + " -> " + nodosVisitados);

        System.out.print("Profundidad: " + nodo.getProfundidad() +" Camino: "); nodo.camino();
    }
}
