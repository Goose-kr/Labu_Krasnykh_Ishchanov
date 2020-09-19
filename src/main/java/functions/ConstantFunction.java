package functions;

public class ConstantFunction implements MathFunction {
    private final double constant1;
    public ConstantFunction  (double x1) {
         constant1=x1;
    }
    @Override
    public double apply (double x){
        return constant1*x;
    }
}
