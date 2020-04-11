package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = new ArrayList<>(List.of("k1/sk1/ssk1"));
        List<String> expect = new ArrayList<>(List.of("k1", "k1/sk1", "k1/sk1/ssk1"));
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = new ArrayList<>(List.of("k1", "k1/sk1"));
        List<String> expect = new ArrayList<>(List.of("k1", "k1/sk1"));
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void testDescSort() {
        List<String> input = new ArrayList<>(List.of("K1/SK1/SSK1", "K1/SK1/SSK2", "K2/SK1/SSK1", "K2/SK1/SSK2"));
        List<String> expect = new ArrayList<>(List.of("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2", "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2"));
        List<String> result = Departments.fillGaps(input);
        Departments.sortDesc(result);
        assertThat(result, is(expect));
    }

}
