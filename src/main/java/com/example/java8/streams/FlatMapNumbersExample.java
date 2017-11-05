package com.example.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by eduardo on 05/11/17.
 */
public class FlatMapNumbersExample {

    public static void main(String[] args) {

        //flatMapToInt
        int[][] data = {{1, 2}, {3, 4}, {5, 6}};
        IntStream is1 = Arrays.stream(data).flatMapToInt(row -> Arrays.stream(row));
        System.out.println(is1.sum());

        int[] l1 = {4, 8, 9};
        IntDemoPerson p1 = new IntDemoPerson("Ram", l1);
        int[] l2 = {2, 7, 8};
        IntDemoPerson p2 = new IntDemoPerson("Shyam", l2);
        List<IntDemoPerson> list = Arrays.asList(p1, p2);
        IntStream is2 = list.stream().flatMapToInt(row -> Arrays.stream(row.getLuckyNum()));
        System.out.println(is2.max().getAsInt());

        //flatMapToLong
        long[][] data2 = {{1L, 2L}, {3L, 4L}, {5L, 6L}};
        LongStream ls1 = Arrays.stream(data2).flatMapToLong(row -> Arrays.stream(row));
        System.out.println(ls1.sum());

        long[] l11 = {4l, 8l, 9l};
        LongDemoPerson p11 = new LongDemoPerson("Ram", l11);
        long[] l22 = {2l, 7l, 8l};
        LongDemoPerson p22 = new LongDemoPerson("Shyam", l22);
        List<LongDemoPerson> list2 = Arrays.asList(p11, p22);
        LongStream ls2 = list2.stream().flatMapToLong(row -> Arrays.stream(row.getLuckyNum()));
        System.out.println(ls2.min().getAsLong());

        //flatMapToDouble
        double[][] data3 = {{1.5, 2.4}, {3.2, 4.4}, {5.2, 6.8}};
        DoubleStream ds11 = Arrays.stream(data3).flatMapToDouble(row -> Arrays.stream(row));
        System.out.println(ds11.average().getAsDouble());

        double[] d1 = {60.5, 58.9, 62.5};
        DoubleDemoPerson p111 = new DoubleDemoPerson("Ram", d1);
        double[] d2 = {70.5, 65.3, 67.4};
        DoubleDemoPerson p222 = new DoubleDemoPerson("Shyam", d2);
        List<DoubleDemoPerson> list3 = Arrays.asList(p111, p222);
        DoubleStream ds2 = list3.stream().flatMapToDouble(row -> Arrays.stream(row.getWeightsInAYear()));
        System.out.println(ds2.min().getAsDouble());
    }
}

class IntDemoPerson {

    private String name;
    private int[] luckyNum;

    public IntDemoPerson(String name, int[] luckyNum) {
        this.name = name;
        this.luckyNum = luckyNum;
    }

    public String getName() {
        return name;
    }

    public int[] getLuckyNum() {
        return luckyNum;
    }
}

class LongDemoPerson {
    private String name;
    private long[] luckyNum;

    public LongDemoPerson(String name, long[] luckyNum) {
        this.name = name;
        this.luckyNum = luckyNum;
    }

    public String getName() {
        return name;
    }

    public long[] getLuckyNum() {
        return luckyNum;
    }
}

class DoubleDemoPerson {

    private String name;
    private double[] weightsInAYear;

    public DoubleDemoPerson(String name, double[] weightsInAYear) {
        this.name = name;
        this.weightsInAYear = weightsInAYear;
    }

    public String getName() {
        return name;
    }

    public double[] getWeightsInAYear() {
        return weightsInAYear;
    }
}
