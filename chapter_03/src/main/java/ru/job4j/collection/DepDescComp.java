package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        int length = Math.min(left.length, right.length);
        if (left[0].compareTo(right[0]) == 0) {
            for (int i = 0; i < length; i++) {
                rsl = left[i].compareTo(right[i]);
                if (rsl != 0) {
                    break;
                }
            }
            if (rsl == 0) {
                rsl = Integer.compare(left.length, right.length);
            }
        } else {
            rsl = right[0].compareTo(left[0]);
        }
        return rsl;
    }

}
