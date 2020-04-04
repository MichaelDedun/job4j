package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    @SuppressWarnings("checkstyle:MemberName")
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int surrender = money - price;
        for (int i = 0; i < coins.length; i++) {
            while (surrender != 0) {
                if (surrender - coins[i] < 0) {
                    break;
                }
                surrender = surrender - coins[i];
                rsl[i] = coins[i];
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
