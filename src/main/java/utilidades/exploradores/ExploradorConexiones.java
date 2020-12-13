package utilidades.exploradores;

import utilidades.Nodo;

import java.util.HashMap;
import java.util.LinkedList;

public class ExploradorConexiones extends Explorador{

    private final HashMap<String, HashMap<String, Integer>> conexiones;

    public ExploradorConexiones(String metodoExploracion, HashMap<String, HashMap<String, Integer>> conexiones) {
        super(metodoExploracion);
        this.conexiones=conexiones;
    }

    public ExploradorConexiones(String metodoExploracion, HashMap<String, HashMap<String, Integer>> conexiones, int limiteProfundidad) {
        super(metodoExploracion, limiteProfundidad);
        this.conexiones=conexiones;
    }

    @Override
    public LinkedList<Nodo> explorarFrontera(Nodo nodo) {
        LinkedList<Nodo> nuevaFrontera = new LinkedList<>();
        HashMap<String, Integer> destinos = conexiones.get(nodo.getValor());

        String destino;
        for (String s : destinos.keySet()) {
            destino = s;
            Nodo nuevoDestino = new Nodo(nodo, destino, nodo.getCoste() + destinos.get(destino));
            nuevaFrontera.add(nuevoDestino);
        }
        return nuevaFrontera;
    }
}
