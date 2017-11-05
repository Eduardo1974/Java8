package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class LimitExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA","BB","CC","DD","EE");
        list.stream().limit(3).forEach(s->System.out.println(s));
    }
}
