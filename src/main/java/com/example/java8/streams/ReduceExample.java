package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eduardo on 05/11/17.
 */
public class ReduceExample {

    public static void main(String[] args) {

        //Stream.reduce() with Accumulator
        int[] array = {1, 2, 3, 2, 2};
        Arrays.stream(array).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(StatisticsUtility::addIntData).ifPresent(s -> System.out.println(s));

        //Stream.reduce() with Identity and Accumulator
        int[] array2 = {23,43,56,97,32};
        //Set start value. Result will be start value + sum of array.
        int startValue = 100;
        int sum = Arrays.stream(array2).reduce(startValue, (x,y) -> x+y);
        System.out.println(sum);
        sum = Arrays.stream(array2).reduce(startValue, Integer::sum);
        System.out.println(sum);
        sum = Arrays.stream(array2).reduce(startValue, StatisticsUtility::addIntData);
        System.out.println(sum);

        //Stream.reduce() with Identity, Accumulator and Combiner
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        //Here result will be 2*2 + 2*3 + 2*4 that is 18.
        int res = list2.parallelStream().reduce(2, (s1, s2) -> s1 * s2, (p, q) -> p + q);
        System.out.println(res);

        List<String> list1 = Arrays.asList("Mohan", "Sohan", "Ramesh");
        String result = list1.parallelStream().reduce("-", (s1, s2) -> s1 + s2, (p, q) -> p + q);
        System.out.println(result);

        //Reduce List and Array into a String
        //Reduce Array to String.
        String[] array3 = {"Mohan", "Sohan", "Mahesh"};
        Arrays.stream(array3).reduce((x, y) -> x +"," + y)
                .ifPresent(s -> System.out.println("Array to String: "+ s));
        //Reduce List to String.
        List<String> list = Arrays.asList("Mohan", "Sohan", "Mahesh");
        list.stream().reduce((x, y) -> x +"," + y)
                .ifPresent(s -> System.out.println("List to String: "+ s));

        //Reduce List and Array into Sum
        //Reduce Array to sum.
        int[] array4 = {30, 10, 20, 40};
        int sum2 = Arrays.stream(array4).reduce(0, (x, y) -> x + y);
        System.out.println("Sum of Array: "+ sum2);
        //Reduce List to sum.
        List<Integer> list3 = Arrays.asList(30, 10, 20, 40);
        sum2 = list3.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum of List: "+ sum2);
    }
}

class StatisticsUtility {
    public static int addIntData(int num1, int num2) {
        return num1 + num2;
    }
}