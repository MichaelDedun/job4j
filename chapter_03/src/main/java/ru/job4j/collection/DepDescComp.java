package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        if (left[0].compareTo(right[0]) == 0) {
            rsl = Integer.compare(left.length, right.length);
            if (rsl == 0) {
                rsl = left[left.length - 1].compareTo(right[right.length - 1]);
            }
        } else {
            rsl = right[0].compareTo(left[0]);
        }
        return rsl;
    }

}
