package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    @SuppressWarnings("checkstyle:MemberName")
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int surrender = money - price;
        for (int i = 0; i < COINS.length; i++) {
            while (surrender != 0) {
                if (surrender - COINS[i] < 0) {
                    break;
                }
                surrender = surrender - COINS[i];
                rsl[i] = COINS[i];
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.change(50, 35);
    }
}
