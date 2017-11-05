package com.example.java8.streams;

import com.example.java8.model.Employee;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by eduardo on 05/11/17.
 */
public class MatchAndPredicateExample {

    public static void main(String[] args) {
        Predicate<Employee> p1 = e -> e.getAge() <= 10 && e.getName().startsWith("A"); //crio uma condicao
        Predicate<Employee> p2 = e -> e.getSalary() < 10000; //crio uma condicao

        List<Employee> list = Employee.getEmpList(); //recebo uma lista completa
        //using allMatch
        boolean b1 = list.stream().allMatch(p1); //verifico se toda a lista atende a essa condicao
        System.out.println(b1);
        boolean b2 = list.stream().allMatch(p2); //verifico se toda a lista atende a essa condicao
        System.out.println(b2);
        //using anyMatch
        boolean b3 = list.stream().anyMatch(p1); //verifico se alguem na lista atende a essa condicao
        System.out.println(b3);
        boolean b4 = list.stream().anyMatch(p2); //verifico se alguem na lista atende a essa condicao
        System.out.println(b4);
        //using noneMatch
        boolean b5 = list.stream().noneMatch(p1); //verifico ninguem na lista atende a essa condicao
        System.out.println(b5);
    }
}
