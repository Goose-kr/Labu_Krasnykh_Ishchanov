package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ConstantFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.MathFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);

    TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count);
    /*default TabulatedFunction createStrict(double[] xValues, double[] yValues) {
        return new StrictTabulatedFunction(create(xValues, yValues));
    }

    default TabulatedFunction createUnmodifiable(double[] xValues, double[] yValues) {
        return new UnmodifiableTabulatedFunction(create(xValues, yValues));
    }

    default TabulatedFunction createStrictUnmodifiable(double[] xValues, double[] yValues) {
        return new StrictTabulatedFunction(new UnmodifiableTabulatedFunction(create(xValues, yValues)));
    }*/

}
