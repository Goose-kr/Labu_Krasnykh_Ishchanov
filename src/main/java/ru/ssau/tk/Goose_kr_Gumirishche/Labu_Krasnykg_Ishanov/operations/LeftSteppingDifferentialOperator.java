package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.MathFunction;

public class LeftSteppingDifferentialOperator extends SteppingDifferentialOperator {
    LeftSteppingDifferentialOperator(double step) {
        super(step);
    }
    @Override
    public MathFunction derive(MathFunction function){
        return x -> {}
    }
}
