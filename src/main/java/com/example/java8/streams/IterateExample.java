package com.example.java8.streams;

import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class IterateExample {

    public static void main(String[] args) {

        Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n -> n + 1)
                .limit(10);

        tenNaturalNumbers.forEach(System.out::println);
    }
}
