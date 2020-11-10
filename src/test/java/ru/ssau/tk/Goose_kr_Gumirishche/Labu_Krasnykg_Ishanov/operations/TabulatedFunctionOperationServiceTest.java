package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.Point;

import static org.testng.Assert.*;

public class TabulatedFunctionOperationServiceTest {
    final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
    final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
    ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValues1, yValues1);
    LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValues1, yValues1);

    @Test
    public void testAsPoints() {
        Point[] points = TabulatedFunctionOperationService.asPoints(arrayTabulatedFunction);
        int i = 0;
        for (Point point : points) {
            assertEquals(point.x, arrayTabulatedFunction.getX(i), 0.000001);
            assertEquals(point.y, arrayTabulatedFunction.getY(i++), 0.000001);
        }
        assertEquals(i, arrayTabulatedFunction.getCount());
        i = 0;
        for (Point point : points) {
            assertEquals(point.x, linkedListTabulatedFunction.getX(i), 0.000001);
            assertEquals(point.y, linkedListTabulatedFunction.getY(i++), 0.000001);
        }
        assertEquals(i, linkedListTabulatedFunction.getCount());
    }
}