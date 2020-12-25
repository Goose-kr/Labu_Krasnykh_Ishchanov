package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

public class WindowOfTabulated extends JDialog {

    public TabulatedFunction tabulatedFunction;

    public WindowOfTabulated(int number) {
        super();
            this.setBounds(200, 200, 400, 100);
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
                    JDialog progressBar = new ProgressBar();
                    progressBar.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                    progressBar.setVisible(true);
                    Integer size;
                    size = Integer.valueOf(input.getText());
                    Table table = new Table(size,number);
                    table.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                    table.setVisible(true);
                    tabulatedFunction = table.getFunction();
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
    public void setTabulatedFunction(TabulatedFunction function){
        this.tabulatedFunction=function;
    }
    public TabulatedFunction getTabulatedFunction(){
        return tabulatedFunction;
    }
}
