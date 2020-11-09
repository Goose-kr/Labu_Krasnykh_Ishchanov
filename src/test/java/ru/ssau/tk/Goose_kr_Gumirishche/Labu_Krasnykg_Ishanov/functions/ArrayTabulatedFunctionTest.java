package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.DifferentLengthOfArraysException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.InterpolationException;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionTest {

    public AbstractTabulatedFunction arrayTabulatedFunction1() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return new ArrayTabulatedFunction(xValues1, yValues1);
    }

    public AbstractTabulatedFunction arrayTabulatedFunction2() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        return new ArrayTabulatedFunction(xValues2, yValues2);
    }

    public AbstractTabulatedFunction arrayTabulatedFunction3() {
        final CompositeFunction compositeFunction = new CompositeFunction(new SumFunction(), new SqrFunction());
        return new ArrayTabulatedFunction(compositeFunction, -3, 3, 7);
    }

    public ArrayTabulatedFunction arrayTabulatedFunction4() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return new ArrayTabulatedFunction(xValues1, yValues1);
    }

    @Test
    public void testCount() {
        assertEquals(arrayTabulatedFunction1().getCount(), 5, 0.00001);
        assertEquals(arrayTabulatedFunction2().getCount(), 9, 0.00001);
        assertEquals(arrayTabulatedFunction3().getCount(), 7, 0.0001);
    }

    @Test
    public void testGetX() {
        assertEquals(arrayTabulatedFunction1().getX(0), -2, 0.000001);
        assertEquals(arrayTabulatedFunction1().getX(4), 2, 0.0001);
        assertEquals(arrayTabulatedFunction2().getX(4), 0, 0.000001);
        assertEquals(arrayTabulatedFunction3().getX(3), 0, 0.00001);

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).getX(200);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).getX(5);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).getX(-2);
        });
    }

    @Test
    public void testGetY() {
        assertEquals(arrayTabulatedFunction1().getY(0), 4, 0.000001);
        assertEquals(arrayTabulatedFunction1().getY(4), 4, 0.0001);
        assertEquals(arrayTabulatedFunction2().getY(4), 0, 0.000001);
        assertEquals(arrayTabulatedFunction3().getY(4), 4, 0.000001);

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).getY(200);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).getY(-4);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).getY(5);
        });
    }

    @Test
    public void testSetY() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        AbstractTabulatedFunction array1 = new ArrayTabulatedFunction(xValues1, yValues1);
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        AbstractTabulatedFunction array2 = new ArrayTabulatedFunction(xValues2, yValues2);
        final CompositeFunction compositeFunction = new CompositeFunction(new SumFunction(), new SqrFunction());
        new ArrayTabulatedFunction(compositeFunction, -3, 3, 7);
        AbstractTabulatedFunction array3 = new ArrayTabulatedFunction(compositeFunction, -3, 3, 7);
        array1.setY(0, 16);
        array2.setY(4, -20);
        array3.setY(3, 16);
        assertEquals(array1.getY(0), 16, 0.000001);
        assertEquals(array2.getY(4), -20, 0.000001);
        assertEquals(array3.getY(3), 16, 0.00001);


        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).setY(200, 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).setY(-4, 4);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).setY(5, 1);
        });
    }

    @Test
    public void testIndexOfX() {
        assertEquals(arrayTabulatedFunction1().indexOfX(-1), 1, 0.00001);
        assertEquals(arrayTabulatedFunction1().indexOfX(10), -1, 0.00001);
        assertEquals(arrayTabulatedFunction2().indexOfX(3), 7, 0.00001);
        assertEquals(arrayTabulatedFunction3().indexOfX(-1), 2, 0.00001);
        assertEquals(arrayTabulatedFunction3().indexOfX(-5), -1, 0.000001);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(arrayTabulatedFunction2().indexOfY(16), 0, 0.00001);
        assertEquals(arrayTabulatedFunction2().indexOfY(436436), -1, 0.00001);
        assertEquals(arrayTabulatedFunction1().indexOfY(4), 0, 0.0001);
        assertEquals(arrayTabulatedFunction3().indexOfY(36), 0, 0.0001);
        assertEquals(arrayTabulatedFunction3().indexOfY(100), -1, 0.0001);
    }

    @Test
    public void testLeftBound() {
        assertEquals(arrayTabulatedFunction1().leftBound(), -2, 0.00001);
        assertEquals(arrayTabulatedFunction2().leftBound(), -4, 0.00001);
        assertEquals(arrayTabulatedFunction3().leftBound(), -3, 0.00001);
    }

    @Test
    public void testRightBound() {
        assertEquals(arrayTabulatedFunction1().rightBound(), 2, 0.00001);
        assertEquals(arrayTabulatedFunction2().rightBound(), 4, 0.00001);
        assertEquals(arrayTabulatedFunction3().rightBound(), 3, 0.00001);
    }

    @Test
    public void testFloorIndexOfX() {
        assertEquals(arrayTabulatedFunction2().floorIndexOfX(-3.5), 0, 0.00001);
        assertEquals(arrayTabulatedFunction2().floorIndexOfX(-0.1421), 3, 0.00001);
        assertEquals(arrayTabulatedFunction1().floorIndexOfX(-1.5), 0, 0.00001);
        assertEquals(arrayTabulatedFunction3().floorIndexOfX(1.5), 4, 0.0001);
        assertEquals(arrayTabulatedFunction3().floorIndexOfX(-2.5), 0, 0.0001);

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).floorIndexOfX(-3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayTabulatedFunction(xValues1, yValues1).floorIndexOfX(-4);
        });
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(arrayTabulatedFunction2().extrapolateLeft(5), -47, 0.00001);
        assertEquals(arrayTabulatedFunction2().extrapolateLeft(17), -131, 0.000001);
        assertEquals(arrayTabulatedFunction2().extrapolateLeft(-16), 100, 0.00001);
        assertEquals(arrayTabulatedFunction3().extrapolateLeft(15), -324, 0.00001);
        assertEquals(arrayTabulatedFunction3().extrapolateLeft(20), -424, 0.00001);
        assertEquals(arrayTabulatedFunction3().extrapolateLeft(-16), 296, 0.0001);

    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(arrayTabulatedFunction2().extrapolateRight(5), 23, 0.00001);
        assertEquals(arrayTabulatedFunction2().extrapolateRight(15), 93, 0.000001);
        assertEquals(arrayTabulatedFunction2().extrapolateRight(-20), -152, 0.00001);
        assertEquals(arrayTabulatedFunction3().extrapolateRight(15), 276, 0.0001);
        assertEquals(arrayTabulatedFunction3().extrapolateRight(-1325), -26524, 0.00001);
    }

    @Test
    public void testInterpolate() {
        assertEquals(arrayTabulatedFunction2().interpolate(-1.5, 2), 2.5, 0.000001);
        assertEquals(arrayTabulatedFunction2().interpolate(-2.5, 1), 6.5, 0.0001);
        assertEquals(arrayTabulatedFunction2().interpolate(2.5, 6), 6.5, 0.00001);
    }

    @Test
    public void testApply() {
        assertEquals(arrayTabulatedFunction1().apply(16), 46, 0.00001);
        assertEquals(arrayTabulatedFunction1().apply(-16), 46, 0.000001);
        assertEquals(arrayTabulatedFunction1().apply(-2), 4, 0.0001);
        assertEquals(arrayTabulatedFunction1().apply(0.5), 0.5, 0.000001);
        assertEquals(arrayTabulatedFunction3().apply(-4), 56, 0.00001);
        assertEquals(arrayTabulatedFunction3().apply(5), 76, 0.00001);
        assertEquals(arrayTabulatedFunction3().apply(-2), 16, 0.00001);
        assertEquals(arrayTabulatedFunction3().apply(-1.5), 10, 0.00001);
    }

    @Test
    public void testInterpolationException() {
        assertThrows(InterpolationException.class, () -> {
            arrayTabulatedFunction1().interpolate(-2, 1);
        });
        assertThrows(InterpolationException.class, () -> {
            arrayTabulatedFunction2().interpolate(-1, 5);
        });
        assertThrows(InterpolationException.class, () -> {
            arrayTabulatedFunction2().interpolate(-2, 3);
        });
    }

    @Test
    public void testCheckLengthIsTheSame() {
        double[] xValues = new double[]{1, 2, 3, 4, 5};
        double[] yValues = new double[]{1, 4, 9, 16, 25};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);
        assertEquals(arrayTabulatedFunction.getX(0), 1, 0.001);

        assertThrows(DifferentLengthOfArraysException.class, () -> {
            new ArrayTabulatedFunction(new double[]{1, 2, 3, 4, 5}, new double[]{1, 2, 3, 4});
        });
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            new ArrayTabulatedFunction(new double[]{1, 2, 3, 4}, new double[]{1, 2, 3, 4, 5});
        });
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            new ArrayTabulatedFunction(new double[]{1}, new double[]{});
        });
    }

    @Test
    public void testCheckSorted() {
        double[] xValues = new double[]{1, 2, 3, 4, 5};
        double[] yValues = new double[]{1, 4, 9, 16, 25};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);
        assertEquals(arrayTabulatedFunction.getX(0), 1, 0.001);

        assertThrows(ArrayIsNotSortedException.class, () -> {
            new ArrayTabulatedFunction(new double[]{5, 2, 3, 4, 5}, new double[]{1, 2, 3, 4, 5});
        });
        assertThrows(ArrayIsNotSortedException.class, () -> {
            new ArrayTabulatedFunction(new double[]{1, 5, 3, 4}, new double[]{1, 2, 3, 4});
        });
        assertThrows(ArrayIsNotSortedException.class, () -> {
            new ArrayTabulatedFunction(new double[]{3, 2}, new double[]{1, 2});
        });
    }

    @Test
    public void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayTabulatedFunction(new double[]{1}, new double[]{2});
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayTabulatedFunction(new SqrFunction(), 1, 2, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayTabulatedFunction(new SqrFunction(), 3, 1, 3);
        });
    }

    @Test
    public void testIterator() {
        Iterator<Point> iterator = arrayTabulatedFunction4().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(point.x, arrayTabulatedFunction4().getX(i++));
        }
        assertEquals(i, arrayTabulatedFunction4().count);
        assertThrows(NoSuchElementException.class, () -> {
            Point point = iterator.next();
        });
        i = 0;
        for (Point point : arrayTabulatedFunction4()) {
            assertEquals(point.x, arrayTabulatedFunction4().getX(i++));
        }
        assertEquals(i, arrayTabulatedFunction4().count);
    }
}