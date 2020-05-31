package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        MemTracker memTracker = new MemTracker();
        CreateAction createAction = new CreateAction();
        createAction.execute(input, memTracker);
        Item created = memTracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void createItem() {
        MemTracker memTracker = new MemTracker();
        String[] name = {"Testname"};
        Input input = new StubInput(name);
        CreateAction createAction = new CreateAction();
        createAction.execute(input, memTracker);
        assertThat(name[0], is(memTracker.findAll().get(0).getName()));
    }

    @Test
    public void whenReplaceItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("new item");
        memTracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        ReplaceAction replaceAction = new ReplaceAction();
        replaceAction.execute(new StubInput(answers), memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Test");
        memTracker.add(item);
        String[] id = {item.getId()};
        DeleteAction deleteAction = new DeleteAction();
        deleteAction.execute(new StubInput(id), memTracker);
        assertNull(memTracker.findById(item.getId()));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        List<UserAction> actions = new ArrayList<>();
        new StartUI().init(input, new MemTracker(), Arrays.asList(new UserAction[]{action}));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new MemTracker(), Arrays.asList(new UserAction[]{action}));
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        MemTracker memTracker = new MemTracker();
        Item item = new Item("fix bug");
        memTracker.add(item);
        FindAllAction act = new FindAllAction();
        act.execute(new StubInput(new String[] {}), memTracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Show all Item's ====")
                .add("Имя:" + item.getName() + " Айди: " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void findByNameExecute() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        MemTracker memTracker = new MemTracker();
        Item item = new Item("fix bug");
        memTracker.add(item);
        FindByNameAction act = new FindByNameAction();
        act.execute(new StubInput(new String[] {"fix bug"}), memTracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Имя: " + item.getName() + "Айди: " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

}
