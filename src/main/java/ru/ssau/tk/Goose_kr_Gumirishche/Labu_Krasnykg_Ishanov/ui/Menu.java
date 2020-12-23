package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
    JMenu menu=new JMenu("Что я уменю");
    JMenuBar menuBar=new JMenuBar();

    public Menu(){
        super("Подручный");
        menu.add(createMathFunction());
        menu.add(createTabulatedFunction());
        menuBar.add(menu);
        setJMenuBar(menuBar);
        setSize(400,400);
    }

    private JMenu createTabulatedFunction() {
        JMenu tabulatedFunction = new JMenu("Функция через точки");
        tabulatedFunction.add(new JMenuItem("Ввести количество точек"));
        return tabulatedFunction;
    }

    private JMenu createMathFunction() {
        JMenu mathFunction = new JMenu("Выбор функции");
        mathFunction.add(new JMenuItem("Квадратичная функция"));
        mathFunction.add(new JMenuItem("Функция арксинуса"));
        mathFunction.add(new JMenuItem("Функция корня"));
        mathFunction.add(new JMenuItem("Тождественная функция"));
        return mathFunction;
    }

    public static void main(String[] args) {
        JFrame menu=new Menu();
        menu.setVisible(true);
    }
}