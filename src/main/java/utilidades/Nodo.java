package utilidades;

public class Nodo {

    private Nodo padre;
    private String valor;

    public Nodo(Nodo padre, String valor) {
        this.padre = padre;
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public String toString(){
        String res=this.getValor().toString();
        return  res;
    }

    public int getProfundidad(){
        while(getPadre()!=null){
            return getPadre().getProfundidad() + 1;
        }
        return 0;
    }
    public void camino(){
        if(getPadre()!=null){
            getPadre().camino();
        }
        System.out.print(getValor() + " ");
    }

    public String getCamino(){

        if(getPadre()!=null){
            return getPadre().getCamino() +" "+ getValor();
        }
        return getValor();
    }

    public boolean equals(Object obj){
        if(obj instanceof Nodo) {
            return ((Nodo)obj).getValor().equalsIgnoreCase(getValor());
        }
        return false;
    }
}
