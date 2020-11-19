package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.InconsistentFunctionsException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.Point;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactoryTest;

import static org.testng.Assert.*;

public class TabulatedFunctionOperationServiceTest {
    final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
    final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
    final double[] yValues2 = new double[]{9, 1, 0, 1, 4};

    private ArrayTabulatedFunction arrayTabulatedFunction1() {
        return new ArrayTabulatedFunction(xValues1, yValues1);
    }

    private LinkedListTabulatedFunction linkedListTabulatedFunction1() {
        return new LinkedListTabulatedFunction(xValues1, yValues1);
    }

    private ArrayTabulatedFunction arrayTabulatedFunction2() {
        return new ArrayTabulatedFunction(xValues1, yValues2);
    }

    private LinkedListTabulatedFunction linkedListTabulatedFunction2() {
        return new LinkedListTabulatedFunction(xValues1, yValues2);
    }

    TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService();

    @Test
    public void testAsPoints() {
        Point[] points = TabulatedFunctionOperationService.asPoints(arrayTabulatedFunction1());
        int i = 0;
        for (Point point : points) {
            assertEquals(point.x, arrayTabulatedFunction1().getX(i), 0.000001);
            assertEquals(point.y, arrayTabulatedFunction1().getY(i++), 0.000001);
        }
        assertEquals(i, arrayTabulatedFunction1().getCount());
        i = 0;
        for (Point point : points) {
            assertEquals(point.x, linkedListTabulatedFunction1().getX(i), 0.000001);
            assertEquals(point.y, linkedListTabulatedFunction1().getY(i++), 0.000001);
        }
        assertEquals(i, linkedListTabulatedFunction1().getCount());
    }

    @Test
    public void testGetFactory() {
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
        assertTrue(new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory()).getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }

    @Test
    public void testSetFactory() {
        tabulatedFunctionOperationService.setFactory(new LinkedListTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof LinkedListTabulatedFunctionFactory);
        tabulatedFunctionOperationService.setFactory(new ArrayTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
    }

    @Test
    public void testSum() {
        TabulatedFunction testSumArrayAndList = new TabulatedFunctionOperationService().sum(arrayTabulatedFunction1(), linkedListTabulatedFunction2());
        int i = 0;
        for (Point point : testSumArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] + yValues2[i++]);
        }
        TabulatedFunction testSumArray = new TabulatedFunctionOperationService().sum(arrayTabulatedFunction2(), arrayTabulatedFunction1());
        i = 0;
        for (Point point : testSumArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] + yValues1[i++]);
        }
        TabulatedFunction testSumList = new TabulatedFunctionOperationService().sum(linkedListTabulatedFunction1(), linkedListTabulatedFunction2());
        i = 0;
        for (Point point : testSumList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] + yValues2[i++]);
        }

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                new TabulatedFunctionOperationService().sum(errorArray, linkedListTabulatedFunction2())
        );
        assertThrows(InconsistentFunctionsException.class, () -> new TabulatedFunctionOperationService().sum(arrayTabulatedFunction1(), errorArray));
    }

    @Test
    public void testSubtract() {
        TabulatedFunction testSubtractArrayAndList = new TabulatedFunctionOperationService().subtract(arrayTabulatedFunction1(), linkedListTabulatedFunction2());
        int i = 0;
        for (Point point : testSubtractArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] - yValues2[i++]);
        }
        TabulatedFunction testSubtractArray = new TabulatedFunctionOperationService().subtract(arrayTabulatedFunction2(), arrayTabulatedFunction1());
        i = 0;
        for (Point point : testSubtractArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] - yValues1[i++]);
        }
        TabulatedFunction testSubtractList = new TabulatedFunctionOperationService().subtract(linkedListTabulatedFunction1(), linkedListTabulatedFunction2());
        i = 0;
        for (Point point : testSubtractList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] - yValues2[i++]);
        }

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                new TabulatedFunctionOperationService().subtract(errorArray, linkedListTabulatedFunction2())
        );
        assertThrows(InconsistentFunctionsException.class, () ->
                new TabulatedFunctionOperationService().subtract(arrayTabulatedFunction1(), errorArray));
    }

    @Test
    public void testMultiply() {
        TabulatedFunction testMultiplyArrayAndList = new TabulatedFunctionOperationService().multiply(arrayTabulatedFunction1(), linkedListTabulatedFunction2());
        int i = 0;
        for (Point point : testMultiplyArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] * yValues2[i++]);
        }
        TabulatedFunction testMultiplyArray = new TabulatedFunctionOperationService().multiply(arrayTabulatedFunction2(), arrayTabulatedFunction1());
        i = 0;
        for (Point point : testMultiplyArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] * yValues1[i++]);
        }
        TabulatedFunction testMultiplyList = new TabulatedFunctionOperationService().multiply(linkedListTabulatedFunction1(), linkedListTabulatedFunction2());
        i = 0;
        for (Point point : testMultiplyList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] * yValues2[i++]);
        }

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                new TabulatedFunctionOperationService().multiply(errorArray, linkedListTabulatedFunction2())
        );
        assertThrows(InconsistentFunctionsException.class, () -> new TabulatedFunctionOperationService().multiply(arrayTabulatedFunction1(), errorArray));
    }

    @Test
    public void testDivision() {
        TabulatedFunction testDivisionArrayAndList = new TabulatedFunctionOperationService().division(arrayTabulatedFunction1(), linkedListTabulatedFunction2());
        int i = 0;
        for (Point point : testDivisionArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] / yValues2[i++]);
        }
        TabulatedFunction testDivisionArray = new TabulatedFunctionOperationService().division(arrayTabulatedFunction2(), arrayTabulatedFunction1());
        i = 0;
        for (Point point : testDivisionArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] / yValues1[i++]);
        }
        TabulatedFunction testDivisionList = new TabulatedFunctionOperationService().division(linkedListTabulatedFunction1(), linkedListTabulatedFunction2());
        i = 0;
        for (Point point : testDivisionList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] / yValues2[i++]);
        }

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                new TabulatedFunctionOperationService().division(errorArray, linkedListTabulatedFunction2())
        );
        assertThrows(InconsistentFunctionsException.class, () -> new TabulatedFunctionOperationService().division(arrayTabulatedFunction1(), errorArray));
    }

}