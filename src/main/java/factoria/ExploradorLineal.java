package factoria;

import utilidades.Nodo;

import java.util.LinkedList;

public class ExploradorLineal implements IExplorador {

    String metodoExploracion ;

    public ExploradorLineal(String metodoExploracion) {
        this.metodoExploracion = metodoExploracion;
    }

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

    @Override
    public Nodo siguienteNodo(LinkedList<Nodo> nodosFrontera) {

        if (this.metodoExploracion.equalsIgnoreCase(IExplorador.AMPLITUD)) {
            return nodosFrontera.removeFirst(); //FIFO
        } else if (this.metodoExploracion.equalsIgnoreCase(PROFUNDIDAD)) {
             return nodosFrontera.removeLast(); //LIFO
        } else {
            System.out.println("Metodo no valido: " + this.metodoExploracion);
            return null;
        }
    }
}
