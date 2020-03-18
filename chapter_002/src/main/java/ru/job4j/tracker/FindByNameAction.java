package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return ("=== Find Item by name ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите новое имя: ");
        Item[] result = tracker.findByName(name);
        for (Item el : result) {
            System.out.println("Имя: " + el.getName() + "Айди: " + el.getId());
        }
        return true;
    }

}
