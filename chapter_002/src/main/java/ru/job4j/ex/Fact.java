package ru.job4j.ex;

public class Fact {

    public static void main(String[] args) {
        System.out.println("Factorial: " + calc(0));
    }

    public static int calc(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }

}
