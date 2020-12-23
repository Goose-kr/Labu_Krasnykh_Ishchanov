package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    ArrayList<String> strings = new ArrayList<>();
    AbstractTableModel tableModel = new MyTableModel(strings);
    JTable table = new JTable(tableModel);
    JButton addRowButton = new JButton("Add row");
    JButton removeRowButton = new JButton("Remove row");
    Container container = this.getContentPane();
    public MyFrame() {
        super("Таблица");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLocationRelativeTo(null);
        container.add(addRowButton);
        container.add(removeRowButton);
        addRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strings.add("");
                tableModel.fireTableDataChanged();
            }
        });
        removeRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow=table.getSelectedRow();
                if(selectRow!=-1){
                    strings.remove(selectRow);
                    tableModel.fireTableDataChanged();
                }
            }
        });
        GroupLayout layout=new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane =new JScrollPane(table);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(addRowButton).addComponent(removeRowButton)).addComponent(tableScrollPane));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(addRowButton).addComponent(removeRowButton)).addComponent(tableScrollPane));
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        JFrame firstWindow = new MyFrame();
        firstWindow.setVisible(true);
    }
}
