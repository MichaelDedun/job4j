package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {

    @Test
    public void whenSort() {
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void sortWhenArrayHasThreeElements() {
        int[] input = new int[]{3, 2, 2};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[]{2, 2, 3};
        assertThat(result, is(expect));
    }

    @Test
    public void sortWhenArrayHasFiveElements() {
        int[] input = new int[]{Integer.MAX_VALUE, -1, 0, 2, 3};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[]{-1, 0, 2, 3, Integer.MAX_VALUE};
        assertThat(result, is(expect));
    }

}
