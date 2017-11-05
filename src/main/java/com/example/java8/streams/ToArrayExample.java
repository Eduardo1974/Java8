package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class ToArrayExample {

    public static void main(String[] args) {
        Object[] ob = Stream.of("A","B","C","D").toArray();
        for (Object o : ob) {
            System.out.println(o.toString());
        }
    }
}
