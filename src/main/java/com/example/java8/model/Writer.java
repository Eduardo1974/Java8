package com.example.java8.model;

import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class Writer {

    private String name;
    private List<Book> books;

    public Writer(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
