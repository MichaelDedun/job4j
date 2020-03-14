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
        Item[] result = new Item[this.position];
        int size = 0;
        for (int i = 0; i < result.length; i++) {
            if (this.items[i].getName().equals(key)) {
                result[i] = this.items[i];
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(String id, Item item) {
        boolean result = true;
        if (indexOf(id) == -1) {
            result = false;
        } else {
            int index = indexOf(id);
            item.setId(this.items[index].getId());
            this.items[index] = item;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = true;
        if (indexOf(id) == -1) {
            result = false;
        } else {
            int index = indexOf(id);
            System.arraycopy(this.items, index + 1, this.items, index, this.position - index);
            this.items[position - 1] = null;
            this.position--;
        }
        return result;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

}
