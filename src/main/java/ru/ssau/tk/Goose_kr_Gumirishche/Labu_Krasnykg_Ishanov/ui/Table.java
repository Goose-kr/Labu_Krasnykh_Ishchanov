package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Table extends JDialog {
    private final ArrayList<String> stringsX;
    private final ArrayList<String> stringsY;
    private TabulatedFunction function;
    private double[] xValues;
    private double[] yValues;
    private int ex = 1;

    public Table(int size, TabulatedFunctionFactory factory) {
        JDialog dialog = new JDialog();
        setModal(true);
        stringsY = new ArrayList<>(size);
        stringsX = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            stringsX.add("");
            stringsY.add("");
        }
        AbstractTableModel tableModel = new TableModel(stringsX, stringsY);
        JTable table = new JTable(tableModel);
        setSize(new Dimension(500, 500));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JButton create = new JButton("Создать");
        create.addActionListener(e -> {
            for (int i = 0; i < size - 1; i++) {
                if (Double.parseDouble(stringsX.get(i)) >= Double.parseDouble(stringsX.get(i + 1))) {
                    JOptionPane.showMessageDialog(dialog, "Х неупорядочен");
                    ex = 0;
                }
            }
            if (stringsX.contains("") || stringsY.contains("")) {
                JOptionPane.showMessageDialog(dialog, "Введите корректно значения точек");
            } else if (ex == 0) {
            } else {
                xValues = new double[size];
                yValues = new double[size];
                for (int i = 0; i < size; i++) {
                    xValues[i] = Double.parseDouble(stringsX.get(i));
                    yValues[i] = Double.parseDouble(stringsY.get(i));
                }
                function = factory.create(xValues, yValues);
                System.out.println(function.toString());
                dispose();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPaneX = new JScrollPane(table);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(tableScrollPaneX)).addGroup(layout.createSequentialGroup().addComponent(create)));
        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(tableScrollPaneX)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(create)));
        setLocationRelativeTo(null);
    }

    public TabulatedFunction getFunction() {
        return function;
    }

    public ArrayList<String> getStringsX() {
        return stringsX;
    }

    public ArrayList<String> getStringsY() {
        return stringsY;
    }
}