package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[][] matrix = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}};
        list = Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
        for (Integer el : list) {
            System.out.println(el);
        }
    }
}
