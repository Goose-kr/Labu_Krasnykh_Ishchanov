package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public class AddingTask implements Runnable {
    private final TabulatedFunction function;

    public AddingTask(TabulatedFunction function) {
        this.function = function;
    }

    public void run() {
        double x;
        double y;
        int size = function.getCount();
        for (int i = 0; i < size; i++) {
            x = function.getX(i);
            synchronized (function) {
                y = function.getY(i);
                System.out.printf("%s, i = %d, x = %f, old y = %f", Thread.currentThread().getName(), i, x, y);
                function.setY(i, y + 3);
                y = function.getY(i);
            }
            System.out.printf("%s, i = %d, x = %f, new y = %f", Thread.currentThread().getName(), i, x, y);
            System.out.println();
        }
    }
}