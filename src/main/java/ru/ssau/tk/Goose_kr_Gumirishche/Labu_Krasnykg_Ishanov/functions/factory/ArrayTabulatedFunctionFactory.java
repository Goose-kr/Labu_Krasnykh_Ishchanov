package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.MathFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;


public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {

    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new ArrayTabulatedFunction(source, xFrom, xTo, count);
    }

}
