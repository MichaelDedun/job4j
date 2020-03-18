package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show all Item's ====");
        Item[] items = tracker.findAll();
        for (Item el : items) {
            System.out.println("Имя:" + el.getName() + " Айди: " + el.getId());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        String id = input.askStr("Введите айди: ");
        String name = input.askStr("Введите новое имя: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Такого айди не существует");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        String id = input.askStr("Введите айди: ");
        if (tracker.delete(id)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Такого айди не существует");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by id ====");
        String id = input.askStr("Введите айди: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Имя: " + item.getName() + " Айди: " + item.getId());
        } else {
            System.out.println("Айди не существует");
        }

    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find Item by name ====");
        String name = input.askStr("Введите новое имя: ");
        Item[] result = tracker.findByName(name);
        for (Item el : result) {
            System.out.println("Имя: " + el.getName() + "Айди: " + el.getId());
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Такого пункта меню нет. ");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
