package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.DifferentLengthOfArraysException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {
    private final static double ACCURACY = 0.00000001;
    private final MockTabulatedFunction mock = new MockTabulatedFunction();

    @Test
    public void testApply() {
        assertEquals(mock.apply(4.0), 3, ACCURACY);
        assertEquals(mock.apply(5.0), 4, ACCURACY);
        assertEquals(mock.apply(7.0), 6, ACCURACY);
        assertEquals(mock.apply(7), 6, ACCURACY);
    }

    @Test
    public void testCheckSorted() {
        assertThrows(ArrayIsNotSortedException.class, () -> {
            double[] xValues = new double[]{-1, 0, 1, -2, 2};
            AbstractTabulatedFunction.checkSorted(xValues);
        });
        assertThrows(ArrayIsNotSortedException.class, () -> {
            double[] xValues = new double[]{1, -1, 0, 1, 2};
            AbstractTabulatedFunction.checkSorted(xValues);
        });
    }

    @Test
    public void testCheckLengthIsTheSame() {
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            double[] xValues = new double[]{1, 2, 3, 4, 5, 6};
            double[] yValues = new double[]{1, 2, 3, 4, 5, 6, 7};
            AbstractTabulatedFunction.checkLengthIsTheSame(xValues, yValues);
        });
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            double[] xValues = new double[]{1, 2, 3, 4, 5, 6, 7, 8};
            double[] yValues = new double[]{1, 2, 3, 4, 5, 6, 7};
            AbstractTabulatedFunction.checkLengthIsTheSame(xValues, yValues);
        });
    }
    @Test
    public void testToString(){
        TabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunction listFunction = listFactory.create(new double[]{1.,2.,3.,4.}, new double[]{5.,6.,7.,8.});
        TabulatedFunction arrayFunction = arrayFactory.create(new double[]{10.,13.,15.,18.,19.},new double[]{11.,32.,36.,47.,58.});
        assertEquals(listFunction.toString(), "LinkedListTabulatedFunction; size = 4\n[1.0, 5.0]\n[2.0, 6.0]\n[3.0, 7.0]\n[4.0, 8.0]");
        assertEquals(arrayFunction.toString(), "ArrayTabulatedFunction; size = 5\n[10.0, 11.0]\n[13.0, 32.0]\n[15.0, 36.0]\n[18.0, 47.0]\n[19.0, 58.0]");
    }

}