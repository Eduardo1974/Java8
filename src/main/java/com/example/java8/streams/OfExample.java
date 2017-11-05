package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class OfExample {

    public static void main(String[] args) {

        //Stream.of()
        Stream.of("Ram","Shyam","Mohan").forEach(s->System.out.println(s));

        List<String> list1 = Arrays.asList("AAA","BBB");
        List<String> list2 = Arrays.asList("CCC","DDD");
        Stream.of(list1,list2).flatMap(list -> list.stream()).forEach(s->System.out.println(s));
    }
}
