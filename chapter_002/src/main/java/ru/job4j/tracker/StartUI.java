package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Item's ====");
                Item[] items = tracker.findAll();
                for (Item el : items) {
                    System.out.println("Имя:" + el.getName() + " Айди: " + el.getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                String id = input.askStr("Введите айди: ");
                String name = input.askStr("Введите новое имя: ");
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    tracker.replace(id, newItem);
                    System.out.println("Успешно");
                } else {
                    System.out.println("Такого айди не существует");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                String id = input.askStr("Введите айди: ");
                if (tracker.delete(id)) {
                    tracker.delete(id);
                    System.out.println("Успешно");
                } else {
                    System.out.println("Такого айди не существует");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by id ====");
                String id = input.askStr("Введите айди: ");
                System.out.println("Имя: " + tracker.findById(id).getName() + " Айди: " + tracker.findById(id).getId());
            } else if (select == 5) {
                String name = input.askStr("Введите новое имя: ");
                Item[] result = tracker.findByName(name);
                for (Item el : result) {
                    System.out.println("Имя: " + el.getName() + "Айди: " + el.getId());
                }
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
