package com.example.java8.streams;

import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class EmptyExample {

    public static void main(String[] args) {
        Stream<String> s = Stream.empty(); //instancia uma lista vazia
        s.limit(10)
                .forEach(System.out::println);

    }
}
