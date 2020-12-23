package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Table extends JDialog {
    private final ArrayList<String> stringsX;
    private final ArrayList<String> stringsY;
    private final AbstractTableModel tableModelX;
    private final AbstractTableModel tableModelY;
    private final JTable tableX;
    private final JTable tableY;

    public Table(int size) {
        super();
        stringsY=new ArrayList<>(size);
        stringsX= new ArrayList<>(size);
        for(int i=0;i<size;i++){
            stringsX.add("");
            stringsY.add("");
        }
        tableModelX = new TableModelX(stringsX);
        tableModelY=new TableModelY(stringsY);
        tableY=new JTable(tableModelX);
        tableX = new JTable(tableModelY);
        setSize(new Dimension(500, 500));
        tableY.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableX.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JButton create=new JButton("Создать");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabulatedFunctionFactory factory=new ArrayTabulatedFunctionFactory();
                double[] xValues=new double[size];
                double[] yValues=new double[size];
                for(int i=0;i<size;i++){
                    xValues[i]=Double.parseDouble(stringsX.get(i));
                    yValues[i]=Double.parseDouble(stringsY.get(i));
                    System.out.println(xValues[i]);
                    System.out.println(yValues[i]);
                }
                factory.create(xValues,yValues);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPaneX = new JScrollPane(tableX);
        JScrollPane tableScrollPaneY=new JScrollPane(tableY);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(tableScrollPaneX).addComponent(tableScrollPaneY)).addGroup(layout.createSequentialGroup().addComponent(create)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(tableScrollPaneX).addComponent(tableScrollPaneY)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(create)));
        setLocationRelativeTo(null);
    }
}
