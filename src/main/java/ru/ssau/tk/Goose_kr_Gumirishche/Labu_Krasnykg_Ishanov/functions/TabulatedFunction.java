package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;

public interface TabulatedFunction extends MathFunction {
    int GetCount();

    double GetX(int index);

    double GetY(int index);

    void SetY(int index, double value);

    int indexOfX(double x);

    int indexOfY(double y);

    double LeftBound();

    double rightBound();
}
