package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return ("=== Find Item by name ====");
    }

    @Override
    public boolean execute(Input input, Store sqlTracker) {
        String name = input.askStr("Введите новое имя: ");
        List<Item> result = sqlTracker.findByName(name);
        for (Item el : result) {
            System.out.println("Имя: " + el.getName() + " Айди: " + el.getId());
        }
        return true;
    }

}
