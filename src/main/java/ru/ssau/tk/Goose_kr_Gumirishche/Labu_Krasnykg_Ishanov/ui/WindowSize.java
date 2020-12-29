package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
public class WindowSize extends JDialog {
    private int size;

    public WindowSize() {
        JDialog dialog = new JDialog();
        this.setBounds(200, 200, 400, 100);
        setLocationRelativeTo(null);
        setModal(true);
        JLabel label = new JLabel("Число точек:");
        JTextField input = new JTextField();
        JButton button = new JButton("enter");
        button.addActionListener(e -> {
            if (input.getText().equals("") || Integer.parseInt(input.getText()) < 2) {
                JOptionPane.showMessageDialog(dialog, "Введите корректно число точек");
            } else {
                size = Integer.parseInt(input.getText());
                dispose();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(label).addComponent(input)).addComponent(button));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(label).addComponent(input)).addComponent(button));

    }

    public int getSizeOf() {
        return size;
    }
}