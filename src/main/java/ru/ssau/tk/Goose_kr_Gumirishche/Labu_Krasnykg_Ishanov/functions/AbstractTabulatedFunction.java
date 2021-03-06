package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.DifferentLengthOfArraysException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedFunctionOperationService;

public abstract class AbstractTabulatedFunction extends Object implements TabulatedFunction {

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + ((rightY - leftY) / (rightX - leftX)) * (x - leftX);
    }

    protected static void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new DifferentLengthOfArraysException("lengths of arrays are different");
        }
    }

    protected static void checkSorted(double[] xValues) {
        for (int i = 0; i < xValues.length - 1; i++) {
            if (xValues[i] > xValues[i + 1]) {
                throw new ArrayIsNotSortedException("xValues array isn't sorted");
            }
        }
    }

    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else if (indexOfX(x) != -1) {
            return getY(indexOfX(x));
        } else {
            return interpolate(x, floorIndexOfX(x));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName());
        stringBuilder.append("; size = ");
        stringBuilder.append(getCount());
        for (Point currentPoint : TabulatedFunctionOperationService.asPoints(this)) {
            stringBuilder.append("\n");
            stringBuilder.append('[');
            stringBuilder.append(currentPoint.x);
            stringBuilder.append(',');
            stringBuilder.append(' ');
            stringBuilder.append(currentPoint.y);
            stringBuilder.append(']');

        }
        return (stringBuilder.toString());

    }

}
