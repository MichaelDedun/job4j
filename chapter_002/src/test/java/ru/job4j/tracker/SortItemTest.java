package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortItemTest {

    @Test
    public void descSort() {
        List<Item> items = Arrays.asList(
                new Item("Kread"),
                new Item("Adam"),
                new Item("Gon")
        );
        List<Item> expected = Arrays.asList(
                new Item("Kread"),
                new Item("Gon"),
                new Item("Adam")
        );
        Collections.sort(items, new ItemDescComparator());
        assertEquals(expected, items);
    }

    @Test
    public void incSort() {
        List<Item> items = Arrays.asList(
                new Item("Kread"),
                new Item("Adam"),
                new Item("Gon")
        );
        List<Item> expected = Arrays.asList(
                new Item("Adam"),
                new Item("Gon"),
                new Item("Kread")
        );
        Collections.sort(items, new ItemIncComparator());
        assertEquals(expected, items);
    }


}
