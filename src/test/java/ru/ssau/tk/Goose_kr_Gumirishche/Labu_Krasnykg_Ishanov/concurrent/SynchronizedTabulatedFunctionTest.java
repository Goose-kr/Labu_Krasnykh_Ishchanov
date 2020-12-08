package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class SynchronizedTabulatedFunctionTest {

    public SynchronizedTabulatedFunction synchronizedTabulatedFunction1() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return new SynchronizedTabulatedFunction(new ArrayTabulatedFunction(xValues1, yValues1));
    }

    public SynchronizedTabulatedFunction synchronizedTabulatedFunction2() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        return new SynchronizedTabulatedFunction(new ArrayTabulatedFunction(xValues2, yValues2));
    }

    public SynchronizedTabulatedFunction synchronizedTabulatedFunction3() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return new SynchronizedTabulatedFunction(new ArrayTabulatedFunction(xValues1, yValues1));
    }

    @Test
    public void testCount() {
        assertEquals(synchronizedTabulatedFunction1().getCount(), 5, 0.00001);
        assertEquals(synchronizedTabulatedFunction2().getCount(), 9, 0.00001);
    }

    @Test
    public void testDoSynchronously() {
        assertEquals((int) synchronizedTabulatedFunction1().doSynchronously(synchronizedTabulatedFunction -> synchronizedTabulatedFunction1().getCount()), 5);
        assertEquals((double) synchronizedTabulatedFunction1().doSynchronously(synchronizedTabulatedFunction -> synchronizedTabulatedFunction1().getX(2)), 0, 0.00001);
        assertEquals((double) synchronizedTabulatedFunction1().doSynchronously(synchronizedTabulatedFunction -> synchronizedTabulatedFunction1().getY(3)), 1, 0.0001);
        assertEquals((int) synchronizedTabulatedFunction1().doSynchronously(synchronizedTabulatedFunction -> synchronizedTabulatedFunction1().indexOfX(2)), 4);
    }

    @Test
    public void testGetX() {
        assertEquals(synchronizedTabulatedFunction1().getX(0), -2, 0.000001);
        assertEquals(synchronizedTabulatedFunction1().getX(4), 2, 0.0001);
        assertEquals(synchronizedTabulatedFunction2().getX(4), 0, 0.000001);
    }

    @Test
    public void testGetY() {
        assertEquals(synchronizedTabulatedFunction1().getY(0), 4, 0.000001);
        assertEquals(synchronizedTabulatedFunction1().getY(4), 4, 0.0001);
        assertEquals(synchronizedTabulatedFunction2().getY(4), 0, 0.000001);
    }

    @Test
    public void testSetY() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        SynchronizedTabulatedFunction synchronizedTabulatedFunction1 = new SynchronizedTabulatedFunction(new ArrayTabulatedFunction(xValues1, yValues1));
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        SynchronizedTabulatedFunction synchronizedTabulatedFunction2 = new SynchronizedTabulatedFunction(new ArrayTabulatedFunction(xValues2, yValues2));
        synchronizedTabulatedFunction1.setY(0, 16);
        synchronizedTabulatedFunction2.setY(4, -20);
        assertEquals(synchronizedTabulatedFunction1.getY(0), 16, 0.000001);
        assertEquals(synchronizedTabulatedFunction2.getY(4), -20, 0.000001);
    }

    @Test
    public void testIndexOfX() {
        assertEquals(synchronizedTabulatedFunction1().indexOfX(-1), 1, 0.00001);
        assertEquals(synchronizedTabulatedFunction1().indexOfX(10), -1, 0.00001);
        assertEquals(synchronizedTabulatedFunction2().indexOfX(3), 7, 0.00001);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(synchronizedTabulatedFunction2().indexOfY(16), 0, 0.00001);
        assertEquals(synchronizedTabulatedFunction2().indexOfY(436436), -1, 0.00001);
        assertEquals(synchronizedTabulatedFunction1().indexOfY(4), 0, 0.0001);
    }

    @Test
    public void testLeftBound() {
        assertEquals(synchronizedTabulatedFunction1().leftBound(), -2, 0.00001);
        assertEquals(synchronizedTabulatedFunction2().leftBound(), -4, 0.00001);
    }

    @Test
    public void testRightBound() {
        assertEquals(synchronizedTabulatedFunction1().rightBound(), 2, 0.00001);
        assertEquals(synchronizedTabulatedFunction2().rightBound(), 4, 0.00001);
    }

    @Test
    public void testIterator() {
        Iterator<Point> iterator = synchronizedTabulatedFunction3().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(point.x, synchronizedTabulatedFunction3().getX(i++));
        }
        assertEquals(i, synchronizedTabulatedFunction3().getCount());
        assertThrows(NoSuchElementException.class, () -> {
            Point point = iterator.next();
        });
        i = 0;
        for (Point point : synchronizedTabulatedFunction3()) {
            assertEquals(point.x, synchronizedTabulatedFunction3().getX(i++));
        }
        assertEquals(i, synchronizedTabulatedFunction3().getCount());
    }

    @Test
    public void testApply() {
        assertEquals(synchronizedTabulatedFunction1().apply(16), 46, 0.00001);
        assertEquals(synchronizedTabulatedFunction1().apply(-16), 46, 0.000001);
        assertEquals(synchronizedTabulatedFunction1().apply(-2), 4, 0.0001);
        assertEquals(synchronizedTabulatedFunction1().apply(0.5), 0.5, 0.000001);
    }
}