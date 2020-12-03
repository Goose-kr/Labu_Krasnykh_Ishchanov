package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.concurrent;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ZeroFunction;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        TabulatedFunction tabulatedFunction = new LinkedListTabulatedFunction(new ZeroFunction(), 1, 10, 10);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            Thread newTread = new Thread(new ReadWriteTask(tabulatedFunction));
            threadList.add(newTread);
        }
        for (Thread currentTread : threadList) {
            currentTread.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tabulatedFunction);
    }
}
