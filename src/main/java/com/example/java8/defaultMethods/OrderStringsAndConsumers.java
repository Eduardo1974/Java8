package com.example.java8.defaultMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by eduardo on 05/11/17.
 */
public class OrderStringsAndConsumers {

    public static void main(String[] args) {

        //JEITO ANTIGO
        List<String> palavras = new ArrayList();
        palavras.add("eduardo");
        palavras.add("pai");
        palavras.add("goleta");

        Collections.sort(palavras); //comparacao padrao
        System.out.println(palavras);

        Comparator comparator = new ComparadorPorTamanho();
        Collections.sort(palavras, comparator); //comparacao por tamanho
        System.out.println(palavras);

        //JAVA 8
        palavras.sort(comparator);
        System.out.println(palavras);

        //JEITO ANTIGO
        for (String palavra : palavras) {
            System.out.println(palavra);
        }

        //JAVA 8 CONSUMER COM LAMBDA
        //CONSUMER FAZ A EXECUCAO DO FOR
        Consumer consumer = new ImprimeLinha();
        palavras.forEach(consumer);

        //JAVA 8 SEM IMPLEMENTAR CLASSE CONSUMER COM LAMBDA
        Consumer<String> consumidor = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        palavras.forEach(consumidor);

        //JAVA 8 CONSUMER COM LAMBDA
        Consumer<String> consumidor2 = s -> {
            System.out.println("teste");
            System.out.println(s);
        };
        palavras.forEach(consumidor2);

    }
}

class ImprimeLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) {
            return -1;
        }
        if(s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}

