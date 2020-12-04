package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public class MultiplyingTask implements Runnable {
    private final TabulatedFunction function;

    public MultiplyingTask(TabulatedFunction function) {
        this.function = function;
    }

    public void run() {
        int size = function.getCount();
        double x,y;
        for (int i = 0; i < size; i++) {
            x = function.getX(i);
            synchronized (function){
            y = function.getY(i);
            System.out.printf("%s, i = %d, x = %f, old y = %f", "Old", i, x, y);
            function.setY(i, y * 10);
            y = function.getY(i);
            }
            System.out.printf("%s, i = %d, x = %f, new y = %f", "New", i, x, y);
            System.out.println();
        }
    }
}
