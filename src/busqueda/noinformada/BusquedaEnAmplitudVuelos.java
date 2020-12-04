package busqueda.noinformada;

import utilidades.Nodo;
import utilidades.Utils;

import java.util.*;

//Cada nivel es un transbordo
public class BusquedaEnAmplitudVuelos {

    public void run(String estadoInicial, String solucion, HashMap<String,ArrayList<String>> conexiones){

        LinkedList<Nodo> nodosFrontera = new LinkedList<Nodo>();
        LinkedList<Nodo> nodosVisitados = new LinkedList<Nodo>();

        Nodo raiz = new Nodo(null, null, estadoInicial);
        nodosFrontera.add(raiz);
        boolean solucionEncontrada = false;
        while(!nodosFrontera.isEmpty() && !solucionEncontrada){
            Nodo nodoActual = nodosFrontera.removeFirst();

            if(Utils.esSolucion(nodoActual,solucion)){
                Utils.solucionEncontrada(nodoActual,nodosVisitados);
                break;
            }

            nodosVisitados.add(nodoActual);
            //expandimos: los hijos son las conexiones
            Iterator hijos = conexiones.get((String)nodoActual.getValor()).iterator();
            while(hijos.hasNext()){
                Nodo hijo = new Nodo(null, nodoActual, (String)hijos.next());

                if(Utils.esSolucion(hijo,solucion)){
                    Utils.solucionEncontrada(hijo,nodosVisitados);
                    solucionEncontrada=true;
                }

                if(!Utils.nodoPresenteEnLista(hijo,nodosFrontera) && !Utils.nodoPresenteEnLista(hijo,nodosVisitados)){
                    nodosFrontera.add(hijo);
                }
            }
        }
    }
}
