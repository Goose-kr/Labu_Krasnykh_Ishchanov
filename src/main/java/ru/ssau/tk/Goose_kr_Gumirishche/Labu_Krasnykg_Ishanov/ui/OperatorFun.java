package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedFunctionOperationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OperatorFun extends JDialog {
    Map<String, TabulatedFunction> map = new HashMap<>();
    TabulatedFunctionOperationService service;
    TabulatedFunction function3;
    private final ArrayList<String> stringsX3;
    private final ArrayList<String> stringsY3;

    public OperatorFun(int size, TabulatedFunctionFactory factory, TabulatedFunction function1, TabulatedFunction function2) {
        JDialog dialog = new JDialog();
        setModal(true);
        setSize(new Dimension(400, 100));
        setLocationRelativeTo(null);
        service = new TabulatedFunctionOperationService(factory);
        stringsY3 = new ArrayList<>();
        stringsX3 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            stringsX3.add("");
            stringsY3.add("");
        }
        JComboBox<String> box = new JComboBox<>(new String[]{"", "Сумма", "Разность", "Произведение", "Частное"
        });
        map.put("Сумма", service.sum(function1, function2));
        map.put("Разность", service.subtract(function1, function2));
        map.put("Произведение", service.multiply(function1, function2));
        map.put("Частное", service.division(function1, function2));
        box.setEditable(true);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    function3 = map.get(e.getItem().toString());
                }
            }
        });
        JButton result = new JButton("Выполнить");
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(function3);
                dispose();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup().addComponent(box).addComponent(result)));
        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(box).addComponent(result)));
    }

    public TabulatedFunction getFunction3() {
        return function3;
    }

    public ArrayList<String> getStringsX3() {
        return stringsX3;
    }

    public ArrayList<String> getStringsY3() {
        return stringsY3;
    }
}
