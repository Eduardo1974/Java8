package com.example.java8.defaultMethods;

/**
 * Created by eduardo on 05/11/17.
 */
public class MetodosDefult {

    public static void main(String[] args) {


        //JAVA 8 //METODO DEFAULT EM INTERFACES
        Implementacao implementacao = new Implementacao();
        implementacao.imprime();
    }
}

class Implementacao implements MetodoDefault {

}

interface MetodoDefault {

    default void imprime() {  //METODO DEFAULT EM INTERFACES
        System.out.println("metodo default");
    }
}

