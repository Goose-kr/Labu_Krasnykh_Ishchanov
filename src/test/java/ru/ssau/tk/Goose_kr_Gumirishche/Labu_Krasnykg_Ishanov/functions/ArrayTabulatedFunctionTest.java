package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionTest {
    AbstractTabulatedFunction array1;
    AbstractTabulatedFunction array2;
    AbstractTabulatedFunction array3;

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

    public AbstractTabulatedFunction arrayTabulatedFunctionSet1() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        final AbstractTabulatedFunction arrayTabulatedFunction1 = new ArrayTabulatedFunction(xValues1, yValues1);
        arrayTabulatedFunction1.setY(0, 16);
        return arrayTabulatedFunction1;
    }

    public AbstractTabulatedFunction arrayTabulatedFunctionSet2() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        final AbstractTabulatedFunction arrayTabulatedFunction2 = new ArrayTabulatedFunction(xValues2, yValues2);
        arrayTabulatedFunction2.setY(4, -20);
        return arrayTabulatedFunction2;
    }

    public AbstractTabulatedFunction arrayTabulatedFunctionSet3() {
        final CompositeFunction compositeFunction = new CompositeFunction(new SumFunction(), new SqrFunction());
        final AbstractTabulatedFunction arrayTabulatedFunction3 = new ArrayTabulatedFunction(compositeFunction, -3, 3, 7);
        arrayTabulatedFunction3.setY(3, 16);
        return arrayTabulatedFunction3;
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
    }

    @Test
    public void testGetY() {
        assertEquals(arrayTabulatedFunction1().getY(0), 4, 0.000001);
        assertEquals(arrayTabulatedFunction1().getY(4), 4, 0.0001);
        assertEquals(arrayTabulatedFunction2().getY(4), 0, 0.000001);
        assertEquals(arrayTabulatedFunction3().getY(4), 4, 0.000001);
    }

    @Test
    public void testSetY() {
        arrayTabulatedFunction1().setY(0, 16);
        arrayTabulatedFunction2().setY(4, -20);
        arrayTabulatedFunction3().setY(3, 16);
        assertEquals(array1.getY(0), 16, 0.000001);
        assertEquals(array2.getY(4), -20, 0.000001);
        assertEquals(array3.getY(3), 16, 0.00001);
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
        assertEquals(arrayTabulatedFunction1().floorIndexOfX(-10), 0, 0.00001);
        assertEquals(arrayTabulatedFunction3().floorIndexOfX(1.5), 4, 0.0001);
        assertEquals(arrayTabulatedFunction3().floorIndexOfX(-2.5), 0, 0.0001);
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
        assertEquals(arrayTabulatedFunction2().interpolate(16, 2), -50, 0.000001);
        assertEquals(arrayTabulatedFunction2().interpolate(20, 2), -62, 0.0001);
        assertEquals(arrayTabulatedFunction2().interpolate(20, 6), 94, 0.00001);
        assertEquals(arrayTabulatedFunction3().interpolate(15, 3), 60, 0.00001);
        assertEquals(arrayTabulatedFunction3().interpolate(-20, 5), -424, 0.00001);
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
}