package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedFunctionOperationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

public class OperatorFun extends JDialog {
    private final Map<String, TabulatedFunction> map = new HashMap<>();
    TabulatedFunction function3;

    public OperatorFun(TabulatedFunctionFactory factory, TabulatedFunction function1, TabulatedFunction function2) {
        super();
        setModal(true);
        setSize(new Dimension(400, 100));
        setLocationRelativeTo(null);
        TabulatedFunctionOperationService service = new TabulatedFunctionOperationService(factory);
        JComboBox<String> box = new JComboBox<>(new String[]{"", "Сумма", "Разность", "Произведение", "Частное"
        });
        map.put("Сумма", service.sum(function1, function2));
        map.put("Разность", service.subtract(function1, function2));
        map.put("Произведение", service.multiply(function1, function2));
        map.put("Частное", service.division(function1, function2));
        box.setEditable(true);
        box.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                function3 = map.get(e.getItem().toString());
            }
        });
        JButton result = new JButton("Выполнить");
        result.addActionListener(e -> {
            System.out.println(function3);
            dispose();
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup().addComponent(box).addComponent(result)));
        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(box).addComponent(result)));
    }
}