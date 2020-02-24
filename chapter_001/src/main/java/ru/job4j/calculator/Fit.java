package ru.job4j.calculator;

public class Fit {

    public static double manWeight(double height) {
        double rsl = height * 1.15;
        return rsl;
    }


    public static double womanWeight(double height) {
        double rsl = height * 1.15;
        return rsl;
    }

    public static void main(String[] args) {
        double man = Fit.manWeight(100);
        double woman = Fit.womanWeight(110);
        System.out.println("Man 100 is " + man);
        System.out.println("Woman 110 is " + woman);
    }

}
