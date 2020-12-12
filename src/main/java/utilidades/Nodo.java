package utilidades;

public class Nodo {

    private Nodo padre;
    private Object valor;
    private int coste;

    public Nodo(Nodo padre, Object valor) {
        this.padre = padre;
        this.valor = valor;
    }

    public Nodo(Nodo padre, String valor, int coste) {
        this.padre = padre;
        this.valor = valor;
        this.coste = coste;
    }

    public int getCoste() { return coste; }

    public void setCoste(int coste) { this.coste = coste; }

    public Object getValor() {
        if(this.valor instanceof String)
            return (String)valor;
        return this.valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public String toString() {
        return (String)this.getValor();
    }

    public int getProfundidad() {
        if (getPadre() != null) {
            return getPadre().getProfundidad() + 1;
        }
        return 0;
    }

    public String getCamino() {

        if (getPadre() != null) {
            return getPadre().getCamino() + " " + getValor().toString();
        }
        return getValor().toString();
    }

    public int getCosteCamino(){

        if(getPadre()!=null){
            return getPadre().getCosteCamino() + getCoste();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Nodo) {
            if(((Nodo) obj).getValor() instanceof String){
                return ((String)((Nodo) obj).getValor()).equalsIgnoreCase((String)getValor());
            }else{
                return ((Nodo) obj).getValor().equals(getValor());
            }
        }
        return false;
    }
}