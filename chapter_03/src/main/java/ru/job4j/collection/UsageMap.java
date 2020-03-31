package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> fio = new HashMap<>();
        fio.put("michael.dedun@mail.ru", "Dedun Michael Alexandrovich");
        fio.put("kirill.dedun@mail.ru", "Dedun Kirill Alexandrovich");
        for (String key : fio.keySet()) {
            String value = fio.get(key);
            System.out.println(key + " = " + value);
        }
    }

}
