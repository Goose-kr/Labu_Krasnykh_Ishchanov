package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class FirstWindow extends JFrame {

    public FirstWindow() {
        JFrame jFrame = new JFrame("Hey hey");
        this.setBounds(200, 200, 500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        Container container = this.getContentPane();
        JLabel label = new JLabel("Input size:");
        container.add(label);
        JTextField input = new JTextField(" ");
        container.add(input);
        JButton button = new JButton("enter");
        container.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "Салам пополам");
            }
        });
    }

        /*GroupLayout layout=new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane =new JScrollPane(table);
    }*/

    public class MyTableModel extends AbstractTableModel {
        private static final int INDEX_COLUMN_NUMBER = 0;
        private static final int VALUE_X_COLUMN_NUMBER = 1;
        private static final int VALUE_Y_COLUMN_NUMBER = 2;
        private List strings;

        public MyTableModel(List strings) {
            this.strings = strings;
        }

        @Override
        public int getRowCount() {

            return strings.size;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
               case INDEX_COLUMN_NUMBER:
                    return rowIndex;
                case VALUE_X_COLUMN_NUMBER:
                    return strings.get(rowIndex);
                case VALUE_Y_COLUMN_NUMBER:
                    return strings.get(rowIndex);
            }
            throw new UnsupportedOperationException();
        }

        @Override

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex != VALUE_COLUMN_NUMBER) {
                return;
            }
            strings.set(rowIndex, String.valueOf(aValue));
        }

    }

    public static void main(String[] args) {
        JFrame firstWindow = new FirstWindow();
        firstWindow.setVisible(true);
    }
}
