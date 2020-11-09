package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.DifferentLengthOfArraysException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.InterpolationException;

import java.util.Iterator;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {
    AbstractTabulatedFunction link1;
    AbstractTabulatedFunction link2;
    AbstractTabulatedFunction link3;
    AbstractTabulatedFunction link4;

    public AbstractTabulatedFunction linkedListTabulatedFunction1() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return link1 = new LinkedListTabulatedFunction(xValues1, yValues1);
    }

    public AbstractTabulatedFunction linkedListTabulatedFunction2() {
        final double[] xValues2 = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};
        final double[] yValues2 = new double[]{16, 9, 4, 1, 0, 1, 4, 9, 16};
        new LinkedListTabulatedFunction(xValues2, yValues2);
        return link2 = new LinkedListTabulatedFunction(xValues2, yValues2);
    }

    public AbstractTabulatedFunction linkedListTabulatedFunction3() {
        final CompositeFunction compositeFunction = new CompositeFunction(new SumFunction(), new SqrFunction());
        new LinkedListTabulatedFunction(compositeFunction, -3, 3, 7);
        return link3 = new LinkedListTabulatedFunction(compositeFunction, -3, 3, 7);
    }

    public LinkedListTabulatedFunction getListOfArray() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return new LinkedListTabulatedFunction(xValues1, yValues1);
    }

    public LinkedListTabulatedFunction listOfArray1() {
        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        return new LinkedListTabulatedFunction(xValues1, yValues1);
    }

    @Test
    public void testCount() {
        assertEquals(linkedListTabulatedFunction1().getCount(), 5, 0.00001);
        assertEquals(linkedListTabulatedFunction2().getCount(), 9, 0.00001);
        assertEquals(linkedListTabulatedFunction3().getCount(), 7, 0.0001);
    }

    @Test
    public void testGetX() {
        assertEquals(linkedListTabulatedFunction1().getX(0), -2, 0.000001);
        assertEquals(linkedListTabulatedFunction1().getX(4), 2, 0.0001);
        assertEquals(linkedListTabulatedFunction2().getX(4), 0, 0.000001);
        assertEquals(linkedListTabulatedFunction3().getX(3), 0, 0.00001);

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IndexOutOfBoundsException.class, () -> {
                    new LinkedListTabulatedFunction(xValues1, yValues1).getX(200);
                });
            assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getX(5);
            });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getX(-2);
        });
    }

    @Test
    public void testGetY() {
        assertEquals(linkedListTabulatedFunction1().getY(0), 4, 0.000001);
        assertEquals(linkedListTabulatedFunction1().getY(4), 4, 0.0001);
        assertEquals(linkedListTabulatedFunction2().getY(4), 0, 0.000001);
        assertEquals(linkedListTabulatedFunction3().getY(4), 4, 0.000001);

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getY(200);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getY(-4);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getY(5);
        });
    }

    @Test
    public void testSetY() {
        linkedListTabulatedFunction1().setY(0, 16);
        linkedListTabulatedFunction2().setY(4, -20);
        linkedListTabulatedFunction3().setY(3, 16);
        assertEquals(link1.getY(0), 16, 0.000001);
        assertEquals(link2.getY(4), -20, 0.000001);
        assertEquals(link3.getY(3), 16, 0.00001);

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).setY(200, 1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).setY(-4, 4);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).setY(5, 1);
        });
    }

    @Test
    public void testIndexOfX() {
        assertEquals(linkedListTabulatedFunction1().indexOfX(-1), 1, 0.00001);
        assertEquals(linkedListTabulatedFunction1().indexOfX(10), -1, 0.00001);
        assertEquals(linkedListTabulatedFunction2().indexOfX(3), 7, 0.00001);
        assertEquals(linkedListTabulatedFunction3().indexOfX(-1), 2, 0.00001);
        assertEquals(linkedListTabulatedFunction3().indexOfX(-5), -1, 0.000001);

    }

    @Test
    public void testIndexOfY() {
        assertEquals(linkedListTabulatedFunction2().indexOfY(16), 0, 0.00001);
        assertEquals(linkedListTabulatedFunction2().indexOfY(436436), -1, 0.00001);
        assertEquals(linkedListTabulatedFunction1().indexOfY(4), 0, 0.0001);
        assertEquals(linkedListTabulatedFunction3().indexOfY(36), 0, 0.0001);
        assertEquals(linkedListTabulatedFunction3().indexOfY(100), -1, 0.0001);
    }

    @Test
    public void testLeftBound() {
        assertEquals(linkedListTabulatedFunction1().leftBound(), -2, 0.00001);
        assertEquals(linkedListTabulatedFunction2().leftBound(), -4, 0.00001);
        assertEquals(linkedListTabulatedFunction3().leftBound(), -3, 0.00001);
    }

    @Test
    public void testRightBound() {
        assertEquals(linkedListTabulatedFunction1().rightBound(), 2, 0.00001);
        assertEquals(linkedListTabulatedFunction2().rightBound(), 4, 0.00001);
        assertEquals(linkedListTabulatedFunction3().rightBound(), 3, 0.00001);
    }

    @Test
    public void testFloorIndexOfX() {
        assertEquals(linkedListTabulatedFunction2().floorIndexOfX(-3.5), 0, 0.00001);
        assertEquals(linkedListTabulatedFunction2().floorIndexOfX(-0.1421), 3, 0.00001);
        assertEquals(linkedListTabulatedFunction1().floorIndexOfX(-1.5), 0, 0.00001);
        assertEquals(linkedListTabulatedFunction3().floorIndexOfX(1.5), 4, 0.0001);
        assertEquals(linkedListTabulatedFunction3().floorIndexOfX(-2.5), 0, 0.0001);

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IllegalArgumentException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).floorIndexOfX(-3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).floorIndexOfX(-4);
        });
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(linkedListTabulatedFunction2().extrapolateLeft(5), -47, 0.00001);
        assertEquals(linkedListTabulatedFunction2().extrapolateLeft(17), -131, 0.000001);
        assertEquals(linkedListTabulatedFunction2().extrapolateLeft(-16), 100, 0.00001);
        assertEquals(linkedListTabulatedFunction3().extrapolateLeft(15), -324, 0.00001);
        assertEquals(linkedListTabulatedFunction3().extrapolateLeft(20), -424, 0.00001);
        assertEquals(linkedListTabulatedFunction3().extrapolateLeft(-16), 296, 0.0001);

    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(linkedListTabulatedFunction2().extrapolateRight(5), 23, 0.00001);
        assertEquals(linkedListTabulatedFunction2().extrapolateRight(15), 93, 0.000001);
        assertEquals(linkedListTabulatedFunction2().extrapolateRight(-20), -152, 0.00001);
        assertEquals(linkedListTabulatedFunction3().extrapolateRight(15), 276, 0.0001);
        assertEquals(linkedListTabulatedFunction3().extrapolateRight(-1325), -26524, 0.00001);
    }

    @Test
    public void testInterpolate() {
        assertEquals(linkedListTabulatedFunction2().interpolate(-1.5, 2), 2.5, 0.000001);
        assertEquals(linkedListTabulatedFunction2().interpolate(-2.5, 1), 6.5, 0.0001);
        assertEquals(linkedListTabulatedFunction2().interpolate(2.5, 6), 6.5, 0.00001);
    }

    @Test
    public void testApply() {
        assertEquals(linkedListTabulatedFunction1().apply(16), 46, 0.00001);
        assertEquals(linkedListTabulatedFunction1().apply(-16), 46, 0.000001);
        assertEquals(linkedListTabulatedFunction1().apply(-2), 4, 0.0001);
        assertEquals(linkedListTabulatedFunction1().apply(0.5), 0.5, 0.000001);
        assertEquals(linkedListTabulatedFunction3().apply(-4), 56, 0.00001);
        assertEquals(linkedListTabulatedFunction3().apply(5), 76, 0.00001);
        assertEquals(linkedListTabulatedFunction3().apply(-2), 16, 0.00001);
        assertEquals(linkedListTabulatedFunction3().apply(-1.5), 10, 0.00001);
    }

    @Test
    public void testInterpolationException() {
        assertThrows(InterpolationException.class, () -> {
            linkedListTabulatedFunction1().interpolate(-2, 1);
        });
        assertThrows(InterpolationException.class, () -> {
            linkedListTabulatedFunction2().interpolate(-1, 5);
        });
        assertThrows(InterpolationException.class, () -> {
            linkedListTabulatedFunction2().interpolate(-2, 3);
        });
    }

    @Test
    public void testCheckLengthIsTheSame() {
        double[] xValues = new double[]{1, 2, 3, 4, 5};
        double[] yValues = new double[]{1, 4, 9, 16, 25};
        LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(linkedListTabulatedFunction.getX(0), 1, 0.001);

        assertThrows(DifferentLengthOfArraysException.class, () -> {
            new LinkedListTabulatedFunction(new double[]{1, 2, 3, 4, 5}, new double[]{1, 2, 3, 4});
        });
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            new LinkedListTabulatedFunction(new double[]{1, 2, 3, 4}, new double[]{1, 2, 3, 4, 5});
        });
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            new LinkedListTabulatedFunction(new double[]{1}, new double[]{});
        });
    }

    @Test
    public void testCheckSorted() {
        double[] xValues = new double[]{1, 2, 3, 4, 5};
        double[] yValues = new double[]{1, 4, 9, 16, 25};
        LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(linkedListTabulatedFunction.getX(0), 1, 0.001);

        assertThrows(ArrayIsNotSortedException.class, () -> {
            new LinkedListTabulatedFunction(new double[]{5, 2, 3, 4, 5}, new double[]{1, 2, 3, 4, 5});
        });
        assertThrows(ArrayIsNotSortedException.class, () -> {
            new LinkedListTabulatedFunction(new double[]{1, 5, 3, 4}, new double[]{1, 2, 3, 4});
        });
        assertThrows(ArrayIsNotSortedException.class, () -> {
            new LinkedListTabulatedFunction(new double[]{3, 2}, new double[]{1, 2});
        });
    }

    @Test
    public void testGetNode() {
        LinkedListTabulatedFunction listOfArray = getListOfArray();

        final double[] xValues1 = new double[]{-2, -1, 0, 1, 2};
        final double[] yValues1 = new double[]{4, 1, 0, 1, 4};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getNode(200);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getNode(-4);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new LinkedListTabulatedFunction(xValues1, yValues1).getNode(5);
        });
    }

    @Test
    public void testIterator1() {
        LinkedListTabulatedFunction listOfArray1 = getListOfArray();
        Iterator<Point> iterator = listOfArray1.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(listOfArray1().getX(i++), point.x, 0.00001);
        }
        assertEquals(i,listOfArray1.getCount());

    }

    @Test
    public void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LinkedListTabulatedFunction(new double[]{1}, new double[]{2});
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LinkedListTabulatedFunction(new SqrFunction(), 1, 1, 1);
        });
    }

    @Test
    public void testIterator2() {
        LinkedListTabulatedFunction listOfArray1 = getListOfArray();
        Iterator<Point> iterator = listOfArray1.iterator();
        int i = 0;
        for (Point point : listOfArray1) {
            assertEquals(listOfArray1.getX(i++), point.x, 0.00001);
        }
        assertEquals(i,listOfArray1.getCount());
    }
}

