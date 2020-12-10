package busqueda.noinformada;

import factoria.IExplorador;
import utilidades.Nodo;
import utilidades.Solucion;

import java.util.LinkedList;
import java.util.List;

public class AlgoritmoBusqueda {

    /**
     *
     * @param datosIniciales    Valor del nodo raiz
     * @param solucionFinal     Valor del nodo solucion al que llegar
     * @param explorador        Clase con la funcion para buscar los nodos frontera de un nodo concreto
     * @return                  El nodo solucion del que recuperar el camino
     */
    public Solucion run(String datosIniciales, String solucionFinal, IExplorador explorador) {

        Nodo root = new Nodo(null, datosIniciales);
        Nodo solucion = new Nodo(null, solucionFinal);
        LinkedList<Nodo> nodosFrontera = new LinkedList<>();
        List<Nodo> nodosVisitados = new LinkedList<>();

        int nodosExplorados=0;
        LinkedList<Nodo> nuevaFrontera;

        nodosFrontera.add(root); //En la primera iteración se utiliza el nodo raíz como frontera
        Nodo nodoActual;

        while (!nodosFrontera.isEmpty()) { //Procesamos la lista de nodos frontera hasta vaciarla o encontrar solucion.

            nodoActual = explorador.siguienteNodo(nodosFrontera);

            if(nodoActual==null){
                return new Solucion(null,nodosVisitados.size(),nodosExplorados ); //Hemos llegado al final de la frontera (limite en profundidad)
            }

            if(!nodosVisitados.contains(nodoActual)){ //Solamente se procesan los nodos no visitados.

                nodosVisitados.add(nodoActual);

                if (nodoActual.equals(solucion)) { //Verificamos si el nodo actual es una solución
                    return new Solucion(nodoActual,nodosVisitados.size(),nodosExplorados);
                }
                nuevaFrontera = explorador.explorarFrontera(nodoActual); //Calculo de la nueva frontera.
                nodosExplorados += nuevaFrontera.size();
                nodosFrontera.addAll(nuevaFrontera);

            }
        }
        return null;
    }
}
