package com.example.java8.streams;

import com.example.java8.model.Book;
import com.example.java8.model.BookComparator;
import com.example.java8.model.Writer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class FlatMapExample {

    public static void main(String[] args) {

        //Stream flatMap with List

        List<Book> books = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"));
        Writer w1 = new Writer("Mohan", books);

        books = Arrays.asList(new Book(30, "XXX"), new Book(15, "ZZZ"));
        Writer w2 = new Writer("Sohan", books);

        List<Writer> writers = Arrays.asList(w1, w2);

        //Writer contem uma lista de books. Ele percorre a lista de books na lista de writers e verifica qual
        // é o de maior preço
        Book book = writers.stream().flatMap(writer -> writer.getBooks().stream())
                .max(new BookComparator()).get();

        System.out.println("Name:"+book.getName()+", Price:"+ book.getPrice() );

        //Stream flatMap with List of Lists
        List<Book> list1 = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"));
        List<Book> list2 = Arrays.asList(new Book(30, "XXX"), new Book(15, "ZZZ"));
        List<List<Book>> finalList = Arrays.asList(list1, list2);
        Book book2 = finalList.stream().flatMap(list -> list.stream()).min(new BookComparator()).get();
        System.out.println("Name:"+book2.getName()+", Price:"+ book2.getPrice() );
    }
}
