package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return ("=== Delete Item ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите айди: ");
        if (tracker.delete(id)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Такого айди не существует");
        }
        return true;
    }
}
