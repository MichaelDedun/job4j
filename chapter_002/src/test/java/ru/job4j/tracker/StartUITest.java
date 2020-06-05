package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {

//    public Connection init() {
//        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("./chapter_002/src/main/resources/app.properties")) {
//            Properties config = new Properties();
//            config.load(in);
//            Class.forName(config.getProperty("driver-class-name"));
//            return DriverManager.getConnection(
//                    config.getProperty("url"),
//                    config.getProperty("username"),
//                    config.getProperty("password")
//
//            );
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//    }

    private Connection init() {
        try {
            String url = "jdbc:postgresql://localhost:5432/tracker";
            String username = "postgres";
            String password = "123321";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void whenAddItem() throws Exception {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            CreateAction createAction = new CreateAction();
            createAction.execute(input, sqlTracker);
            Item created = sqlTracker.findByName("Fix PC").get(0);
            Item expected = new Item("Fix PC");
            assertThat(created.getName(), is(expected.getName()));
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String[] name = {"Testname"};
            Input input = new StubInput(name);
            CreateAction createAction = new CreateAction();
            createAction.execute(input, sqlTracker);
            assertThat(name[0], is(sqlTracker.findByName("Testname").get(0).getName()));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("new item");
            sqlTracker.add(item);
            String[] answers = {
                    item.getId(), // id сохраненной заявки в объект tracker.
                    "replaced item"
            };
            ReplaceAction replaceAction = new ReplaceAction();
            replaceAction.execute(new StubInput(answers), sqlTracker);
            Item replaced = sqlTracker.findById(item.getId());
            assertThat(replaced.getName(), is("replaced item"));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("Test");
            sqlTracker.add(item);
            String[] id = {item.getId()};
            DeleteAction deleteAction = new DeleteAction();
            deleteAction.execute(new StubInput(id), sqlTracker);
            assertNull(sqlTracker.findById(item.getId()));
        }
    }

    @Test
    public void whenPrtMenu() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new SqlTracker(), Arrays.asList(new UserAction[]{action}));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenExit() throws Exception {
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new SqlTracker(), Arrays.asList(new UserAction[]{action}));
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenCheckOutput() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("fix bug");
            sqlTracker.add(item);
            FindAllAction act = new FindAllAction();
            act.execute(new StubInput(new String[]{}), sqlTracker);
            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("=== Show all Item's ====")
                    .add("Имя:" + item.getName() + " Айди: " + item.getId())
                    .toString();
            assertThat(new String(out.toByteArray()), is(expect));
            System.setOut(def);
        }
    }

    @Test
    public void findByNameExecute() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("fix bug");
            sqlTracker.add(item);
            FindByNameAction act = new FindByNameAction();
            act.execute(new StubInput(new String[]{"fix bug"}), sqlTracker);
            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("Имя: " + item.getName() + " Айди: " + item.getId())
                    .toString();
            assertThat(new String(out.toByteArray()), is(expect));
            System.setOut(def);
        }
    }

}
