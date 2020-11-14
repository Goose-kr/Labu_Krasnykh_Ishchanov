package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionFactoryTest {
    final double[] xValues = new double[]{1, 2, 3, 4, 5, 6};
    final double[] yValues = new double[]{1, 2, 3, 4, 5, 7};
    final double[] xValues1 = new double[]{1, 3, 5, 7, 8, 9};
    final double[] yValues1 = new double[]{1, 4, 6, 8, 9, 10};
    ArrayTabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();

    @Test
    public void testArrayTabulatedFunctionFactory() {

        assertEquals(factory.create(xValues, yValues).getClass(), ArrayTabulatedFunction.class);
        assertEquals(factory.create(xValues1, yValues).getClass(), ArrayTabulatedFunction.class);
        assertEquals(factory.create(xValues1, yValues1).getClass(), ArrayTabulatedFunction.class);
    }


}