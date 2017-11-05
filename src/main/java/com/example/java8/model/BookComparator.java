package com.example.java8.model;

import java.util.Comparator;

/**
 * Created by eduardo on 05/11/17.
 */
public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        } else if (b1.getPrice() == b2.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }
}