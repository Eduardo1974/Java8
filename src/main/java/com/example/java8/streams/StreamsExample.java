package com.example.java8.streams;

import com.example.java8.model.Course;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by eduardo on 05/11/17.
 */
public class StreamsExample {


    public static void main(String[] args) {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("C", 2));
        courseList.add(new Course("JAVA", 10));
        courseList.add(new Course("PHP", 5));

        courseList.sort(Comparator.comparing(Course::getStudents)); //ordenando por numero de alunos no curso

        courseList.forEach(c -> System.out.println(c.getName())); //imprimindo cursos

        //toda collection no java 8 tem stream()
        courseList.stream()
                .filter(c -> c.getStudents() >= 5) //filtrando que tem mais de 5
                .forEach(c -> System.out.println(c.getName())); // imprimindo a lista

        courseList.stream()
                .filter(c -> c.getStudents() >= 5) //filtrando que tem mais de 5
                .map(c -> c.getStudents()) //vai retornar a lista so com o numero de alunos
                .forEach(total -> System.out.println(total)); // imprimindo a liista

        int sum = courseList.stream()
                .filter(c -> c.getStudents() >= 5) //filtrando que tem mais de 5
                .mapToInt(c -> c.getStudents()) //vai retornar a lista so com o numero de alunos
                .sum(); //vai somar todos os alunos

        System.out.println(sum);

        //Optional encapsula a classe que precisamos
        Optional<Course> courseOptional = courseList.stream()
                .filter(c -> c.getStudents() >= 5)
                .findAny();

        Course course = courseOptional.orElse(null); //se nao houver elementos retorna null
        System.out.println(course.getName());

        courseOptional.ifPresent(c -> System.out.println(c.getName()));


        //filtar e receber umma lista
        final List<Course> collect = courseList.stream()
                .filter(c -> course.getStudents() > 2)
                .collect(Collectors.toList());

        collect.forEach(c -> System.out.println(c));

        //filtrar e receber um mapa
        Map<Integer, String> stringMap = courseList.stream()
                .filter(c -> course.getStudents() > 2)
                .collect(Collectors.toMap(
                        c -> c.getStudents(),
                        c -> c.getName()
                ));

        System.out.println(stringMap);

        //filtrar e percorrer foreach
        courseList.stream()
                .filter(c -> course.getStudents() > 2)
                .collect(Collectors.toMap(
                        c -> c.getStudents(),
                        c -> c.getName()
                ))
                .forEach(((key, value) -> System.out.println(key)));

        //filtrar e percorrer foreach thread paralela
        courseList.parallelStream()
                .filter(c -> course.getStudents() > 2)
                .collect(Collectors.toMap(
                        c -> c.getStudents(),
                        c -> c.getName()
                ))
                .forEach(((key, value) -> System.out.println(key)));


        //calcular media
        final OptionalDouble average = courseList.stream()
                .mapToInt(c -> c.getStudents())
                .average();
        System.out.println(average.orElse(0));
    }
}
