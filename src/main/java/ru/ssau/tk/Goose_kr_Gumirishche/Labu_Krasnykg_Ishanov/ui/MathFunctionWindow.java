package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.*;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class MathFunctionWindow extends JDialog {
    String functionStr;
    TabulatedFunctionFactory factory;
    Map<String, MathFunction> map = new HashMap<>();
    MathFunction function;

    public MathFunctionWindow(TabulatedFunctionFactory factory) {
        JDialog dialog = new JDialog();
        this.factory = factory;
        setModal(true);
        setSize(new Dimension(400, 250));
        setLocationRelativeTo(null);
        JLabel labelHelperConst = new JLabel("Если вы хотите создать константную ф-ю, введите константу!");
        JLabel labelConst = new JLabel("Константа:");
        JTextField fieldConst = new JTextField();
        JButton buttonConst = new JButton("Добавить константу");
        buttonConst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fieldConst.getText().equals("")) {
                    JOptionPane.showMessageDialog(dialog, "Введите корректно константу");
                } else {
                    WindowSize windowSize = new WindowSize();
                    windowSize.setVisible(true);
                    TableMath tableMath = new TableMath(factory, new ConstantFunction(Double.parseDouble(fieldConst.getText())), windowSize.getSizeOf());
                    tableMath.setVisible(true);
                    dispose();
                }
            }
        });
        JLabel labelCompositeHelper = new JLabel("Для создания сложной ф-ии нажмите на кнопку (Части)");
        JButton compositeButton = new JButton("Части");
        compositeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompositeFirstPart composite = new CompositeFirstPart(factory);
                dispose();
                composite.setVisible(true);
            }
        });
        map.put("Двойная ф-я", new SumFunction());
        map.put("Единичная ф-я", new UnitFunction());
        map.put("Квадратная ф-я", new SqrFunction());
        map.put("Нулевая ф-я", new ZeroFunction());
        map.put("Тождественная ф-я", new IdentityFunction());
        JComboBox<String> box = new JComboBox<>(new String[]{"Двойная ф-я", "Единичная ф-я", "Квадратная ф-я", "Нулевая ф-я", "Тождественная ф-я"
        });
        box.setEditable(true);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    functionStr = e.getItem().toString();
                    System.out.println(functionStr);
                    function = map.get(functionStr);
                }
            }
        });
        JButton create = new JButton("Создать");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowSize windowSize = new WindowSize();
                windowSize.setVisible(true);
                TableMath tableMath = new TableMath(factory, function, windowSize.getSizeOf());
                tableMath.setVisible(true);
                dispose();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup().addComponent(labelHelperConst))
                .addGroup(layout.createSequentialGroup().addComponent(labelConst).addComponent(fieldConst).addComponent(buttonConst))
                .addGroup(layout.createParallelGroup().addComponent(labelCompositeHelper).addComponent(compositeButton))
                .addGroup(layout.createSequentialGroup().addComponent(box).addComponent(create)));
        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createSequentialGroup().addComponent(labelHelperConst))
                .addGroup(layout.createParallelGroup().addComponent(labelConst).addComponent(fieldConst).addComponent(buttonConst))
                .addGroup(layout.createSequentialGroup().addComponent(labelCompositeHelper).addComponent(compositeButton))
                .addGroup(layout.createSequentialGroup().addComponent(box).addComponent(create)));

    }
}
