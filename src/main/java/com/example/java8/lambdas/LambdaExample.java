package com.example.java8.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class LambdaExample {

    public static void main(String[] args) {


        //LAMBDA  = INTERFACE FUNCIONAL =  1 único método abstrato. Além desse método ela pode ter outros métodos, contanto que sejam default.
        //EXEMPLO DE INTERFACE FUNCIONAL (CONSUMER)

        List<String> palavras = new ArrayList();
        palavras.add("eduardo");
        palavras.add("pai");
        palavras.add("goleta");

        //Comparator com lamda feio
        palavras.sort((s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            }
            if (s1.length() > s2.length()) {
                return 1;
            }
            return 0;
        });

        //Comparator com lamda
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        //Comparator com lamda bonito
        palavras.sort(Comparator.comparingInt(String::length));

        //CONSUMER COM LAMBDA
        palavras.forEach(s -> System.out.println(s));

        //THREAD NORMAL
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }

        }).start();

        //THREAD COM LAMMBDA
        new Thread(() -> System.out.println("Executando um Runnable")).start();
    }
}

