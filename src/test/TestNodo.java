package test;

import utilidades.Nodo;

import java.util.LinkedList;

public class TestNodo {

    public static void main(String [] args){

        LinkedList <Nodo> arbol = new LinkedList<>();
        Nodo root = new Nodo(null, null, new String("A"));

        Nodo hijo1 = new Nodo(null,root,"A.1");
        Nodo hijo2 = new Nodo(root,"A.2");
        Nodo nietoA1 = new Nodo(null,hijo1,"A.1.1");


        System.out.println(root);
        System.out.println(hijo1);
        System.out.println(hijo2);
        System.out.println(nietoA1);


        System.out.println(root.getHijos());
        System.out.println(hijo1.getHijos());
        System.out.println(hijo2.getHijos());



    }
}
