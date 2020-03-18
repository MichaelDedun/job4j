package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    static class Player {
        private String name;

        public Player(String name) {
            this.name = name;
        }

        public int takeMatches() {
            Scanner input = new Scanner(System.in);
            return Integer.parseInt(input.nextLine());
        }

        public String getName() {
            return name;
        }

    }

    private static int matches = 11;

    public static void main(String[] args) {
        int select, current = 0;
        Player[] players = initPlayers(2);
        Player lastPlayer = players[current];
        while (!isFinished()) {
            do {
                System.out.println(players[current].getName() + " , возьмите количество спичек от 1 до 3");
                select = players[current].takeMatches();
            } while (!checkAmount(select));
            matches -= select;
            printAmount();
            lastPlayer = players[current];
            current = getNextPlayerIndex(players, current);
        }
        System.out.println(lastPlayer.getName() + " won");
    }

    private static int getNextPlayerIndex(Player[] players, int current) {
        int next = current + 1;
        if (next == players.length) {
            next = 0;
        }
        return next;
    }

    private static Player[] initPlayers(int num) {
        Player[] players = new Player[num];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player [" + (i + 1) + "]");
        }
        return players;
    }

    private static boolean checkAmount(int amount) {
        boolean result = true;
        if (amount < 1 || amount > 3 || amount > matches) {
            result = false;
        }
        return result;
    }

    private static boolean isFinished() {
        return matches == 0;
    }

    private static void printAmount() {
        System.out.println("Спичек осталось: " + matches);
    }

}
