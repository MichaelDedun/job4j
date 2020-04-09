package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict::test).collect(Collectors.toList());
    }

    Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toMap(Student::getSurname,
                e -> new Student(e.getScore(), e.getSurname())));
    }

}
