package factoria;

import utilidades.Nodo;

import java.util.LinkedList;

public class ExploradorLineal implements IExplorador {

    @Override
    public LinkedList explorarFrontera(Nodo nodo) {
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
