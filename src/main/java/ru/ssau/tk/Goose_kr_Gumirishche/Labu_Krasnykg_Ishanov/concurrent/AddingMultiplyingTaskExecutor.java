package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ConstantFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

public class AddingMultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction function = new LinkedListTabulatedFunction(new ConstantFunction(2), 1, 100, 99);
        MultiplyingTask multiplyingTask1 = new MultiplyingTask(function);
        MultiplyingTask multiplyingTask2 = new MultiplyingTask(function);
        AddingTask addingTask = new AddingTask(function);
        new Thread(multiplyingTask1).start();
        Thread.sleep(20);
        new Thread(multiplyingTask2).start();
        Thread.sleep(20);
        new Thread(addingTask).start();
        System.out.println(function);
    }
}
