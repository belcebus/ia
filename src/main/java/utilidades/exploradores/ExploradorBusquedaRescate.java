package utilidades.exploradores;

import utilidades.Coordenada;
import utilidades.Nodo;

import java.util.LinkedList;

public class ExploradorBusquedaRescate extends Explorador{

    public ExploradorBusquedaRescate(String metodoExploracion) {
        super(metodoExploracion);
    }

    public ExploradorBusquedaRescate(String metodoExploracion, int limiteProfundidad) {
        super(metodoExploracion, limiteProfundidad);
    }

    @Override
    public LinkedList<Nodo> explorarFrontera(Nodo nodo) {
        LinkedList<Nodo> listaNodosHijos = new LinkedList<>();
        int x = ((Coordenada)nodo.getValor()).getX();
        int y = ((Coordenada)nodo.getValor()).getY();

        Coordenada cordenadaNorte = new Coordenada(x,y+1);
        Coordenada cordenadaSur = new Coordenada(x,y-1);
        Coordenada coordenadaEste = new Coordenada(x+1,y);
        Coordenada coordenadaOeste = new Coordenada(x-1,y);

        Nodo nodoNorte = new Nodo(nodo,cordenadaNorte);
        Nodo nodoSur = new Nodo(nodo,cordenadaSur);
        Nodo nodoEste = new Nodo(nodo,coordenadaEste);
        Nodo nodoOeste = new Nodo(nodo,coordenadaOeste);

        listaNodosHijos.add(nodoNorte);
        listaNodosHijos.add(nodoSur);
        listaNodosHijos.add(nodoEste);
        listaNodosHijos.add(nodoOeste);

        return listaNodosHijos;
    }
}
