package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        int rsl = Counter.sumByEven(1, 10);
        int expected = 30;
        assertThat(rsl, is(expected));
    }

    @Test
    public void checkOnZeroSum() {
        int rsl = Counter.sumByEven(0, 0);
        int expected = 0;
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSumEvenNumbersFromThreeToEightThenEighteen() {
        int rsl = Counter.sumByEven(3, 8);
        int expected = 18;
        assertThat(rsl, is(expected));
    }

}
