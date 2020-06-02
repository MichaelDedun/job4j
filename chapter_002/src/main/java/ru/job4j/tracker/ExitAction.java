package ru.job4j.tracker;

public class ExitAction implements UserAction {

    @Override
    public String name() {
        return ("=== Exit ====");
    }

    @Override
    public boolean execute(Input input, Store sqlTracker) throws Exception {
        sqlTracker.close();
        return false;
    }

}
