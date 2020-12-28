package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private int size;
    protected static TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
    private final JMenu menuSettings = new JMenu("Настройки");
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menuTab = new JMenu("Табулированная функция");
    private final JMenu menuMath = new JMenu("Математичекские функции");

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
        menuTab.add(createTabulatedFunction());
        menuMath.add(createMathFunction());
        menuBar.add(menuTab);
        menuBar.add(menuMath);
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
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator calculator = new Calculator(factory);
                calculator.setVisible(true);
            }
        });
        diff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DifferentialOperator differentialOperator = new DifferentialOperator();
                differentialOperator.setVisible(true);
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

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public static void main(String[] args) {
        JFrame menu = new Menu();
        menu.setVisible(true);
    }
}