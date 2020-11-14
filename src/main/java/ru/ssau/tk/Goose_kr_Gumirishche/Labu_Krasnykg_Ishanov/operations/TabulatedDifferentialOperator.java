package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    private TabulatedFunctionFactory factory;
        @Override
        public TabulatedFunction derive(TabulatedFunction function) {
            return function;
        }

        @Override
        public double apply(double x) {
            return 0;
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
