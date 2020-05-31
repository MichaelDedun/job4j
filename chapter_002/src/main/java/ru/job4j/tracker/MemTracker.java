package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemTracker {
    private List<Item> items = new ArrayList<>();


    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(String id, Item item) {
        boolean result = true;
        int index = indexOf(id);
        if (index == -1) {
            result = false;
        } else {
            item.setId(items.get(index).getId());
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = true;
        int index = indexOf(id);
        if (index == -1) {
            result = false;
        } else {
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    items.remove(item);
                    break;
                }
            }
        }
        return result;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

}
