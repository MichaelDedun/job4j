package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNum1and1and2and2and10and10() {
        String[] input = {
                "10.3 Task.",
                "10.1 Task.",
                "10.2 Task."
        };
        String[] out = {
                "10.1 Task.",
                "10.2 Task.",
                "10.3 Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNumsWithDifferentLength() {
        String[] input = {
                "10.3 Task.",
                "10.3.3 Task.",
                "10.1.6 Task."
        };
        String[] out = {
                "10.1.6 Task.",
                "10.3 Task.",
                "10.3.3 Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

}
