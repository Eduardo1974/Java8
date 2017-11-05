package com.example.java8.model;

/**
 * Created by eduardo on 05/11/17.
 */
public class Person {

    private int age;

    private String nome;

    public Person(int age, String nome) {
        this.age = age;
        this.nome = nome;
    }

    public Person(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
