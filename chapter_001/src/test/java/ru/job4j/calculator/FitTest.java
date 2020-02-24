package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        double in = 100;
        double expected = 115;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected,out,0.01);
    }

    @Test
    public void womanWeight() {
        double in = 110;
        double expected = 126.5;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected,out,0.01);
    }

}
