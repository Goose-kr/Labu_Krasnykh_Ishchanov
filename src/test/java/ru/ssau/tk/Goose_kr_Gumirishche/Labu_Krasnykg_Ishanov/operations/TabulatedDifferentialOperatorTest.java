package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import java.util.Map;


public class TabulatedDifferentialOperatorTest {
    static TabulatedFunctionFactory arrayTabulatedFunctionFactory = new ArrayTabulatedFunctionFactory();
    static TabulatedFunctionFactory linkedListTabulatedFunctionFactory = new LinkedListTabulatedFunctionFactory();
    private static final double[] xValues = new double[]{-7., -6., -2., 0., 4., 5., 7.};
    private static final double[] yValues = new double[]{7., 2., 4., 0., 8., 3., 7.};
    private static final double[] derivedYValues = new double[]{-5., 0.5, -2., 2., -5., 2., 2.};
    private static final double[] newXValues = new double[]{3., 5., 20., 31., 45.};
    private static final double[] newYValues = new double[]{7., 32., 75., 41., 87.};
    private static final double[] newDerivedYValues = new double[]{12.5, 2.866667, -3.090909091, 3.2857, 3.2857};
    final static TabulatedFunction function1 = linkedListTabulatedFunctionFactory.create(xValues, yValues);
    final static TabulatedFunction function2 = arrayTabulatedFunctionFactory.create(xValues, yValues);
    final static TabulatedFunction newFunction1 = linkedListTabulatedFunctionFactory.create(newXValues, newYValues);
    final static TabulatedFunction newFunction2 = arrayTabulatedFunctionFactory.create(newXValues, newYValues);
    static TabulatedDifferentialOperator operator1 = new TabulatedDifferentialOperator();
    static TabulatedDifferentialOperator operator2 = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
    static TabulatedDifferentialOperator operator3 = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());

    @Test
    public void testGetFactory() {
        assertEquals(operator1.getFactory(), ArrayTabulatedFunctionFactory.class);
        assertEquals(operator2.getFactory(), ArrayTabulatedFunctionFactory.class);
        assertEquals(operator3.getFactory(), LinkedListTabulatedFunctionFactory.class);
    }

    @Test
    public void testSetFactory() {
        operator1.setFactory(new LinkedListTabulatedFunctionFactory());
        operator2.setFactory(new ArrayTabulatedFunctionFactory());
        operator3.setFactory(new ArrayTabulatedFunctionFactory());
        assertEquals(operator1.getFactory(), LinkedListTabulatedFunctionFactory.class);
        assertEquals(operator2.getFactory(), ArrayTabulatedFunctionFactory.class);
        assertEquals(operator3.getFactory(), ArrayTabulatedFunctionFactory.class);
    }

    @Test
    public void testDerive() {
        TabulatedFunction derivedArrayFunction = operator1.derive(function2);
        TabulatedFunction derivedLinkedListFunction = operator3.derive(function1);

        int count = derivedArrayFunction.getCount();
        for (int i = 0; i < count; i++) {
            assertEquals(derivedArrayFunction.getY(i), derivedYValues[i], 0.01);
            assertEquals(derivedLinkedListFunction.getY(i), derivedYValues[i], 0.01);
        }
        derivedArrayFunction = operator1.derive(newFunction1);
        derivedLinkedListFunction = operator3.derive(newFunction2);
        count = derivedArrayFunction.getCount();
        for (int i = 0; i < count; i++) {
            assertEquals(derivedArrayFunction.getY(i), newDerivedYValues[i], 0.01);
            assertEquals(derivedLinkedListFunction.getY(i), newDerivedYValues[i], 0.01);
        }
    }


}