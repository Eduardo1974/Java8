package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class DistinctExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("AA","AA","BB");

        long l = list.stream().distinct().count();
        System.out.println("Number of distinct element:"+l);
    }
}
