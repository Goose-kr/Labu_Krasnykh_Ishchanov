package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.DifferentLengthOfArraysException;

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

}