package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {

    public void init(Input input, Store sqlTracker, List<UserAction> actions) throws Exception {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, sqlTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        int index = 0;
        for (UserAction action : actions) {
            System.out.println(index + ". " + action.name());
            index++;
        }
    }

    //    public static void main(String[] args) {
//        Input input = new ConsoleInput();
//        Input validate = new ValidateInput(input);
//        MemTracker memTracker = new MemTracker();
//        List<UserAction> actions = new ArrayList<>();
//        actions.add(new CreateAction());
//        actions.add(new FindAllAction());
//        actions.add(new ReplaceAction());
//        actions.add(new DeleteAction());
//        actions.add(new FindByIdAction());
//        actions.add(new FindByNameAction());
//        actions.add(new ExitAction());
//
//        new StartUI().init(validate, memTracker, actions);
//    }
    public static void main(String[] args) {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = new ArrayList<>(
                    Arrays.asList(
                            new CreateAction(),
                            new FindAllAction(),
                            new ReplaceAction(),
                            new DeleteAction(),
                            new FindByIdAction(),
                            new FindByNameAction(),
                            new ExitAction()
                    )
            );
            new StartUI().init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
