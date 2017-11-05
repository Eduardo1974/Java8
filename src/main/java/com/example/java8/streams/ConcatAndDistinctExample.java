package com.example.java8.streams;

import com.example.java8.model.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class ConcatAndDistinctExample {

    public static void main(String[] args) {

        //Simple
        Stream<String> s1 = Stream.of("AA", "BB", "CC");
        Stream<String> s2 = Stream.of("AA", "BB", "DD");

        Stream<String> s = Stream.concat(s1, s2);
        s.forEach(e->System.out.print(e+" "));

        //Remove duplicates using distinct()
        s1 = Stream.of("AA", "BB", "CC");
        s2 = Stream.of("AA", "BB", "DD");
        System.out.println("\nRemove duplicates using distinct()");
        s = Stream.concat(s1, s2).distinct();
        s.forEach(e->System.out.print(e+" "));

        //Lists
        List<Book> list1 = new ArrayList<>();
        List<Book> list2 = new ArrayList<>();
        {
            list1.add(new Book("Core Java", 200));
            list1.add(new Book("Spring MVC", 300));
            list1.add(new Book("Learning Freemarker", 150));

            list2.add(new Book("Core Java", 200));
            list2.add(new Book("Spring MVC", 300));
            list2.add(new Book("Learning Hibernate", 400));
        }
        List<Book> list = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        list.forEach(b->System.out.println(b.getName()+", "+ b.getPrice()));

        //Remove duplicates using distinct()
        System.out.println("--Remove duplicates using distinct()--");
        list = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        list.forEach(b->System.out.println(b.getName()+", "+ b.getPrice()));


        //Sets
        Set<Book> set1 = new HashSet<>();
        Set<Book> set2 = new HashSet<>();
        {
            set1.add(new Book("Core Java", 200));
            set1.add(new Book("Spring MVC", 300));
            set1.add(new Book("Learning Freemarker", 150));

            set2.add(new Book("Core Java", 200));
            set2.add(new Book("Spring MVC", 300));
            set2.add(new Book("Learning Hibernate", 400));
        }
        Set<Book> set = Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
        set.forEach(b->System.out.println(b.getName()+", "+ b.getPrice()));
    }
}
