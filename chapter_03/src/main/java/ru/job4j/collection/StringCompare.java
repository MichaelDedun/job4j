package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        char[] leftChars = left.toCharArray();
        char[] rightChars = right.toCharArray();
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < length; i++) {
            rsl = Character.compare(leftChars[i], rightChars[i]);
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(leftChars.length, rightChars.length);
        }
        return rsl;
    }

}
