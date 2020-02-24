package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        int rsl = value / 70;
        return rsl;
    }

    public static int rubleToDollar(int value) {
        int rsl = value / 60;
        return rsl;
    }

    public static void main(String[] args) {
        int euro = Converter.rubleToEuro(140);
        int dollar = Converter.rubleToDollar(120);
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("120 rybles are " + dollar + "dollar");

        int inEuro = 140;
        int expected = 2;
        int outEuro = rubleToEuro(inEuro);
        boolean passed = expected == outEuro;
        System.out.println("140 rubles are 2. Test result : " + passed);

        int inDollar = 120;
        int expected1 = 2;
        int outDollar = rubleToDollar(inDollar);
        boolean passed1 = expected1 == outDollar;
        System.out.println("120 rubles are 2. Test result : " + passed1);
    }

}
