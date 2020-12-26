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
    double constant;
    public MathFunctionWindow(TabulatedFunctionFactory factory){
        super();
        this.factory=factory;
        setModal(true);
        setSize(new Dimension(400,400));
        setLocationRelativeTo(null);
        map.put("Двойная ф-я",new SumFunction());
        map.put("Единичная ф-я", new UnitFunction());
        map.put("Квадратная ф-я", new SqrFunction());
        map.put("Константная ф-я", new ConstantFunction(3));
        map.put("Нулевая ф-я", new ZeroFunction());
        map.put("Сложная ф-я", new CompositeFunction(new SumFunction(),new ZeroFunction()));
        map.put("Тождественная ф-я", new IdentityFunction());
        JLabel labelHelperConst =new JLabel("Если вы хотите создать константную ф-ю, введите константу!");
        JLabel labelConst=new JLabel("Константа:");
        JTextField fieldConst=new JTextField();
        JButton buttonConst=new JButton("Добавить константу");
        buttonConst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                constant=Double.parseDouble(fieldConst.getText());
            }
        });
        JLabel labelCompositeHelper=new JLabel("Для создания сложной ф-ии нужно выбрать части этой функции, для этого нажмите на кнопку (Части)");
        JButton compositeButton=new JButton("Части");
        compositeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JComboBox<String> box=new JComboBox<>(new String[]{"Двойная ф-я","Единичная ф-я","Квадратная ф-я","Константная ф-я","Нулевая ф-я","Сложная ф-я","Тождественная ф-я"
        });
        box.setEditable(true);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    functionStr=e.getItem().toString();
                    System.out.println(functionStr);
                    function=map.get(functionStr);
                }
            }
        });
        JButton create=new JButton("Создать");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowSize windowSize=new WindowSize();
                windowSize.setVisible(true);
                TableMath tableMath=new TableMath(factory,function,windowSize.getSizeOf());
                tableMath.setVisible(true);
                dispose();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(layout.createSequentialGroup().addComponent(labelHelperConst)).addGroup(layout.createSequentialGroup().addComponent(labelConst).addComponent(fieldConst).addComponent(buttonConst)).addGroup(layout.createSequentialGroup().addComponent(box).addComponent(create)));
        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createSequentialGroup().addComponent(labelHelperConst)).addGroup(layout.createParallelGroup().addComponent(labelConst).addComponent(fieldConst).addComponent(buttonConst)).addGroup(layout.createSequentialGroup().addComponent(box).addComponent(create)));

    }
}
