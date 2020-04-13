package ru.job4j.lambda.controlquestions;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits().stream()
                        .map(unit -> new Holder(unit, student.getName())))
                .collect(Collectors.groupingBy(Holder::getKey, Collector.of(
                        HashSet::new,
                        (left, right) -> left.add(right.value),
                        (set, a) -> {
                            set.addAll(a);
                            return set;
                        }
                )));
    }

}
