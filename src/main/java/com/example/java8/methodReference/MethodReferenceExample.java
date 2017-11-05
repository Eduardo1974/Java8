package com.example.java8.methodReference;

import com.example.java8.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by eduardo on 05/11/17.
 */
public class MethodReferenceExample {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList();
        palavras.add("eduardo");
        palavras.add("pai");
        palavras.add("goleta");

        //Comparator com lamda 1
        palavras.sort(Comparator.comparingInt(String::length)); //INVOCANDO O METODO lenght() da classe String

        //Comparator com lamda 2
        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length)); //INVOCANDO O METODO lenght() da classe String

        //INVOCANDO O METODO lenght() da classe String
        Function<String, Integer> funcao2 = String::length;

        //INVOCANDO O METODO lenght() da classe String com lambda
        Function<String, Integer> funcao3 = s -> s.length();

        //SEM LAMBDA
        Function<String, Integer> funcao = new Function<String, Integer> (){

            @Override
            public Integer apply(String o) {
                return o.length();
            }
        };
        Comparator<String> comparator = Comparator.comparing(funcao);
        palavras.sort(comparator);

        System.out.println(palavras);
        palavras.forEach(System.out::print); //METHOD REFERENCE

        Function<Person, String> personStringFunction = u -> u.getNome(); //LAMBDA
        Function<Person, String> personStringFunction2 = Person::getNome; //METHOD REFERENCE

        palavras.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(palavras);

    }
}

