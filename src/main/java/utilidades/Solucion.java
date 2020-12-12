package utilidades;

public class Solucion {

    private Nodo nodoSolucion;
    private int nodosVisitados;
    private int nodosExplorados;

    public Solucion(Nodo nodoSolucion, int nodosVisitados, int nodosExplorados) {
        this.nodoSolucion = nodoSolucion;
        this.nodosVisitados = nodosVisitados;
        this.nodosExplorados = nodosExplorados;
    }

    public int getNodosVisitados(){
        return nodosVisitados;
    }
    public int getNodosExplorados(){
        return nodosExplorados;
    }
    public int getProfundidad(){
        if(nodoSolucion!=null) {
            return nodoSolucion.getProfundidad();
        }else{
            return -1;
        }
    }
    public String getCamino(){
        if(nodoSolucion!=null){
            return nodoSolucion.getCamino();
        }else{
            return "";
        }
    }
    public int getCoste(){
        if(nodoSolucion!=null){
            return nodoSolucion.getCoste();
        }else{
            return -1;
        }
    }

    public String toString(){
        String res = "Profundidad: " + getProfundidad() +
                "\nCamino:      " + getCamino() +
                "\nVisitados:   " + getNodosVisitados() +
                "\nExplorados:  " + getNodosExplorados();
        if(getCoste()>0){
            res += "\nCoste:       " + getCoste();
        }

        return res;
    }
}
