package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JDialog {
    private ArrayList<String> stringsX1;
    private ArrayList<String> stringsY1;
    private ArrayList<String> stringsX2;
    private ArrayList<String> stringsY2;
    private ArrayList<String> stringsX3;
    private ArrayList<String> stringsY3;
    private AbstractTableModel tableModelX1;
    private AbstractTableModel tableModelY1;
    private AbstractTableModel tableModelX2;
    private AbstractTableModel tableModelY2;
    private AbstractTableModel tableModelX3;
    private AbstractTableModel tableModelY3;
    private JTable tableX1;
    private JTable tableY1;
    private JTable tableX2;
    private JTable tableY2;
    private JTable tableX3;
    private JTable tableY3;
    private TabulatedFunction function1;
    private TabulatedFunction function2;
    private TabulatedFunction function3;
    private TabulatedFunctionFactory factory;

    public Calculator(TabulatedFunctionFactory factory,int size) {
        JDialog dialog = new JDialog();
        setModal(true);
        this.factory = factory;
        stringsX1 = new ArrayList<>(size);
        stringsY1 = new ArrayList<>(size);
        stringsY2 = new ArrayList<>(size);
        stringsX2 = new ArrayList<>(size);
        stringsY3 = new ArrayList<>(size);
        stringsX3 = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            stringsX1.add("");
            stringsY1.add("");
            stringsX2.add("");
            stringsY2.add("");
            stringsX3.add("");
            stringsY3.add("");
        }
        tableModelX1 = new TableModelX(stringsX1);
        tableModelY1 = new TableModelY(stringsY1);
        tableModelX2 = new TableModelX(stringsX2);
        tableModelY2 = new TableModelY(stringsY2);
        tableModelX3 = new TableCalculateX(stringsX3);
        tableModelY3 = new TableCalculateY(stringsY3);
        tableX1 = new JTable(tableModelX1);
        tableY1 = new JTable(tableModelY1);
        tableX2 = new JTable(tableModelX2);
        tableY2 = new JTable(tableModelY2);
        tableX3 = new JTable(tableModelX3);
        tableY3 = new JTable(tableModelY3);
        setSize(new Dimension(1000, 800));

        tableX2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableY2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableX3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableY3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JLabel label1 = new JLabel("1 Функция                                                                                     ");
        JLabel label2 = new JLabel("2 Функция");
        JLabel label3 = new JLabel("                                                                                     Результат");

        JButton create1 = new JButton("Создать 1 ф-ю");
        create1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowOfTabulated windowOfTabulated1 = new WindowOfTabulated(factory);
                windowOfTabulated1.setVisible(true);
                stringsX1 = windowOfTabulated1.getStringsX();
                stringsY1 = windowOfTabulated1.getStringsY();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPaneX1 = new JScrollPane(tableX1);
        JScrollPane tableScrollPaneY1 = new JScrollPane(tableY1);
        JScrollPane tableScrollPaneX2 = new JScrollPane(tableX2);
        JScrollPane tableScrollPaneY2 = new JScrollPane(tableY2);
        JScrollPane tableScrollPaneX3 = new JScrollPane(tableX3);
        JScrollPane tableScrollPaneY3 = new JScrollPane(tableY3);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(create1)).addGroup(layout.createSequentialGroup().addComponent(label1).addComponent(label2).addComponent(label3)).addGroup(layout.createSequentialGroup().addGroup(layout.createSequentialGroup().addComponent(tableScrollPaneX1).addComponent(tableScrollPaneY1)).addGroup(layout.createSequentialGroup().addComponent(tableScrollPaneX2).addComponent(tableScrollPaneY2)).addGroup(layout.createSequentialGroup().addComponent(tableScrollPaneX3).addComponent(tableScrollPaneY3))).addGroup(layout.createSequentialGroup()));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(create1)).addGroup(layout.createParallelGroup().addComponent(label1).addComponent(label2).addComponent(label3)).addGroup(layout.createParallelGroup().addGroup(layout.createParallelGroup().addComponent(tableScrollPaneX1).addComponent(tableScrollPaneY1)).addGroup(layout.createParallelGroup().addComponent(tableScrollPaneX2).addComponent(tableScrollPaneY2)).addGroup(layout.createParallelGroup().addComponent(tableScrollPaneX3).addComponent(tableScrollPaneY3))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)));
        setLocationRelativeTo(null);
    }



}

