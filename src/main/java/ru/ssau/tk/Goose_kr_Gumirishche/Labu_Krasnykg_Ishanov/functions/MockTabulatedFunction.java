package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

public class MockTabulatedFunction extends AbstractTabulatedFunction {
    final double x0 = 2.0;
    final double x1 = 50.0;
    final double y0 = 1.0;
    final double y1 = 20.0;

    protected int floorIndexOfX(double x) {
        if (x < x0) {
            return 0;
        }
        else if (x >= x0 && x <= x1) {
            return 1;
        }
        else {
            return 2;
        }
    }
    protected double extrapolateLeft(double x){
        return interpolate(x,x0,x1,y0,y1);
    }
    protected double extrapolateRight(double x){
        return interpolate(x,x0,x1,y0,y1);
    }
    protected double interpolate(double x, int floorIndex){
        return interpolate(x,x0,x1,y0,y1);
    }
    public double apply(double x){
        return super.apply(x);

    }
    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY){
        return super.interpolate(x,leftX,rightX,leftY,rightY);
    }
    public int getCount(){
        return 2;
    }
    double getX(int index);

    double getY(int index);

    void setY(int index, double value);

    int indexOfX(double x);

    int indexOfY(double y);

    double leftBound();

    double rightBound();
}
