package functions;

import java.lang.Math;

public class CompositeFunction {
    private MathFunction firstFunction;
    private MathFunction secondFunction;

    public void Functions(MathFunction firstFunction, MathFunction secondFunction) {
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }

    double apply(double x) {
        return secondFunction.apply(firstFunction.apply(x));
    }
}
