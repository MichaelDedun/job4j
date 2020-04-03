package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftNums = left.substring(0, left.indexOf(" ")).split("\\.");
        String[] rightNums = right.substring(0, right.indexOf(" ")).split("\\.");
        int length = Math.min(leftNums.length, rightNums.length);
        for (int i = 0; i < length; i++) {
              rsl = Integer.valueOf(leftNums[i]).compareTo(Integer.valueOf(rightNums[i]));
              if (rsl != 0) {
                  break;
              }
        }
        rsl = rsl == 0 ? Integer.compare(left.length(), right.length()) : rsl;
        return rsl;
    }

}
