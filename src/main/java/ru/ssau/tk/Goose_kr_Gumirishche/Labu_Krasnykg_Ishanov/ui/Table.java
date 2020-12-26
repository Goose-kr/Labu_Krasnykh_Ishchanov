package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.ArrayTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Table extends JDialog {
    private final ArrayList<String> stringsX;
    private final ArrayList<String> stringsY;
    private final AbstractTableModel tableModelX;
    private final AbstractTableModel tableModelY;
    private final JTable tableX;
    private final JTable tableY;
    private TabulatedFunction function;
    private TabulatedFunctionFactory factory;
    private double[] xValues;
    private double[] yValues;

    public Table(int size, TabulatedFunctionFactory factory) {
        JDialog dialog = new JDialog();
        setModal(true);
        this.factory = factory;
        stringsY = new ArrayList<>(size);
        stringsX = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            stringsX.add("");
            stringsY.add("");
        }
        tableModelX = new TableModelX(stringsX);
        tableModelY = new TableModelY(stringsY);
        tableX = new JTable(tableModelX);
        tableY = new JTable(tableModelY);
        setSize(new Dimension(500, 500));
        tableX.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableY.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JButton create = new JButton("Создать");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stringsX.contains("") || stringsY.contains("")) {
                    JOptionPane.showMessageDialog(dialog, "Введите корректно значения точек");
                } else {
                     xValues = new double[size];
                     yValues = new double[size];
                    for (int i = 0; i < size; i++) {
                        xValues[i] = Double.parseDouble(stringsX.get(i));
                        yValues[i] = Double.parseDouble(stringsY.get(i));
                        System.out.println(xValues[i]);
                        System.out.println(yValues[i]);
                    }
                    function = factory.create(xValues, yValues);
                    System.out.println(function instanceof ArrayTabulatedFunction);
                    System.out.println(function instanceof LinkedListTabulatedFunction);
                    dispose();
                }
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPaneX = new JScrollPane(tableX);
        JScrollPane tableScrollPaneY = new JScrollPane(tableY);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(tableScrollPaneX).addComponent(tableScrollPaneY)).addGroup(layout.createSequentialGroup().addComponent(create)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(tableScrollPaneX).addComponent(tableScrollPaneY)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(create)));
        setLocationRelativeTo(null);
    }

    public TabulatedFunction getFunction() {
        return function;
    }

    public double[] getXValues() {
        return xValues;
    }

    public double[] getYValues() {
        return yValues;
    }

    public ArrayList<String> getStringsX() {
        return stringsX;
    }

    public ArrayList<String> getStringsY() {
        return stringsY;
    }
}
