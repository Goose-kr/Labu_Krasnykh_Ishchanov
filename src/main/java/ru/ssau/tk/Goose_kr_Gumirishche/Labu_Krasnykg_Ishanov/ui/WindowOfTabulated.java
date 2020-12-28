package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class WindowOfTabulated extends JDialog {

    public TabulatedFunction tabulatedFunction;
    private ArrayList<String> stringsX;
    private ArrayList<String> stringsY;

    public WindowOfTabulated(TabulatedFunctionFactory factory) {
        JDialog dialog = new JDialog();
        setModal(true);
        this.setBounds(200, 200, 400, 100);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Число точек:");
        JTextField input = new JTextField();
        JButton button = new JButton("enter");
        button.addActionListener(e -> {
            if (input.getText().equals("") || Integer.parseInt(input.getText()) < 2) {
                JOptionPane.showMessageDialog(dialog, "Введите корректно число точек");
            } else {
                JDialog progressBar = new ProgressBar();
                progressBar.setVisible(true);
                Integer size;
                size = Integer.valueOf(input.getText());
                Table table = new Table(size, factory);
                table.setVisible(true);
                tabulatedFunction = table.getFunction();
                stringsX = table.getStringsX();
                stringsY = table.getStringsY();
                dispose();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup().addComponent(label).addComponent(input)).addComponent(button));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(label).addComponent(input)).addComponent(button));
    }

    public void setTabulatedFunction(TabulatedFunction function) {
        this.tabulatedFunction = function;
    }

    public TabulatedFunction getTabulatedFunction() {
        return tabulatedFunction;
    }
}