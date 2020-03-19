package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenZeroInArgument() {
        Fact.calc(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLessThanZero() {
        Fact.calc(-1);
    }

    @Test
    public void fromOneToThree() {
        int result = Fact.calc(3);
        assertThat(result, is(6));
    }

}
