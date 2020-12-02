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
    private final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
    private final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
    private final double[] yValues2 = new double[]{9, 1, 0, 1, 4};

    private final TabulatedFunction arrayTabulatedFunction1 = new ArrayTabulatedFunctionFactory().create(xValues1, yValues1);
    private final TabulatedFunction arrayTabulatedFunction2 = new ArrayTabulatedFunctionFactory().create(xValues1, yValues2);
    private final TabulatedFunction linkedListTabulatedFunction1 = new LinkedListTabulatedFunctionFactory().create(xValues1, yValues1);
    private final TabulatedFunction linkedListTabulatedFunction2 = new LinkedListTabulatedFunctionFactory().create(xValues1, yValues2);
    private final TabulatedFunction arrayError = new ArrayTabulatedFunctionFactory().create(new double[]{1, 2, 3, 4, 5}, yValues1);

    private TabulatedFunctionOperationService service1() {
        return new TabulatedFunctionOperationService();
    }

    private TabulatedFunctionOperationService service2() {
        return new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
    }

    @Test
    public void testAsPoints() {
        Point[] points = TabulatedFunctionOperationService.asPoints(arrayTabulatedFunction1);
        int i = 0;
        for (Point point : points) {
            assertEquals(point.x, arrayTabulatedFunction1.getX(i), 0.000001);
            assertEquals(point.y, arrayTabulatedFunction1.getY(i++), 0.000001);
        }
        assertEquals(i, arrayTabulatedFunction1.getCount());
        i = 0;
        for (Point point : points) {
            assertEquals(point.x, linkedListTabulatedFunction1.getX(i), 0.000001);
            assertEquals(point.y, linkedListTabulatedFunction1.getY(i++), 0.000001);
        }
        assertEquals(i, linkedListTabulatedFunction1.getCount());
    }

    @Test
    public void testGetFactory() {
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService();
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
        assertTrue(new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory()).getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }

    @Test
    public void testSetFactory() {
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService();
        tabulatedFunctionOperationService.setFactory(new LinkedListTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof LinkedListTabulatedFunctionFactory);
        tabulatedFunctionOperationService.setFactory(new ArrayTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
    }

    @Test
    public void testSum() {
        TabulatedFunction testSumArrayAndList = service1().sum(arrayTabulatedFunction1, linkedListTabulatedFunction2);
        int i = 0;
        for (Point point : testSumArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] + yValues2[i++]);
        }
        TabulatedFunction testSumArray = service1().sum(arrayTabulatedFunction2, arrayTabulatedFunction1);
        i = 0;
        for (Point point : testSumArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] + yValues1[i++]);
        }
        TabulatedFunction testSumList = service2().sum(linkedListTabulatedFunction1, linkedListTabulatedFunction2);
        i = 0;
        for (Point point : testSumList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] + yValues2[i++]);
        }

        assertTrue(testSumArray instanceof ArrayTabulatedFunction);
        assertTrue(testSumArrayAndList instanceof ArrayTabulatedFunction);
        assertTrue(testSumList instanceof LinkedListTabulatedFunction);

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                service1().sum(errorArray, linkedListTabulatedFunction2)
        );
        assertThrows(InconsistentFunctionsException.class, () -> service1().sum(arrayTabulatedFunction1, errorArray));
        assertThrows(InconsistentFunctionsException.class, () -> service1().sum(arrayTabulatedFunction1, arrayError));
    }

    @Test
    public void testSubtract() {
        TabulatedFunction testSubtractArrayAndList = service1().subtract(arrayTabulatedFunction1, linkedListTabulatedFunction2);
        int i = 0;
        for (Point point : testSubtractArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] - yValues2[i++]);
        }
        TabulatedFunction testSubtractArray = service1().subtract(arrayTabulatedFunction2, arrayTabulatedFunction1);
        i = 0;
        for (Point point : testSubtractArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] - yValues1[i++]);
        }
        TabulatedFunction testSubtractList = service2().subtract(linkedListTabulatedFunction1, linkedListTabulatedFunction2);
        i = 0;
        for (Point point : testSubtractList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] - yValues2[i++]);
        }
        assertTrue(testSubtractArray instanceof ArrayTabulatedFunction);
        assertTrue(testSubtractArrayAndList instanceof ArrayTabulatedFunction);
        assertTrue(testSubtractList instanceof LinkedListTabulatedFunction);

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                service1().subtract(errorArray, linkedListTabulatedFunction2)
        );
        assertThrows(InconsistentFunctionsException.class, () ->
                service1().subtract(arrayTabulatedFunction1, errorArray));
        assertThrows(InconsistentFunctionsException.class, () -> service2().sum(arrayTabulatedFunction1, arrayError));
    }

    @Test
    public void testMultiply() {
        TabulatedFunction testMultiplyArrayAndList = service1().multiply(arrayTabulatedFunction1, linkedListTabulatedFunction2);
        int i = 0;
        for (Point point : testMultiplyArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] * yValues2[i++]);
        }
        TabulatedFunction testMultiplyArray = service1().multiply(arrayTabulatedFunction2, arrayTabulatedFunction1);
        i = 0;
        for (Point point : testMultiplyArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] * yValues1[i++]);
        }
        TabulatedFunction testMultiplyList = service2().multiply(linkedListTabulatedFunction1, linkedListTabulatedFunction2);
        i = 0;
        for (Point point : testMultiplyList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] * yValues2[i++]);
        }
        assertTrue(testMultiplyArray instanceof ArrayTabulatedFunction);
        assertTrue(testMultiplyArrayAndList instanceof ArrayTabulatedFunction);
        assertTrue(testMultiplyList instanceof LinkedListTabulatedFunction);

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                service1().multiply(errorArray, linkedListTabulatedFunction2)
        );
        assertThrows(InconsistentFunctionsException.class, () -> service1().multiply(arrayTabulatedFunction1, errorArray));
        assertThrows(InconsistentFunctionsException.class, () -> service1().sum(arrayTabulatedFunction1, arrayError));
    }

    @Test
    public void testDivision() {
        TabulatedFunction testDivisionArrayAndList = service1().division(arrayTabulatedFunction1, linkedListTabulatedFunction2);
        int i = 0;
        for (Point point : testDivisionArrayAndList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] / yValues2[i++]);
        }
        TabulatedFunction testDivisionArray = service1().division(arrayTabulatedFunction2, arrayTabulatedFunction1);
        i = 0;
        for (Point point : testDivisionArray) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues2[i] / yValues1[i++]);
        }
        TabulatedFunction testDivisionList = service2().division(linkedListTabulatedFunction1, linkedListTabulatedFunction2);
        i = 0;
        for (Point point : testDivisionList) {
            assertEquals(point.x, xValues1[i]);
            assertEquals(point.y, yValues1[i] / yValues2[i++]);
        }
        assertTrue(testDivisionArray instanceof ArrayTabulatedFunction);
        assertTrue(testDivisionArrayAndList instanceof ArrayTabulatedFunction);
        assertTrue(testDivisionList instanceof LinkedListTabulatedFunction);

        final double[] xError = new double[]{1, 2, 3};
        final double[] yError = new double[]{1, 2, 3};
        ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(xError, yError);
        assertThrows(InconsistentFunctionsException.class, () ->
                service1().division(errorArray, linkedListTabulatedFunction2)
        );
        assertThrows(InconsistentFunctionsException.class, () -> service2().division(arrayTabulatedFunction1, errorArray));
        assertThrows(InconsistentFunctionsException.class, () -> service1().sum(arrayTabulatedFunction1, arrayError));
    }

}