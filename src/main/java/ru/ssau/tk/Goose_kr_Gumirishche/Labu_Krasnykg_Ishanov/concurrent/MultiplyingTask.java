package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public class MultiplyingTask implements Runnable {
    private final TabulatedFunction function;

    public MultiplyingTask(TabulatedFunction function) {
        this.function = function;
    }

    public void run() {
        int size = function.getCount();
        for (int i = 0; i < size; i++) {
            double x = function.getX(i);
            double y = function.getY(i);
            System.out.printf("%s, i = %d, x = %f, old y = %f", "Old", i, x, y);
            function.setY(i, y * 10);
            y = function.getY(i);
            System.out.printf("%s, i = %d, x = %f, new y = %f", "New", i, x, y);
        }
    }
}
