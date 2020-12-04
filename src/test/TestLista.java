package test;

import java.util.LinkedList;
import java.util.List;

public class TestLista {

    public static void main (String[] args){

        LinkedList<String> lista = new LinkedList<>(List.of("a","b","c","d"));
        System.out.println(lista);
        System.out.println(lista.getLast());
        System.out.println(lista.removeLast());
        System.out.println(lista);

    }
}
