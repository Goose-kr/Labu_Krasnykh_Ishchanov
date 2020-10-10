package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {
    private final static double ACCURACY = 0.00000001;
    MockTabulatedFunction mock = new MockTabulatedFunction();

    @Test
    public void testApply() {
        assertEquals(mock.apply(4.0), 3, ACCURACY);
        assertEquals(mock.apply(5.0), 4, ACCURACY);
        assertEquals(mock.apply(7.0), 6, ACCURACY);
        assertEquals(mock.apply(7),6,ACCURACY);
    }

    @Test
    public void testInterpolate() {
        assertEquals(mock.interpolate(4, 2, 5, 1, 4), 3, 0.0000001);
        assertEquals(mock.interpolate(10, 2, 15, 5, 10), 8.076923, 0.00001);
        assertEquals(mock.interpolate(-5, -8, 10, -1, 8), 0.5, 0.000001);

    }
}