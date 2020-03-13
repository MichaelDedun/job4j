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
        Item[] result = Arrays.copyOf(this.items, this.position);
        int size = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i].getName().equals(key)) {
                result[i] = result[i];
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item findById(String id) {
        this.items = Arrays.copyOf(this.items, this.position);
        for (Item el : this.items) {
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
