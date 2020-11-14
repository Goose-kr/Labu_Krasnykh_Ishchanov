package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.Point;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    private TabulatedFunctionFactory factory;
        @Override
        public TabulatedFunction derive(TabulatedFunction function) {
            int count = function.getCount();
            Point[] points = TabulatedFunctionOperationService.asPoints(function);
            double[]xValues = new double[count-1];
            double[]yValues = new double[count-1];
            for(int i=0; i<count-1;i++){
                yValues[i] = (points[i + 1].y - points[i].y) / (points[i + 1].x - points[i].x);
                xValues[i] = points[i].x;
            }
            return factory.create(xValues,yValues);
        }

        @Override
        public double apply(double x) {
            return x;
        }
        public void setFactory(TabulatedFunctionFactory factory){
            this.factory=factory;
        }
        public Class getFactory(){
            return factory.getClass();
        }



    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedDifferentialOperator() {
        factory = new ArrayTabulatedFunctionFactory();
    }
}
