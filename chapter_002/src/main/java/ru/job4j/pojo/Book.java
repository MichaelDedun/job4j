package ru.job4j.pojo;

public class Book {
    private String name;
    private int numbersPages;

    public Book(String name, int numbersPages) {
        this.name = name;
        this.numbersPages = numbersPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumbersPages() {
        return numbersPages;
    }

    public void setNumbersPages(int numbersPages) {
        this.numbersPages = numbersPages;
    }

}
