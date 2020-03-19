package ru.job4j.ex;

public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String str) {
        super(str);
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент не найден");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"Sobaka", "Koshka", "Zhiraf", "Test"};
        try {
            ElementNotFoundException.indexOf(value, "Test");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}
