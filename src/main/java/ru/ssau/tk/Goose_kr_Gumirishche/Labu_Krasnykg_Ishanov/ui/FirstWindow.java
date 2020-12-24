package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class FirstWindow extends JFrame {

    public FirstWindow() {
        JFrame jFrame = new JFrame("Hey hey");
        this.setBounds(200, 200, 400, 100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                Integer size;
                size = Integer.valueOf(input.getText());
                JDialog table = new Table(size);
                table.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                table.setVisible(true);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(label).addComponent(input)).addComponent(button));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(label).addComponent(input)).addComponent(button));

    }

    public static void main(String[] args) {
        JFrame frame = new FirstWindow();
        frame.setVisible(true);
    }
}
