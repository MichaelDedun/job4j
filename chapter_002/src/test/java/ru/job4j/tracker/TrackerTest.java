package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findAllWithThreeItems() {
        Tracker tracker = new Tracker();
        Item[] forTest = new Item[3];
        Item item = new Item("test1");
        Item item1 = new Item("test2");
        Item item2 = new Item("test3");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        forTest[0] = item;
        forTest[1] = item1;
        forTest[2] = item2;
        Item[] result = tracker.findAll();
        assertThat(result, is(forTest));
    }

    @Test
    public void findByNameWithThreeItems() {
        Tracker tracker = new Tracker();
        Item[] forTest = new Item[2];
        Item item = new Item("test1");
        Item item1 = new Item("test1");
        Item item2 = new Item("test3");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        forTest[0] = item;
        forTest[1] = item1;
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(forTest));
    }

    @Test
    public void findByNameWithNoMatches() {
        Tracker tracker = new Tracker();
        Item[] forTest = new Item[0];
        Item item = new Item("test1");
        Item item1 = new Item("test1");
        Item item2 = new Item("test3");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findByName("test5");
        assertThat(result, is(forTest));
    }

    @Test
    public void findByIdWhenEquals() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getId(), is(item.getId()));
    }

    @Test
    public void findByIdWhenIdDoesNotExist() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item expected = null;
        Item result = tracker.findById("isjfgsf");
        assertThat(result, is(expected));
    }

}
