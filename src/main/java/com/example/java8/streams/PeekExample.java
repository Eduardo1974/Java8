package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eduardo on 05/11/17.
 */
public class PeekExample {

    public static void main(String[] args) {
        //Stream.peek
        List<Integer> list = Arrays.asList(10,11,12);
        list.stream().peek(i->System.out.println(i*i)).collect(Collectors.toList());
    }
}
