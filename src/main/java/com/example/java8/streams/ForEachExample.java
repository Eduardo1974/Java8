package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class ForEachExample {

    public static void main(String[] args) {

        //Stream.forEach and Stream.forEachOrdered
        System.out.println("forEach Demo");
        Stream.of("BBB","AAA","CCC").forEach(s->System.out.println("Output:"+s));

        System.out.println("forEachOrdered Demo");
        Stream.of("AAA","BBB","CCC").forEachOrdered(s->System.out.println("Output:"+s));

        //Stream.peek
        List<Integer> list = Arrays.asList(10,11,12);
        list.stream().peek(i->System.out.println(i*i)).collect(Collectors.toList());

        //Stream.skip
        List<String> list2 = Arrays.asList("AA","BB","CC","DD");
        list2.stream().skip(3).forEach(s->System.out.println(s));

        //Stream.toArray
        Object[] ob = Stream.of("A","B","C","D").toArray();
        for (Object o : ob) {
            System.out.println(o.toString());
        }
    }
}
