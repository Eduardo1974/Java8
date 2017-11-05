package com.example.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class MaxMinExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("G","B","F","E");

        String max = list.stream().max(Comparator.comparing(String::valueOf)).get();
        System.out.println("Max:"+ max);

        String min = list.stream().min(Comparator.comparing(String::valueOf)).get();
        System.out.println("Min:"+ min);
    }
}
