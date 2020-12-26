package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JDialog {
    private TabulatedFunctionFactory factory=new ArrayTabulatedFunctionFactory();
    JRadioButton massif;
    JRadioButton list;

    public Settings() {
        super();
        setModal(true);
        setLocationRelativeTo(null);
        setSize(new Dimension(300, 200));
        JLabel label = new JLabel("Выберите фабрику");
        massif = new JRadioButton("Массивы");
        list = new JRadioButton("Список");
        ButtonGroup group = new ButtonGroup();
        group.add(massif);
        group.add(list);
        massif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==massif){
                factory=new ArrayTabulatedFunctionFactory();}
            }
        });
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==list){
                factory=new LinkedListTabulatedFunctionFactory();
                }
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(label)).addComponent(massif).addComponent(list));
        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(label)).addComponent(massif).addComponent(list));
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }
}
