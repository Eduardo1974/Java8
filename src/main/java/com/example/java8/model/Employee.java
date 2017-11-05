package com.example.java8.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class Employee {

    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String toString() {
        DecimalFormat dformat = new DecimalFormat(".##");
        return "Employee Name:" + this.name
                + "  Age:" + this.age
                + "  Salary:" + dformat.format(this.salary);
    }

    public static List<Employee> getEmpList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("A",10, 2000.));
        list.add(new Employee("B",20, 3000.0));
        list.add(new Employee( "C",30, 4000.0));
        list.add(new Employee("D", 40,5000.0));
        return list;
    }
}
