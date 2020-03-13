package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        while (matches != 0) {
            System.out.println("Ходит первый игрок, возьмите количество спичек от 1 до 3");
            int select = Integer.valueOf(input.nextLine());
            matches -= select;
            System.out.println("Спичек осталось: " + matches);
            System.out.println("Ходит второй игрок, возьмите количество спичек от 1 до 3");
            select = Integer.valueOf(input.nextLine());
            matches -= select;
            System.out.println("Спичек осталось: " + matches);
            if (matches <= 0) {
                System.out.println("Победа");
            }
        }
    }

}
