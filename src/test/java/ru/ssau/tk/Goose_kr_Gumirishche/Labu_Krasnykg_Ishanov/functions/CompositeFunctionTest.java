package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {
    private final MathFunction composite = new CompositeFunction(new SumFunction(), new SqrFunction());

    public CompositeFunction hardFunction1() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        return new CompositeFunction(new ArrayTabulatedFunction(xValues2, yValues2), new SqrFunction());
    }

    public CompositeFunction hardFunction2() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        return new CompositeFunction(new LinkedListTabulatedFunction(xValues2, yValues2), new SqrFunction());
    }

    public CompositeFunction hardFunction3() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        return new CompositeFunction(new ArrayTabulatedFunction(xValues1, yValues1), new LinkedListTabulatedFunction(xValues2, yValues2));
    }

    @Test
    public void testFunction() {
        assertEquals(hardFunction1().apply(16), 10000, 0.00001);
        assertEquals(hardFunction1().apply(-2), 16, 0.0001);
        assertEquals(hardFunction1().apply(2.5), 42.25, 0.0001);
        assertEquals(hardFunction2().apply(16), 10000, 0.00001);
        assertEquals(hardFunction2().apply(-2), 16, 0.0001);
        assertEquals(hardFunction2().apply(2.5), 42.25, 0.0001);
        assertEquals(hardFunction3().apply(-6), 100, 0.0001);
        assertEquals(hardFunction3().apply(1), 1, 0.000001);
        assertEquals(hardFunction3().apply(1.5), 6.5, 0.0001);
        assertEquals(composite.apply(5), 100, 0.000001);
        assertEquals(composite.apply(-4), 64, 0.00001);
        assertEquals(composite.apply(25), 2500, 0.00001);
    }


}