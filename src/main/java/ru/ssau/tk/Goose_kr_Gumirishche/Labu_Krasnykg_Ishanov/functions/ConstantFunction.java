package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

public class ConstantFunction implements MathFunction {
    private final double constant1;

    public ConstantFunction(double x1) {
        constant1 = x1;
    }

    @Override
    public double apply(double x) {
        return constant1;
    }
}
