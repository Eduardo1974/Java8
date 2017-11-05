package com.example.java8.streams;

import com.example.java8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eduardo on 05/11/17.
 */
public class FilterExample {

    public static void main(String[] args) {

        //Stream filter() with findFirst(), orElse() and forEach()

        List<User> list = User.getUsers();

        System.out.println("Using findFirst() ---");

        User user = list.stream().filter(u -> u.getName().endsWith("sh"))
                .findFirst().orElse(null);
        System.out.println(user.getName());

        System.out.println("Using forEach() ---");

        list.stream().filter(u -> u.getName().endsWith("sh"))
                .forEach(u -> System.out.println(u.getName()));

        //Stream filter() with mapToInt() and sum()
        List<User> list2 = User.getUsers();
        System.out.println("--- Sum of age between the user id 2 and 4 ---");
        int sum = list2.stream().filter(u -> u.getId() >= 2 && u.getId() <= 4)
                .mapToInt(u -> u.getAge()).sum();
        System.out.println("Sum: " + sum);

        //Stream filter() with collect()
        List<User> list3 = User.getUsers();
        long count = list3.stream().filter(u -> u.getName().endsWith("sh"))
                .collect(Collectors.counting());
        System.out.println("Number of users ending name with 'sh': "+ count);

        // Stream filter() with reduce()
        List<User> list4 = User.getUsers();
        list4.stream().filter(u -> u.getName().endsWith("sh"))
                .mapToInt(u -> u.getAge()).reduce((a, b) -> a + b)
                .ifPresent(s -> System.out.println("Sum of age of users ending name with 'sh': "+ s));

        //Stream filter() with List Pars and Impars
        List<Integer> list5  = Arrays.asList(3, 12, 23, 44, 20, 10, 17, 8);
        System.out.println("---List with even Numbers---");
        List<Integer> evenList = list5.stream().filter(i -> i%2 == 0)
                .collect(Collectors.toList());

        evenList.forEach(s -> System.out.print(s+" "));
        System.out.println("\n---List with odd Numbers---");

        List<Integer> oddList = list5.stream().filter(i -> i%2 == 1)
                .collect(Collectors.toList());
        oddList.forEach(s -> System.out.print(s+" "));
    }
}
