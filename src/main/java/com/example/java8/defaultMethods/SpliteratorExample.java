package com.example.java8.defaultMethods;

import com.example.java8.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * Created by eduardo on 05/11/17.
 */
public class SpliteratorExample {

    public static void main(String[] args) {

        //JAVA 8 SPLIT(DIVIDOR LISTA SEM FOR)

        Collection<Person> people = new ArrayList<Person>();
        people.add(new Person("edu"));
        people.add(new Person("pai"));

        Iterator<Person> peopleIterator = people.iterator();
        while(peopleIterator.hasNext()) {
            Person person = peopleIterator.next();
            System.out.println("Hello " + person.getNome());
        }

        Spliterator<Person> peopleSpliterator = people.spliterator();
        System.out.println(peopleSpliterator.estimateSize());

        Spliterator<Person> newPartition = peopleSpliterator.trySplit(); //NOVA PARTICCAO DA LISTA
        System.out.println(" " + newPartition.estimateSize());  //PEGOU METADE DA LISTA
        System.out.println(" " + peopleSpliterator.estimateSize());

    }
}
