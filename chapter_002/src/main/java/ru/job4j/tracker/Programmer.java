package ru.job4j.tracker;

public class Programmer extends Engineer {
    private String programmingLanguage;

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String writeCode() {
        return "Writing some code";
    }

}
