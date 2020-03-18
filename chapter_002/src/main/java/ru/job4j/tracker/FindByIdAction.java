package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return ("=== Find Item by id ====");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите айди: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Имя: " + item.getName() + " Айди: " + item.getId());
        } else {
            System.out.println("Айди не существует");
        }
        return true;
    }

}
