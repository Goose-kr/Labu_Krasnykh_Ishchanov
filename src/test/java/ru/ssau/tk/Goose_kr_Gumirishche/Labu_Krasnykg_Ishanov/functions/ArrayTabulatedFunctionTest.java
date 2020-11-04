package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.exceptions.DifferentLengthOfArraysException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.exceptions.InterpolationException;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionTest {
    AbstractTabulatedFunction array1;
    AbstractTabulatedFunction array2;
    AbstractTabulatedFunction array3;
    ArrayTabulatedFunction array4;


    public AbstractTabulatedFunction arrayTabulatedFunction1() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return array1 = new ArrayTabulatedFunction(xValues1, yValues1);
    }

    public AbstractTabulatedFunction arrayTabulatedFunction2() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        return array2 = new ArrayTabulatedFunction(xValues2, yValues2);
    }

    public AbstractTabulatedFunction arrayTabulatedFunction3() {
        final CompositeFunction compositeFunction = new CompositeFunction(new SumFunction(), new SqrFunction());
        return array3 = new ArrayTabulatedFunction(compositeFunction, -3, 3, 7);
    }

    public ArrayTabulatedFunction arrayTabulatedFunction4() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return array4 = new ArrayTabulatedFunction(xValues1, yValues1);
    }
    public LinkedListTabulatedFunction getListOfArray() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return new LinkedListTabulatedFunction(xValues1, yValues1);
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

        assertThrows(IndexOutOfBoundsException.class, () -> {
            getListOfArray().getX(200);
            getListOfArray().getX(5);
            getListOfArray().getX(-2);
        });
    }

    @Test
    public void testGetY() {
        assertEquals(arrayTabulatedFunction1().getY(0), 4, 0.000001);
        assertEquals(arrayTabulatedFunction1().getY(4), 4, 0.0001);
        assertEquals(arrayTabulatedFunction2().getY(4), 0, 0.000001);
        assertEquals(arrayTabulatedFunction3().getY(4), 4, 0.000001);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            getListOfArray().getY(200);
            getListOfArray().getY(-4);
            getListOfArray().getY(5);
        });
    }

    @Test
    public void testSetY() {
        arrayTabulatedFunction1().setY(0, 16);
        arrayTabulatedFunction2().setY(4, -20);
        arrayTabulatedFunction3().setY(3, 16);
        assertEquals(array1.getY(0), 16, 0.000001);
        assertEquals(array2.getY(4), -20, 0.000001);
        assertEquals(array3.getY(3), 16, 0.00001);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            getListOfArray().setY(200, 1);
            getListOfArray().setY(-4, 4);
            getListOfArray().setY(5, 1);
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

        assertThrows(IllegalArgumentException.class, () -> {
            getListOfArray().floorIndexOfX(-3);
            getListOfArray().floorIndexOfX(-4);
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
            arrayTabulatedFunction2().interpolate(-1, 5);
            arrayTabulatedFunction2().interpolate(-2, 3);
        });
    }

    @Test
    public void testCheckLengthIsTheSame() {
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            new ArrayTabulatedFunction(new double[]{1, 2, 3, 4, 5}, new double[]{1, 2, 3, 4});
            new ArrayTabulatedFunction(new double[]{1, 2, 3, 4}, new double[]{1, 2, 3, 4, 5});
            new ArrayTabulatedFunction(new double[]{1}, new double[]{});
        });
    }

    @Test
    public void testCheckSorted() {
        assertThrows(ArrayIsNotSortedException.class, () -> {
            new ArrayTabulatedFunction(new double[]{5, 2, 3, 4, 5}, new double[]{1, 2, 3, 4, 5});
            new ArrayTabulatedFunction(new double[]{1, 5, 3, 4}, new double[]{1, 2, 3, 4});
            new ArrayTabulatedFunction(new double[]{3, 2}, new double[]{1, 2});
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
        assertThrows(NoSuchElementException.class, () -> {
            Point point = iterator.next();
        });
        i = 0;
        for (Point point : arrayTabulatedFunction4()) {
            assertEquals(point.x, arrayTabulatedFunction4().getX(i++));
        }
    }
}