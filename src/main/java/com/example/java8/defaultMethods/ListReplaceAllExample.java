package com.example.java8.defaultMethods;

import com.example.java8.model.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class ListReplaceAllExample {

    static List<Employee> employeeList = Arrays.asList(
            new Employee("Tom Jones", 45, 7000.00),
            new Employee("Harry Major", 25, 10000.00),
            new Employee("Ethan Hardy", 65, 8000.00),
            new Employee("Nancy Smith", 22, 12000.00),
            new Employee("Deborah Sprightly", 29, 9000.00));

    public static void main(String[] args) {

        //alterar valores de toda a lista
        employeeList.replaceAll(employee -> {
            employee.setSalary(employee.getSalary() * 1.1);
            return employee;
        });
        System.out.println("Employee list with all salaries incremented by 10%");
        employeeList.forEach(System.out::println);

        employeeList.forEach(employee -> employee.getAge()); //for each abrevido
    }
}
