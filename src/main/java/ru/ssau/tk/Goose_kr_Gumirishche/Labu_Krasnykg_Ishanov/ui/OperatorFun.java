package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
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
    TabulatedFunctionOperationService service=new TabulatedFunctionOperationService();
    TabulatedFunction function1;
    TabulatedFunction function2;
    TabulatedFunction function3;
    private ArrayList<String> stringsX3;
    private ArrayList<String> stringsY3;
    public OperatorFun(int size,TabulatedFunction function1,TabulatedFunction function2){
        JDialog dialog=new JDialog();
        setSize(new Dimension(400,200));
        setLocationRelativeTo(null);
        stringsY3 = new ArrayList<>();
        stringsX3 = new ArrayList<>();
        this.function1=function1;
        this.function2=function2;
        JComboBox<String> box = new JComboBox<>(new String[]{"","Сумма", "Разность", "Произведение", "Частное"
        });
        map.put("Сумма", service.sum(function1,function2));
        map.put("Разность", service.subtract(function1,function2));
        map.put("Произведение", service.multiply(function1,function2));
        map.put("Частное", service.division(function1,function2));
        box.setEditable(true);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    function3 = map.get(e.getItem().toString());
                }
            }
        });
        JButton result=new JButton("Выполнить");
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<size;i++){
                    System.out.println(function3.getX(i));
                    System.out.println(function3.getY(i));
                }
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

    public ArrayList<String> getStringsX3() {
        return stringsX3;
    }

    public ArrayList<String> getStringsY3() {
        return stringsY3;
    }
}
