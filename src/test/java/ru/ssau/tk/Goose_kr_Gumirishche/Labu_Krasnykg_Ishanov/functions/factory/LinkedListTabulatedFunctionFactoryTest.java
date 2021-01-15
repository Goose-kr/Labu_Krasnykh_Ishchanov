package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.*;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionFactoryTest {
    final double[] xValues = new double[]{1, 2, 3, 4, 5, 6};
    final double[] yValues = new double[]{1, 2, 3, 4, 5, 7};
    final double[] xValues1 = new double[]{1, 3, 5, 7, 8, 9};
    final double[] yValues1 = new double[]{1, 4, 6, 8, 9, 10};
    LinkedListTabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
    private final TabulatedFunctionFactory linkedList = new LinkedListTabulatedFunctionFactory();

    @Test
    public void testLinkedListTabulatedFunctionFactory() {

        assertEquals(factory.create(xValues, yValues).getClass(), LinkedListTabulatedFunction.class);
        assertEquals(factory.create(xValues1, yValues).getClass(), LinkedListTabulatedFunction.class);
        assertEquals(factory.create(xValues1, yValues1).getClass(), LinkedListTabulatedFunction.class);
    }

    @Test
    public void testCreateStrict() {
        TabulatedFunction function = linkedList.createStrict(xValues, yValues);
        assertTrue(function instanceof StrictTabulatedFunction);
    }

    @Test
    public void createUnmodifiable() {
        TabulatedFunction function = linkedList.createUnmodifiable(xValues, yValues);
        assertTrue(function instanceof UnmodifiableTabulatedFunction);
    }

    @Test
    public void testCreateStrictUnmodifiable() {
        TabulatedFunction function = linkedList.createStrictUnmodifiable(xValues, yValues);
        assertThrows(UnsupportedOperationException.class, () -> function.setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> function.apply(0));
    }
}