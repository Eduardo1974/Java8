package com.example.java8.streams;

import com.example.java8.model.Item;

import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class GenerateExample {

    public static void main(String[] args) {

        Item item = new Item("AA");
        Stream<String> stream = Stream.generate(item::getName);
        stream.limit(3).forEach(s -> System.out.println(s));
    }
}
