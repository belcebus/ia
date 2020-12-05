package busqueda.noinformada;

import utilidades.Nodo;
import utilidades.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class BusquedaEnProfundidadVuelos {

    public void run(String estadoInicial, String solucion, Map<String,ArrayList<String>> conexiones){
        LinkedList<Nodo> nodosFrontera = new LinkedList<Nodo>();
        LinkedList<Nodo> nodosVisitados = new LinkedList<Nodo>();

        Nodo raiz = new Nodo(null, estadoInicial);
        nodosFrontera.add(raiz);
        boolean solucionEncontrada = false;
        while(!nodosFrontera.isEmpty() && !solucionEncontrada){
            Nodo nodoActual = nodosFrontera.removeLast();

            if(Utils.esSolucion(nodoActual,solucion)){
                Utils.solucionEncontrada(nodoActual,nodosVisitados);
                break;
            }

            nodosVisitados.add(nodoActual);
            //expandimos: los hijos son las conexiones
            Iterator hijos = conexiones.get((String)nodoActual.getValor()).iterator();
            while(hijos.hasNext()){
                Nodo hijo = new Nodo(nodoActual, (String)hijos.next());

                if(Utils.esSolucion(hijo,solucion)){
                    Utils.solucionEncontrada(hijo,nodosVisitados);
                    solucionEncontrada=true;
                }

                if(!nodosFrontera.contains(hijo) && !nodosVisitados.contains(hijo)){
                    nodosFrontera.add(hijo);
                }
            }
        }
    }
}
