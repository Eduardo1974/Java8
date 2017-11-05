package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eduardo on 05/11/17.
 */
public class SkipExample {

    public static void main(String[] args) {
        //Stream.skip
        List<String> list2 = Arrays.asList("AA","BB","CC","DD");
        list2.stream().skip(3).forEach(s->System.out.println(s));
    }
}
