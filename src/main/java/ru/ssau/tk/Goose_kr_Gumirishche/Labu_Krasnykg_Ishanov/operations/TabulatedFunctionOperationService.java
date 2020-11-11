package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.InconsistentFunctionsException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.exceptions.InterpolationException;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.Point;

public class TabulatedFunctionOperationService {
    private TabulatedFunctionFactory factory;

    TabulatedFunctionOperationService(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    TabulatedFunctionOperationService() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int i = 0;
        Point[] points = new Point[tabulatedFunction.getCount()];
        for (Point point : tabulatedFunction) {
            points[i] = point;
            i++;
        }
        return points;
    }

    public interface BiOperation {
        double apply(double u, double v);
    }

    public TabulatedFunction sum(TabulatedFunction a, TabulatedFunction b) {
        return doOperation(a, b, (u, v) -> u + v);
    }

    public TabulatedFunction subtract(TabulatedFunction a, TabulatedFunction b) {
        return doOperation(a, b, (u, v) -> u + v);
    }

    private TabulatedFunction doOperation(TabulatedFunction first, TabulatedFunction second, BiOperation operation) {
        if (first.getCount() != second.getCount()) {
            throw new InconsistentFunctionsException("Counts are various");
        }
        Point[] firstPoints = asPoints(first);
        Point[] secondPoints = asPoints(second);
        double[] xValues = new double[first.getCount()];
        double[] yValues = new double[first.getCount()];
        for (int i = 0; i < first.getCount(); i++) {
            if (firstPoints[i].x != secondPoints[i].x) {
                throw new InconsistentFunctionsException("Values of X are various");
            }
            xValues[i] = firstPoints[i].x;
            yValues[i] = operation.apply(firstPoints[i].y, secondPoints[i].y);
        }
        return factory. (xValues, yValues);
    }
}
