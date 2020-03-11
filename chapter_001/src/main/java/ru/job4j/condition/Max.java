package ru.job4j.condition;

public class Max {

    public static int max(int left, int right) {
        return left >= right ? left : right;
    }

    public static int max(int first, int second, int third) {
        int result = 0;
        if (max(first, second) >= third) {
            result = max(first, second);
        } else {
            result = third;
        }
        return result;
    }

    public static int max(int first, int second, int third, int fourth) {
        int result = 0;
        if (max(first, second) >= max(third, first)) {
            result = max(first, second);
        } else {
            result = max(third, first);
        }
        return result;
    }

}
