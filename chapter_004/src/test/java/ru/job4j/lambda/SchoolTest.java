package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SchoolTest {

    @Test
    public void testForDiapasonForTenAClass() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student(50),
                new Student(60),
                new Student(51),
                new Student(70),
                new Student(82),
                new Student(1),
                new Student(94)
        );
        List<Student> result = school.collect(students, student -> student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> expected = Arrays.asList(
                new Student(70),
                new Student(82),
                new Student(94)
        );
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testForDiapasonForTenBClass() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student(50),
                new Student(60),
                new Student(51),
                new Student(70),
                new Student(82),
                new Student(1),
                new Student(94)
        );
        List<Student> result = school.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Student> expected = Arrays.asList(
                new Student(50),
                new Student(60),
                new Student(51)
        );
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testForDiapasonForTenCClass() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student(50),
                new Student(60),
                new Student(51),
                new Student(70),
                new Student(82),
                new Student(1),
                new Student(0),
                new Student(94)
        );
        List<Student> result = school.collect(students, student -> student.getScore() > 0 && student.getScore() < 50);
        List<Student> expected = Collections.singletonList(
                new Student(1)
        );
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testListToMap() {
        School school = new School();
        List<Student> students = Arrays.asList(
                new Student(50, "Sorokin"),
                new Student(60, "Petrov"),
                new Student(51, "Sidorov"),
                new Student(51, "Sidorov")
        );
        Map<String, Student> result = school.collectToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Sorokin", new Student(50, "Sorokin"));
        expected.put("Petrov", new Student(60, "Petrov"));
        expected.put("Sidorov", new Student(51, "Sidorov"));
        Assert.assertEquals(expected, result);
    }

}
