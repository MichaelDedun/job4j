package ru.job4j.array;

public class Check {

    public static boolean mono(boolean[] data) {
        boolean result = true;
        for (boolean el : data) {
            if (data[0] != el) {
                result = false;
                break;
            }
        }
        return result;
    }

}
