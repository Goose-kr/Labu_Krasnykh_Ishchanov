package functions;

public class SumFunction implements MathFunction{
    @Override
    public double apply(double x) {
        return x + x;
    }
}
