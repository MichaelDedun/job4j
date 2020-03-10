package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenLeftEqualsRightOrRightEqualsLeft() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenLeftLessThanRight() {
        int result = Max.max(3, 2);
        assertThat(result, is(3));

    }

    @Test
    public void testWithThreeVariable() {
        int result = Max.max(4, 5, 4);
        assertThat(result, is(5));
    }

    @Test
    public void testWithFourVariable() {
        int result = Max.max(5, 3, 9, 6);
        assertThat(result, is(9));
    }

}
