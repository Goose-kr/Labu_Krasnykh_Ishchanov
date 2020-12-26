package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.*;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TableMath extends JDialog {
    private final ArrayList<String> stringsX;
    private final ArrayList<String> stringsY;
    private final AbstractTableModel tableModelX;
    private final JTable tableX;
    String functionStr;
    TabulatedFunctionFactory factory;
    MathFunction function;
    TabulatedFunction functionTab;
    int choice;
    Map<String, Integer> map = new HashMap<>();

    public TableMath(TabulatedFunctionFactory factory, MathFunction function, int size) {
        JDialog dialog = new JDialog();
        this.function = function;
        stringsX = new ArrayList<>(size);
        stringsY = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            stringsX.add("");
            stringsY.add("");
        }
        tableModelX = new TableModelX(stringsX);
        tableX = new JTable(tableModelX);
        setSize(new Dimension(500, 500));
        tableX.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.factory = factory;
        JButton create = new JButton("Создать");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stringsX.contains("")) {
                    JOptionPane.showMessageDialog(dialog, "Введите корректно значения точек");
                } else {
                    double[] xValues = new double[size];
                    double[] yValues = new double[size];
                    for (int i = 0; i < size; i++) {
                        xValues[i] = Double.parseDouble(stringsX.get(i));
                        System.out.println(xValues[i]);
                        yValues[i] = function.apply(xValues[i]);
                        System.out.println(yValues[i]);
                    }
                    functionTab = factory.create(xValues, yValues);
                    System.out.println(functionTab instanceof ArrayTabulatedFunction);
                    System.out.println(functionTab instanceof LinkedListTabulatedFunction);
                    dispose();
                }
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPaneX = new JScrollPane(tableX);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(tableScrollPaneX)).addGroup(layout.createSequentialGroup().addComponent(create)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(tableScrollPaneX)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(create)));
        setLocationRelativeTo(null);
    }
}
