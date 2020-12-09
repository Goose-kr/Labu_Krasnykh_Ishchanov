package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public class ReadWriteTask implements Runnable {
    private final TabulatedFunction tabulatedFunction;

    public ReadWriteTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            double currentX = tabulatedFunction.getX(i);
            double currentY;
            synchronized (Thread.currentThread()) {
                currentY = tabulatedFunction.getY(i);
                System.out.println(Thread.currentThread().getName() + " before write: i = " + i + "x = " + currentX + "y = " + currentY);
                tabulatedFunction.setY(i, currentY + 1);
                currentY = tabulatedFunction.getY(i);
            }
            System.out.println(Thread.currentThread().getName() + "after write: i = " + i + "x = " + currentX + "y = " + currentY);

        }
    }
}