package utilidades.exploradores;

import utilidades.Nodo;

import java.util.LinkedList;

public class ExploradorLineal extends Explorador {

    public ExploradorLineal(String metodoExploracion) {
        super(metodoExploracion);
    }

    public ExploradorLineal(String metodoExploracion, int limiteProfundidad) {
        super(metodoExploracion, limiteProfundidad);
    }

    @Override
    public LinkedList<Nodo> explorarFrontera(Nodo nodo) {
        LinkedList<Nodo> listaNodosHijos = new LinkedList<>();
        //debemos intercambiar todas las posisciones del valor del nodo
        for (int i = 0; i < ((String)nodo.getValor()).length() - 1; i++) {
            char[] valor = ((String)nodo.getValor()).toCharArray();
            char aux = valor[i + 1];
            valor[i + 1] = valor[i];
            valor[i] = aux;
            listaNodosHijos.add(new Nodo(nodo, String.valueOf(valor)));
        }
        return listaNodosHijos;
    }
}
