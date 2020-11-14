package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionFactoryTest {
    final double[] xValues=new double[]{1,8,6,5.3,4};
    final double[] yValues=new double[]{5,7,9,7.2,2};
    final double[] xValues1=new double[]{1,4,9,5,2};
    final double[] yValues1=new double[]{5,4,6,7,4};
    LinkedListTabulatedFunctionFactory factory=new LinkedListTabulatedFunctionFactory();
    @Test
    public void testLinkedListTabulatedFunctionFactory(){

        assertEquals(factory.create(xValues,yValues).getClass(), LinkedListTabulatedFunctionFactory.class);
        assertEquals(factory.create(xValues1,yValues).getClass(), LinkedListTabulatedFunctionFactory.class);
        assertEquals(factory.create(xValues1,yValues1).getClass(), LinkedListTabulatedFunction.class);
    }

}