package algoritmo.busqueda.noinformada;

import algoritmo.busqueda.IBusqueda;
import utilidades.exploradores.IExplorador;
import utilidades.Nodo;
import utilidades.Solucion;

import java.util.LinkedList;
import java.util.List;

public class AlgoritmoBusquedaNoInformada implements IBusqueda {

    /**
     *
     * @param datosIniciales    Valor del nodo raiz
     * @param solucionFinal     Valor del nodo solucion al que llegar
     * @param explorador        Clase con la funcion para buscar los nodos frontera de un nodo concreto
     * @return                  El nodo solucion del que recuperar el camino
     */
    public Solucion run(Object datosIniciales, Object solucionFinal, IExplorador explorador) {

        Nodo root = new Nodo(null, datosIniciales);
        Nodo solucion = new Nodo(null, solucionFinal);
        LinkedList<Nodo> nodosFrontera = new LinkedList<>();
        List<Nodo> nodosVisitados = new LinkedList<>();

        int nodosExplorados=0;
        LinkedList<Nodo> nuevaFrontera;

        nodosFrontera.add(root); //En la primera iteración se utiliza el nodo raíz como frontera
        Nodo nodoActual;
        Solucion nodoSolucion=null;

        while (!nodosFrontera.isEmpty() && nodoSolucion==null) { //Procesamos la lista de nodos frontera hasta vaciarla o encontrar solucion.

            nodoActual = explorador.siguienteNodo(nodosFrontera);

            if(nodoActual!=null){
                if(!nodosVisitados.contains(nodoActual)) { //Solamente se procesan los nodos no visitados.

                    nodosVisitados.add(nodoActual);

                    if (nodoActual.esSolucion(solucion)) { //Verificamos si el nodo actual es una solución
                        nodoSolucion = new Solucion(nodoActual, nodosVisitados.size(), nodosExplorados);
                    }
                    nuevaFrontera = explorador.explorarFrontera(nodoActual); //Calculo de la nueva frontera.
                    nodosExplorados += nuevaFrontera.size();
                    nodosFrontera.addAll(nuevaFrontera);
                }
            }
        }
        if(nodoSolucion==null){ //preparamos una solución con las estadísticas en caso de habere agotado la frontera sin encontrar solucion
            nodoSolucion = new Solucion(null,nodosVisitados.size(),nodosExplorados );
        }
        return nodoSolucion;
    }
}
