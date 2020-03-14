package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void createItem() {
        Tracker tracker = new Tracker();
        String[] name = {"Testname"};
        Input input = new StubInput(name);
        StartUI.createItem(input, tracker);
        assertThat(name[0], is(tracker.findAll()[0].getName()));
    }

}
