package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Table extends JDialog {
    private final ArrayList<String[]> strings;
    private final AbstractTableModel tableModel;
    private final JTable table;

    public Table(int size) {
        super();
        strings = new ArrayList<>(size);
        tableModel = new TableModel(strings);
        table = new JTable(tableModel);
        setSize(new Dimension(500, 500));
        JTextField textField=new JTextField();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    strings.remove(selectedRow);
                    tableModel.fireTableDataChanged();
                }
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(textField).addComponent(addRowButton).addComponent(removeRowButton)).addComponent(tableScrollPane));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(textField).addComponent(addRowButton).addComponent(removeRowButton)).addComponent(tableScrollPane));
        setLocationRelativeTo(null);
    }
}
