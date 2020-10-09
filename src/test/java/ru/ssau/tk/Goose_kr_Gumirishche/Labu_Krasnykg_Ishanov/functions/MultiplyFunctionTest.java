package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MultiplyFunctionTest {
    public MathFunction multiply = new MultiplyFunction();

    @Test
    public void applyTest() {
        assertEquals(multiply.apply(5), 25, 0.000001);
        assertEquals(multiply.apply(-5), 25, 0.0001);
        assertEquals(multiply.apply(25), 625, 0.000001);
    }
}