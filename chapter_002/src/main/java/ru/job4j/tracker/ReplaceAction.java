package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return ("=== Edit Item ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите айди: ");
        String name = input.askStr("Введите новое имя: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Такого айди не существует");
        }
        return true;
    }

}
