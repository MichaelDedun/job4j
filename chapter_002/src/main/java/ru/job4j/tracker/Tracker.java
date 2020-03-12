package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;


    public Item add(Item item) {
        item.setId(generateId());
        this.items[position] = item;
        this.position++;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] listApplications = Arrays.copyOf(this.items, this.position);
        Item[] result = new Item[listApplications.length];
        int size = 0;
        for (int i = 0; i < listApplications.length; i++) {
            if (listApplications[i].getName().equals(key)) {
                result[i] = listApplications[i];
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item findById(String id) {
        Item[] listApplications = Arrays.copyOf(this.items, this.position);
        for (Item el : listApplications) {
            if (el.getId().equals(id)) {
                return el;
            }
        }
        return null;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

}
