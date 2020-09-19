package functions;

public class UnitFunction extends ConstantFunction {
    public UnitFunction() {
        this(0);
    }

    public UnitFunction(double x1) {
        super(1);
    }

    public double apply(double x) {
        return 1;
    }
}
