package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction {
    protected double[] xValues;
    protected double[] yValues;
    protected int count;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        count = xValues.length;
        this.xValues = Arrays.copyOf(xValues, count);
        this.yValues = Arrays.copyOf(yValues, count);
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        this.count = count;
        xValues = new double[count];
        yValues = new double[count];
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                xValues[i] = xFrom;
                yValues[i] = source.apply(xFrom);
            } else if (i == count - 1) {
                xValues[i] = xTo;
                yValues[i] = source.apply(xTo);
            } else {
                xFrom = xFrom + step;
                xValues[i] = xFrom;
                yValues[i] = source.apply(xFrom);
            }
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        return xValues[index];
    }

    @Override
    public double getY(int index) {
        return yValues[index];
    }

    @Override
    public void setY(int index, double value) {
        yValues[index] = value;
    }

    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (x == xValues[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (y == yValues[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return xValues[0];
    }

    @Override
    public double rightBound() {
        return xValues[count - 1];
    }

    @Override
    protected int floorIndexOfX(double x) {
        int i = 0;
        if (x < xValues[0]) {
            return 0;
        }
        for (i = 0; i + 1 < count; i++) {
            if (x < xValues[i + 1]) {
                return i;
            }
        }
        return i;
    }

    @Override
    protected double extrapolateLeft(double x) {
        if (count == 1) {
            return x;
        }
        return interpolate(x, xValues[0], xValues[1], yValues[0], yValues[1]);
    }

    protected double extrapolateRight(double x) {
        if (count == 1) {
            return x;
        }
        return interpolate(x, xValues[count - 2], xValues[count - 1], yValues[count - 2], yValues[count - 1]);
    }

    protected double interpolate(double x, int floorIndex) {
        return yValues[floorIndex] + ((yValues[floorIndex+1] - yValues[floorIndex]) / (xValues[floorIndex+1] - xValues[floorIndex])) * (x - xValues[floorIndex]);
    }

}
