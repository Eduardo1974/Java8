package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class SortedExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("DC","CD","AD");
        list.stream().sorted().forEach(s->System.out.println(s));
    }
}
