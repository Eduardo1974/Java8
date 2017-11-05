package com.example.java8.streams;

import com.example.java8.model.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by eduardo on 05/11/17.
 */
public class CollectExample {

    public static void main(String[] args) {

        //criar string com valores concatenados
        List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");

        String result = list.parallelStream().collect(StringBuilder::new,
                (response, element) -> response.append("s").append(element), //concatena em todos os elementos no começo
                (response1, element2) -> response1.append(",").append(element2)) //concatena no final do elemento
                .toString();
        System.out.println("Result: " + result);

        // Obter status de uma lista de inteiros
        List<Integer> list2 = Arrays.asList(1, 2, 3, 6);

        IntSummaryStatistics stats = list2.stream()
                .collect(Collectors.summarizingInt(i -> i + i));

        System.out.println("Sum:"+stats.toString());

        // concatenar lista de forma simples

        List<String> list3 = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
        String result2 =  list3.stream().collect(Collectors.joining(", "));
        System.out.println("Joining Result: "+ result2);

        // obter a media de uma lista de inteiros

        List<Integer> list4 = Arrays.asList(1,2,3,4);
        Double result3 = list4.stream().collect(Collectors.averagingInt(v->v));
        System.out.println("Average: "+result3);

        // obter a contagem de uma lista de interios

        List<Integer> list5 = Arrays.asList(1,2,3,4,6);
        long result4 =  list5.stream().collect(Collectors.counting());
        System.out.println("Count: "+ result4);

        //converter array para lista

        String[] strArray = {"AA", "BB", "CC"};
        List<String> list6 = Arrays.stream(strArray).collect(Collectors.toList());
        list6.forEach(s->System.out.println(s));

        // converter lista para mapa

        List<Person> list7 = new ArrayList<>();
        list7.add(new Person(100, "Mohan"));
        list7.add(new Person(200, "Sohan"));
        list7.add(new Person(300, "Mahesh"));

        Map<Integer, String> map = list7.stream()
                .collect(Collectors.toMap(Person::getAge, Person::getNome));
        map.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ y));

        ///////////////////////////////////////////////////////////////////////////////

    }
}
