package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findAllWithThreeItems() {
        MemTracker memTracker = new MemTracker();
        List<Item> forTest = new ArrayList<>();
        Item item = new Item("test1");
        Item item1 = new Item("test2");
        Item item2 = new Item("test3");
        memTracker.add(item);
        memTracker.add(item1);
        memTracker.add(item2);
        forTest.add(item);
        forTest.add(item1);
        forTest.add(item2);
        List<Item> result = memTracker.findAll();
        assertThat(result, is(forTest));
    }

    @Test
    public void findByNameWithThreeItems() {
        MemTracker memTracker = new MemTracker();
        List<Item> forTest = new ArrayList<>();
        Item item = new Item("test1");
        Item item1 = new Item("test1");
        Item item2 = new Item("test3");
        memTracker.add(item);
        memTracker.add(item1);
        memTracker.add(item2);
        forTest.add(item);
        forTest.add(item1);
        List<Item> result = memTracker.findByName("test1");
        assertThat(result, is(forTest));
    }

    @Test
    public void findByNameWithNoMatches() {
        MemTracker memTracker = new MemTracker();
        List<Item> forTest = new ArrayList<>();
        Item item = new Item("test1");
        Item item1 = new Item("test1");
        Item item2 = new Item("test3");
        memTracker.add(item);
        memTracker.add(item1);
        memTracker.add(item2);
        List<Item> result = memTracker.findByName("test5");
        assertThat(result, is(forTest));
    }

    @Test
    public void findByIdWhenEquals() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getId(), is(item.getId()));
    }

    @Test
    public void findByIdWhenIdDoesNotExist() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item expected = null;
        Item result = memTracker.findById("isjfgsf");
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

}
