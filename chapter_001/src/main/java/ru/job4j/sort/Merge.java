package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        for (int i = 0; i < rsl.length; i++) {
            if (leftArrayIndex >= left.length) {
                rsl[i] = right[rightArrayIndex];
                rightArrayIndex += 1;
            } else if (rightArrayIndex >= right.length) {
                rsl[i] = left[leftArrayIndex];
                leftArrayIndex += 1;
            } else if (left[leftArrayIndex] < right[rightArrayIndex]) {
                rsl[i] = left[leftArrayIndex];
                leftArrayIndex += 1;
            } else {
                rsl[i] = right[rightArrayIndex];
                rightArrayIndex += 1;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }

}
