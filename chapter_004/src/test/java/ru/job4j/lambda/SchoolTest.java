package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Student> result = school.collect(students, student -> student.score >= 70 && student.score <= 100);
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
        List<Student> result = school.collect(students, student -> student.score >= 50 && student.score <= 70);
        List<Student> expected = Arrays.asList(
                new Student(50),
                new Student(60),
                new Student(51),
                new Student(70)
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
                new Student(94)
        );
        List<Student> result = school.collect(students, student -> student.score >= 0 && student.score <= 50);
        List<Student> expected = Arrays.asList(
                new Student(50),
                new Student(1)
        );
        Assert.assertEquals(expected, result);
    }

}