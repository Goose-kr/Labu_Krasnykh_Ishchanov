package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ConstantFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public class AddingMultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        final TabulatedFunction function = new LinkedListTabulatedFunction(new ConstantFunction(2), 1, 100, 100);
        Thread multiplyingTask1 = new Thread(new MultiplyingTask(function));
        Thread multiplyingTask2 = new Thread(new MultiplyingTask(function));
        Thread addingTask = new Thread(new AddingTask(function));
        multiplyingTask1.start();
        multiplyingTask2.start();
        addingTask.start();
        Thread.sleep(2000);
        System.out.println(function);
    }
}
