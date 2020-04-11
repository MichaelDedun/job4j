package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = person -> person.getName().equals(key);
        Predicate<Person> bySurname = person -> person.getSurname().equals(key);
        Predicate<Person> byPhone = person -> person.getPhone().equals(key);
        Predicate<Person> byAddress = person -> person.getAddress().equals(key);
        var combine = byName.or(bySurname).or(byPhone).or(byAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
