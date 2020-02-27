package ru.job4j.array;

public class ArrayDefinition {

    short[] ages = new short[10];

    String[] surnames = new String[100500];

    float[] prices = new float[40];

    public static void main(String[] args) {
        String[] names = new String[4];
        names[0] = "Petr Arsentev";
        names[1] = "Michael Dedun";
        names[2] = "Andrei Hincu";
        names[3] = "Rail Shamsemuhametov";

        for (String name : names)
            System.out.println(name);

    }

}
