package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book goldenBowl = new Book("Golden bowl", 500);
        Book cleanCode = new Book("Clean code", 200);
        Book dracula = new Book("Dracula", 372);
        Book kim = new Book("Kim", 428);

        Book[] books = new Book[4];
        books[0] = goldenBowl;
        books[1] = cleanCode;
        books[2] = dracula;
        books[3] = kim;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " " + bk.getNumbersPages());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " " + bk.getNumbersPages());
        }

        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " " + bk.getNumbersPages());
            }
        }

    }

}
