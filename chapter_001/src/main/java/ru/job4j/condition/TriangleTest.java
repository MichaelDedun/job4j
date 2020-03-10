package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void whenExist() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        boolean result = Triangle.exist(ab, ac, bc);
        assertThat(result, is(true));
    }

}
