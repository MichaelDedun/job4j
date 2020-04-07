package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diapason(1, 4, x -> 5 * x * x + 4 * x + 3);
        List<Double> expected = Arrays.asList(12D, 31D, 60D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunctionThenIndicativeResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diapason(1, 4, x -> Math.pow(4, x));
        List<Double> expected = Arrays.asList(4D, 16D, 64D);
        assertThat(result, is(expected));
    }

}
