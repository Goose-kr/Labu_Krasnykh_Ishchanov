package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {
    private final MathFunction composite = new CompositeFunction(new SumFunction(), new SqrFunction());

    public CompositeFunction hardFunction1() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        final CompositeFunction hardFunction = new CompositeFunction(new ArrayTabulatedFunction(xValues2, yValues2), new SqrFunction());
        return hardFunction;
    }

    public CompositeFunction hardFunction2() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        final CompositeFunction hardFunction = new CompositeFunction(new LinkedListTabulatedFunction(xValues2, yValues2), new SqrFunction());
        return hardFunction;
    }

    @Test
    public void testFunction() {
        assertEquals(hardFunction1().apply(16), 10000, 0.00001);
        assertEquals(hardFunction1().apply(-2), 16, 0.0001);
        assertEquals(hardFunction1().apply(2.5), 42.25, 0.0001);
        assertEquals(hardFunction2().apply(16), 10000, 0.00001);
        assertEquals(hardFunction2().apply(-2), 16, 0.0001);
        assertEquals(hardFunction2().apply(2.5), 42.25, 0.0001);
        assertEquals(composite.apply(5), 100, 0.000001);
        assertEquals(composite.apply(-4), 64, 0.00001);
        assertEquals(composite.apply(25), 2500, 0.00001);
    }


}