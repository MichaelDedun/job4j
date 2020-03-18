package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return ("=== Show all Item's ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all Item's ====");
        Item[] items = tracker.findAll();
        for (Item el : items) {
            System.out.println("Имя:" + el.getName() + " Айди: " + el.getId());
        }
        return true;
    }

}
