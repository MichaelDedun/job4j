package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.println("Введите айди: ");
                String id = scanner.nextLine();
                if (tracker.findById(id) != null) {
                    System.out.println("Введите новое имя: ");
                    String name = scanner.nextLine();
                    Item newItem = new Item(name);
                    tracker.replace(id, newItem);
                    System.out.println("Успешно");
                } else {
                    System.out.println("Такого айди не существует");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.println("Введите айди: ");
                String id = scanner.nextLine();
                if (tracker.findById(id) != null) {
                    tracker.delete(id);
                    System.out.println("Успешно");
                } else {
                    System.out.println("Такого айди не существует");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by id ====");
                System.out.println("Введите айди: ");
                String id = scanner.nextLine();
                System.out.println("Имя: " + tracker.findById(id).getName() + " Айди: " + tracker.findById(id).getId());
            } else if (select == 5) {
                System.out.println("Введите имя: ");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
