package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private int size;
    private static final int ARRAY_FUNCTION=0;
    private static final int LINKED_LIST_FUNCTION=1;
    JMenu menuSettings = new JMenu("Настройки");
    JMenuBar menuBar = new JMenuBar();
    JMenu menuTab = new JMenu("Табулированная функция");
    JMenu menuMath = new JMenu("Математичекские функции");

    public Menu() {
        super("Подручный");
        menuTab.add(createTabulatedFunction());
        menuMath.add(createMathFunction());
        menuBar.add(menuTab);
        menuBar.add(menuMath);
        setJMenuBar(menuBar);
        setSize(400, 400);
    }

    private JMenu settings() {
        JMenu menuSet = new JMenu("Выбор фабрики");
        JMenuItem itemMassif = new JMenuItem("Массив");
        JMenuItem itemList = new JMenuItem("Список");
        menuSet.add(itemMassif);
        menuSet.add(itemList);
        itemMassif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowSize sizeWindow=new WindowSize();
                sizeWindow.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                sizeWindow.setVisible(true);
                size=sizeWindow.getSizeOfFunction();
                dispose();
            }
        });
        return menuSet;
    }

    private JMenu createTabulatedFunction() {
        JMenu menuSet = new JMenu("Выбор фабрики");
        JMenuItem itemMassif = new JMenuItem("Массив");
        JMenuItem itemList = new JMenuItem("Список");
        menuSet.add(itemMassif);
        menuSet.add(itemList);
        itemMassif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowOfTabulated tabulatedFunction = new WindowOfTabulated(ARRAY_FUNCTION);
                tabulatedFunction.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                tabulatedFunction.setVisible(true);
            }
        });
        itemList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowOfTabulated tabulatedFunction = new WindowOfTabulated(LINKED_LIST_FUNCTION);
                tabulatedFunction.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                tabulatedFunction.setVisible(true);
            }
        });
        menuSet.add(itemMassif);
        menuSet.add(itemList);
        return menuSet;
    }

    private JMenu createMathFunction() {
        JMenu menuMath = new JMenu("Математичекские функции");

        return menuMath;
    }

    public int getSizeOfFunction(){
        return size;
    }

    public void setSize(int size){
        this.size=size;
    }

    public static void main(String[] args) {
        JFrame menu = new Menu();
        menu.setVisible(true);
    }
}

class WindowSize extends JDialog {
    private Integer size;
    public WindowSize() {
        super();
        this.setBounds(200, 200, 400, 100);
        setLocationRelativeTo(null);
        Container container = this.getContentPane();
        JLabel label = new JLabel("Число точек:");
        container.add(label);
        JTextField input = new JTextField();
        container.add(input);
        JButton button = new JButton("enter");
        container.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = Integer.valueOf(input.getText());
                dispose();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(label).addComponent(input)).addComponent(button));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(label).addComponent(input)).addComponent(button));

    }
    public int getSizeOfFunction(){
        return size;
    }
}