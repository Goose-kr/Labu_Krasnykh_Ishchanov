package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.MathFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new LinkedListTabulatedFunction(source, xFrom, xTo, count);
    }
}
