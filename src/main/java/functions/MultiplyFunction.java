package functions;

public class MultiplyFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return x * x;
    }
}
