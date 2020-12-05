package utilidades;

import java.util.LinkedList;

public class Nodo {

    private LinkedList<Nodo> hijos;
    private Nodo padre;
    private String valor;

    public Nodo(LinkedList<Nodo> hijos, Nodo padre, String valor) {
        this.hijos = hijos;
        this.padre = padre;
        if(padre!=null){
            padre.insertarHijo(this);
        }
        this.valor = valor;
    }

    public Nodo(Nodo padre, String valor) {
        this.hijos = null;
        this.padre = padre;
        if(padre!=null){
            padre.insertarHijo(this);
        }
        this.valor = valor;
    }

    public void insertarHijo(Nodo hijo){
        if(getHijos()==null){
            setHijos(new LinkedList<Nodo>());
        }
        getHijos().add(hijo);
    }

    public void eliminarHijo(Nodo hijo){
        if(getHijos().contains(hijo)){
            this.hijos.remove(hijo);
        }
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(LinkedList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public String toString(){
        String res=this.getValor().toString();
       /*
        if(this.getPadre()!=null){
            res += " | Padre:[" + this.getPadre().toString() +"]";
        }
        */
        return  res;
    }

    public void camino(){
        if(getPadre()!=null){
            getPadre().camino();
        }
        System.out.print(" " + getValor() + " ");
    }
}
