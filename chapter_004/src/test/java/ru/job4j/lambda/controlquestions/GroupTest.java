package ru.job4j.lambda.controlquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupTest {

    @Test
    public void testGroup() {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student("kek",
                                Set.of(
                                        "test",
                                        "test2",
                                        "test3"
                                )
                        ),
                        new Student("lol",
                                Set.of(
                                        "test"
                                )
                        ))
        );
        Map<String, Set<String>> result = Group.sections(students);
        Map<String, Set<String>> expected = Map.of(
                "test2", Set.of("kek"),
                "test3", Set.of("kek"),
                "test", Set.of("kek", "lol")
        );
        Assert.assertEquals(result, expected);
    }

}
