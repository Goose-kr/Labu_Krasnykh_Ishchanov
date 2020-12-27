package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Menu extends JFrame {
    private int size;
    private TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
    JMenu menuSettings = new JMenu("Настройки");
    JMenuBar menuBar = new JMenuBar();
    JMenu menuTab = new JMenu("Табулированная функция");
    JMenu menuMath = new JMenu("Математичекские функции");

    public Menu() {
        super("Подручный");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuTab.add(createTabulatedFunction());
        menuMath.add(createMathFunction());
        menuBar.add(menuTab);
        menuBar.add(menuMath);
        menuBar.add(menuSettings);
        menuSettings.add(settings());
        setJMenuBar(menuBar);
        setSize(425, 100);
        setLocationRelativeTo(null);
        JButton calculate = new JButton("Калькулятор");
        add(calculate);
        setLayout(new FlowLayout());
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator calculator = new Calculator();
                calculator.setVisible(true);
            }
        });
    }

    private JMenu settings() {
        JMenu set = new JMenu("Настройки");
        JMenuItem item = new JMenuItem("Открыть");
        set.add(item);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings settings = new Settings();
                settings.setVisible(true);
                factory = settings.getFactory();
            }
        });
        return set;
    }

    private JMenu createTabulatedFunction() {
        JMenu tab = new JMenu("Табулированная функция");
        JMenuItem itemCreate = new JMenuItem("Создать");
        tab.add(itemCreate);
        itemCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowOfTabulated tabulatedFunction = new WindowOfTabulated(factory);
                tabulatedFunction.setVisible(true);
            }
        });

        return tab;
    }

    private JMenu createMathFunction() {
        JMenu menuMath = new JMenu("Математичекские функции");
        JMenuItem math = new JMenuItem("Открыть");
        menuMath.add(math);
        math.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MathFunctionWindow math = new MathFunctionWindow(factory);
                math.setVisible(true);
            }
        });

        return menuMath;
    }

    public int getSizeOfFunction() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        JFrame menu = new Menu();
        menu.setVisible(true);
    }
}