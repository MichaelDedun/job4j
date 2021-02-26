package ru.job4j.di;

import org.springframework.stereotype.Component;
import ru.job4j.tracker.ConsoleInput;

@Component
public class StartUI {
    private Store store;
    private ConsoleInput consoleInput;

    public StartUI(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public String askStr(String question) {
       return consoleInput.askStr(question);
    }

    public Integer askInt(String question) {
        return consoleInput.askInt(question);
    }

}
