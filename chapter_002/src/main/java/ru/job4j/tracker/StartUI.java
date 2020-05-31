package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    SqlTracker sqlTracker = new SqlTracker();

    public void init(Input input, MemTracker memTracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            if (select == 0) {
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                sqlTracker.init();
                sqlTracker.add(item);
            }
            UserAction action = actions.get(select);
            run = action.execute(input, memTracker);

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

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new FindAllAction());
        actions.add(new ReplaceAction());
        actions.add(new DeleteAction());
        actions.add(new FindByIdAction());
        actions.add(new FindByNameAction());
        actions.add(new ExitAction());

        new StartUI().init(validate, memTracker, actions);
    }

}
