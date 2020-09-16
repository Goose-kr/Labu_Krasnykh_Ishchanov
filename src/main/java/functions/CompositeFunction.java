package functions;

public class CompositeFunction {
    private MathFunction firstFunction;
    private MathFunction secondFunction;

    void setFunctions(MathFunction firstFunction, MathFunction secondFunction) {
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }

}
