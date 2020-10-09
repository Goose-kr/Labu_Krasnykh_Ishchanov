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
    protected double extrapolateleft(double x){
        return interpolate(x,x0,x1,y0,y1);
    }
    protected double extrapolateright(double x){
        return interpolate(x,x0,x1,y0,y1);
    }
    protected double interpolate(double x, int floorIndex){
        return interpolate(x,x0,x1,y0,y1);
    }
    public int getCount(){
        return 2;
    }
}
