package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Table extends JDialog {
    private final ArrayList<String> strings;
    private final ArrayList<String> strings2;
    private final AbstractTableModel tableModel;
    private final JTable table1;
    private final JTable table2;

    public Table(int size) {
        super();
        strings2=new ArrayList<>(size);
        strings = new ArrayList<>(size);
        tableModel = new TableModel(strings);
        table2=new JTable(tableModel);
        table1 = new JTable(tableModel);
        setSize(new Dimension(500, 500));
        JTextField textField=new JTextField();
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JButton addRowButton = new JButton("Add row");
        addRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strings.add("");
                tableModel.fireTableDataChanged();
            }
        });
        JButton removeRowButton = new JButton("Remove row");
        removeRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow2=table2.getSelectedRow();
                int selectedRow1 = table1.getSelectedRow();
                if (selectedRow1 != -1||selectedRow2!=-1) {
                    strings.remove(selectedRow1);
                    strings2.remove(selectedRow2);
                    tableModel.fireTableDataChanged();
                }
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane1 = new JScrollPane(table1);
        JScrollPane tableScrollPane2=new JScrollPane(table2);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(textField).addComponent(addRowButton).addComponent(removeRowButton)).addGroup(layout.createSequentialGroup().addComponent(tableScrollPane1).addComponent(tableScrollPane2)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(textField).addComponent(addRowButton).addComponent(removeRowButton)).addGroup(layout.createParallelGroup().addComponent(tableScrollPane1).addComponent(tableScrollPane2)));
        setLocationRelativeTo(null);
    }
}
