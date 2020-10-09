package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {
    private final MathFunction composite = new CompositeFunction(new SumFunction(), new SqrFunction());

    @Test
    public void testFunction() {
        assertEquals(composite.apply(5), 100, 0.000001);
        assertEquals(composite.apply(-4), 64, 0.00001);
        assertEquals(composite.apply(25), 2500, 0.00001);
    }


}