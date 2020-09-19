package functions;

public class ZeroFunction extends ConstantFunction {
    public ZeroFunction(){
        this(0);
    }
    public ZeroFunction(double x1){
        super(x1);
    }
    public double apply(double x){
        return 0;
    }
}
