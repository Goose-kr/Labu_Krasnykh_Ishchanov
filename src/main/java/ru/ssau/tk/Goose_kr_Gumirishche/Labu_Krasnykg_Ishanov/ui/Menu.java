package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    protected static TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();

    public Menu() {
        super("Подручный");
        Image image = new ImageIcon("ФонДляПрограмки.png").getImage();
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenu menuTab = new JMenu("Табулированная функция");
        menuTab.add(createTabulatedFunction());
        JMenu menuMath = new JMenu("Математичекские функции");
        menuMath.add(createMathFunction());
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuTab);
        menuBar.add(menuMath);
        JMenu menuSettings = new JMenu("Настройки");
        menuBar.add(menuSettings);
        menuSettings.add(settings());
        setJMenuBar(menuBar);
        JButton diff = new JButton("Дифференцировать");
        add(diff);
        setSize(425, 380);
        setLocationRelativeTo(null);
        JButton calculate = new JButton("Калькулятор");
        add(calculate);
        setLayout(new FlowLayout());
        calculate.addActionListener(e -> {
            Calculator calculator = new Calculator(factory);
            calculator.setVisible(true);
        });
        diff.addActionListener(e -> {
            DifferentialOperator differentialOperator = new DifferentialOperator();
            differentialOperator.setVisible(true);
        });
    }

    private JMenu settings() {
        JMenu set = new JMenu("Настройки");
        JMenuItem item = new JMenuItem("Открыть");
        set.add(item);
        item.addActionListener(e -> {
            Settings settings = new Settings();
            settings.setVisible(true);
            factory = settings.getFactory();
        });
        return set;
    }

    private JMenu createTabulatedFunction() {
        JMenu tab = new JMenu("Табулированная функция");
        JMenuItem itemCreate = new JMenuItem("Создать");
        tab.add(itemCreate);
        itemCreate.addActionListener(e -> {
            WindowOfTabulated tabulatedFunction = new WindowOfTabulated(factory);
            tabulatedFunction.setVisible(true);
        });

        return tab;
    }

    private JMenu createMathFunction() {
        JMenu menuMath = new JMenu("Математичекские функции");
        JMenuItem math = new JMenuItem("Открыть");
        menuMath.add(math);
        math.addActionListener(e -> {
            MathFunctionWindow math1 = new MathFunctionWindow(factory);
            math1.setVisible(true);
        });

        return menuMath;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public static void main(String[] args) {
        JFrame menu = new Menu();
        menu.setVisible(true);
    }
}