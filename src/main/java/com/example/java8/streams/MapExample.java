package com.example.java8.streams;

import com.example.java8.model.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by eduardo on 05/11/17.
 */
public class MapExample {

    public static void main(String[] args) {

        //Convert Map to List using Stream map()
        Map<Integer, String> map = new HashMap<>();
        map.put(111, "Lalkrishna");
        map.put(154, "Atal");
        map.put(30, "Narendra");
        map.put(200, "Amit");

        List<User> list = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
                .map(e -> new User(e.getKey(), e.getValue())).collect(Collectors.toList());

        list.forEach(l -> System.out.println("Id: " + l.getId() + ", Name: " + l.getName()));

        //Convert List to another List using Stream map()
        Person p1 = new Person(1, "Mohan", "student");
        Person p2 = new Person(2, "Sohan", "teacher");
        Person p3 = new Person(3, "Dinesh", "student");
        List<Person> personList = Arrays.asList(p1, p2, p3);

        List<Student> stdList = personList.stream().filter(p -> p.getPersonType().equals("student"))
                .map(p -> new Student(p.getId(), p.getName()))
                .collect(Collectors.toList());

        stdList.forEach(e -> System.out.println("Id:" + e.getId() + ", Name: " + e.getName()));

        //Stream mapToInt() Example
        Employee e1 = new Employee(1, 20);
        Employee e2 = new Employee(2, 15);
        Employee e3 = new Employee(3, 30);
        List<Employee> list2 = Arrays.asList(e1, e2, e3);
        int sum = list2.stream().mapToInt(e -> e.getAge()).sum();
        System.out.println("Sum: " + sum);

        //Stream mapToDouble() Example
        String[] s = {"1.1", "2.4", "3.7", "4.33"};
        Stream<String> stringStream = Stream.of(s);
        DoubleStream doubleStream = stringStream.mapToDouble(Double::parseDouble);
        double sum2 = doubleStream.peek(System.out::println)
                .sum();
        System.out.println("sum: " + sum);

        //Stream mapToLong() Example
        List<String> stringList = Arrays.asList("1","2","3","4","5");

        stringList.stream()
                .mapToLong(n-> Long.parseLong(n) )
                .filter(n-> n%2 == 0)
                .forEach(System.out::println);

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
    }
}

class Person {

    private int id;
    private String name;
    private String personType;

    public Person(int id, String name, String personType) {
        this.id = id;
        this.name = name;
        this.personType = personType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPersonType() {
        return personType;
    }
}

class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Employee {

    private int id;
    private int age;

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}