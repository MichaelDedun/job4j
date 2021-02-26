package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        StartUI ui1 = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui1.add("Misha Arsentev");
        ui.add("Ivan ivanov");
        ui1.add("Vova ivanov");
        ui.print();
        ui1.print();
    }
}
