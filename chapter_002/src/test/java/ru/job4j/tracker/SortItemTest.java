package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortItemTest {

    @Test
    public void reversSort() {
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
        Collections.sort(items, new SortItemByNameRevers());
        assertEquals(expected, items);
    }
}
