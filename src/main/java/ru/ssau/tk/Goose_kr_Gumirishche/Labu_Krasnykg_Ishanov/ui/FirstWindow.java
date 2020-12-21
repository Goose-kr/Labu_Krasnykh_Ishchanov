package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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

            public static void main (String[]args){
                JFrame firstWindow = new FirstWindow();
                firstWindow.setVisible(true);
            }
        }
