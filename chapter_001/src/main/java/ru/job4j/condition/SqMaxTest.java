package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void firstIsMax() {
        int result = SqMax.max(5, 2, 3, 4);
        assertThat(result, is(5));
    }

    @Test
    public void secondIsMax() {
        int result = SqMax.max(5, 6, 3, 0);
        assertThat(result, is(6));
    }

    @Test
    public void thirdIsMax() {
        int result = SqMax.max(0, 2, 5, 4);
        assertThat(result, is(5));
    }

    @Test
    public void forthIsMax() {
        int result = SqMax.max(1, 4, 3, 5);
        assertThat(result, is(5));
    }

    @Test
    public void allTheSame() {
        int result = SqMax.max(5, 5, 5, 5);
        assertThat(result, is(5));
    }

}
