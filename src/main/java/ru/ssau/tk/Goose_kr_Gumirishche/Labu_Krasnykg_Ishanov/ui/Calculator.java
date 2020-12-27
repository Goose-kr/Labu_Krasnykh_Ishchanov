package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.*;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io.FunctionsIO;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedFunctionOperationService;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculator extends JFrame {
    private ArrayList<String> stringsX1;
    private ArrayList<String> stringsY1;
    private ArrayList<String> stringsX2;
    private ArrayList<String> stringsY2;
    private ArrayList<String> stringsX3;
    private ArrayList<String> stringsY3;
    private AbstractTableModel tableModel1;
    private AbstractTableModel tableModel2;
    private AbstractTableModel tableModel3;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private TabulatedFunction function1;
    private TabulatedFunction function2;
    private TabulatedFunction function3;
    private TabulatedFunctionFactory factory;
    int size;

    public Calculator(TabulatedFunctionFactory factory) {
        JFrame calculator = new JFrame("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.factory = factory;
        JFileChooser fileOpen1=new JFileChooser();
        fileOpen1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileOpen1.setDialogTitle("Загрузка функции");
        fileOpen1.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        fileOpen1.setAcceptAllFileFilterUsed(false);
        JFileChooser fileOpen2=new JFileChooser();
        fileOpen2.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileOpen2.setDialogTitle("Загрузка функции");
        fileOpen2.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        fileOpen2.setAcceptAllFileFilterUsed(false);
        JFileChooser fileSave1=new JFileChooser();
        fileSave1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileSave1.setDialogTitle("Сохранение функции");
        fileSave1.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        fileSave1.setAcceptAllFileFilterUsed(false);
        JFileChooser fileSave2=new JFileChooser();
        fileSave2.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileSave2.setDialogTitle("Сохранение функции");
        fileSave2.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        fileSave2.setAcceptAllFileFilterUsed(false);
        JFileChooser fileSave3=new JFileChooser();
        fileSave3.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileSave3.setDialogTitle("Сохранение функции");
        fileSave3.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        fileSave3.setAcceptAllFileFilterUsed(false);
        stringsX1 = new ArrayList<>();
        stringsY1 = new ArrayList<>();
        stringsY2 = new ArrayList<>();
        stringsX2 = new ArrayList<>();
        stringsY3 = new ArrayList<>();
        stringsX3 = new ArrayList<>();
        tableModel1 = new TableModel(stringsX1, stringsY1);
        tableModel2 = new TableModel(stringsX2, stringsY2);
        tableModel3 = new TableModel(stringsX3, stringsY3);
        table1 = new JTable(tableModel1);
        table2 = new JTable(tableModel2);
        table3 = new JTable(tableModel3);
        setSize(new Dimension(1000, 800));

        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JLabel label1 = new JLabel("1 Функция                                                                                     ");
        JLabel label2 = new JLabel("2 Функция");
        JLabel label3 = new JLabel("                                                                                     Результат");
        JLabel count = new JLabel("Введите размер");
        JTextField countField = new JTextField();
        JButton countButton = new JButton("Ввести");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = Integer.parseInt(countField.getText());
            }
        });
        JButton create1 = new JButton("Создать 1 ф-ю");
        create1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringsX1.clear();
                stringsY1.clear();
                JDialog progressBar = new ProgressBar();
                progressBar.setVisible(true);
                Table table1 = new Table(size, factory);
                table1.setVisible(true);
                for (int i = 0; i < size; i++) {
                    stringsX1.add(table1.getStringsX().get(i));
                    stringsY1.add(table1.getStringsY().get(i));
                }
                tableModel1.fireTableDataChanged();
                function1 = table1.getFunction();
            }
        });
        JButton load1=new JButton("Загрузить 1 ф-ю");
        load1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringsX1.clear();
                stringsY1.clear();
                fileOpen1.showOpenDialog(calculator);
                File file=fileOpen1.getSelectedFile();
                if (file != null) {
                    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                        TabulatedFunction function = FunctionsIO.readTabulatedFunction(in, new ArrayTabulatedFunctionFactory());
                        for (int i = 0; i < function.getCount(); i++) {
                            stringsX1.add(i, String.valueOf(function.getX(i)));
                            stringsY1.add(i, String.valueOf(function.getY(i)));
                            tableModel1.fireTableDataChanged();
                        }
                        System.out.println(function.toString());
                    } catch (IOException err) {
                        err.printStackTrace();
                    }
                }
            }
        });
        JButton save1=new JButton("Сохранить 1 ф-ю");
        save1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileSave1.showSaveDialog(calculator);
                File file = fileSave1.getSelectedFile();
                if (file != null) {
                    double[] xValues = new double[table1.getRowCount()];
                    double[] yValues = new double[table1.getRowCount()];
                    for (int i = 0; i < table1.getRowCount(); i++) {
                        xValues[i] = Double.parseDouble(table1.getValueAt(i, 0).toString());
                        yValues[i] = Double.parseDouble(table1.getValueAt(i, 1).toString());
                    }

                    function1 = factory.create(xValues, yValues);

                    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                        FunctionsIO.writeTabulatedFunction(out, function1);
                    } catch (IOException error) {
                        error.printStackTrace();
                    }
                }
            }
        });
        JButton create2 = new JButton("Создать 2 ф-ю");
        create2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringsX2.clear();
                stringsY2.clear();
                JDialog progressBar = new ProgressBar();
                progressBar.setVisible(true);
                Table table2 = new Table(size, factory);
                table2.setVisible(true);
                for (int i = 0; i < size; i++) {
                    stringsX2.add(table2.getStringsX().get(i));
                    stringsY2.add(table2.getStringsY().get(i));
                }
                tableModel2.fireTableDataChanged();
                function2 = table2.getFunction();
            }
        });
        JButton load2=new JButton("Загрузить 2 ф-ю");
        load2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileOpen2.showOpenDialog(calculator);
                File file=fileOpen2.getSelectedFile();
                if (file != null) {
                    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                        TabulatedFunction function = FunctionsIO.readTabulatedFunction(in, new ArrayTabulatedFunctionFactory());
                        for (int i = 0; i < function.getCount(); i++) {
                            stringsX2.add(i, String.valueOf(function.getX(i)));
                            stringsY2.add(i, String.valueOf(function.getY(i)));
                            tableModel2.fireTableDataChanged();
                        }
                        System.out.println(function.toString());
                    } catch (IOException err) {
                        err.printStackTrace();
                    }
                }
            }
        });
        JButton save2=new JButton("Сохранить 2 ф-ю");
        save2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileSave2.showSaveDialog(calculator);
                File file = fileSave2.getSelectedFile();
                if (file != null) {
                    double[] xValues = new double[table2.getRowCount()];
                    double[] yValues = new double[table2.getRowCount()];
                    for (int i = 0; i < table2.getRowCount(); i++) {
                        xValues[i] = Double.parseDouble(table2.getValueAt(i, 0).toString());
                        yValues[i] = Double.parseDouble(table2.getValueAt(i, 1).toString());
                    }

                    function2 = factory.create(xValues, yValues);

                    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                        FunctionsIO.writeTabulatedFunction(out, function2);
                    } catch (IOException error) {
                        error.printStackTrace();
                    }
                }
            }
        });
        JButton save3=new JButton("Сохранить 3 ф-ю");
        save3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileSave3.showSaveDialog(calculator);
                File file = fileSave3.getSelectedFile();
                if (file != null) {
                    double[] xValues = new double[table3.getRowCount()];
                    double[] yValues = new double[table3.getRowCount()];
                    for (int i = 0; i < table3.getRowCount(); i++) {
                        xValues[i] = Double.parseDouble(table3.getValueAt(i, 0).toString());
                        yValues[i] = Double.parseDouble(table3.getValueAt(i, 1).toString());
                    }

                    function3 = factory.create(xValues, yValues);

                    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                        FunctionsIO.writeTabulatedFunction(out, function3);
                    } catch (IOException error) {
                        error.printStackTrace();
                    }
                }
            }
        });
        JButton operate = new JButton("Операции");
        operate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperatorFun operatorFun = new OperatorFun(size, function1, function2);
                operatorFun.setVisible(true);
                for (int i = 0; i < size; i++) {
                    stringsX3.add(i, String.valueOf(operatorFun.function3.getX(i)));
                    stringsY3.add(i, String.valueOf(operatorFun.function3.getY(i)));
                    System.out.println(function3);
                }
                tableModel3.fireTableDataChanged();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane tableScrollPane1 = new JScrollPane(table1);
        JScrollPane tableScrollPane2 = new JScrollPane(table2);
        JScrollPane tableScrollPane3 = new JScrollPane(table3);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup().addComponent(count).addComponent(countField).addComponent(countButton))
                .addGroup(layout.createSequentialGroup().addComponent(create1).addComponent(create2).addComponent(operate))
                .addGroup(layout.createSequentialGroup().addComponent(load1).addComponent(load2))
                .addGroup(layout.createSequentialGroup().addComponent(save1).addComponent(save2).addComponent(save3))
                .addGroup(layout.createSequentialGroup().addComponent(label1).addComponent(label2).addComponent(label3))
                .addGroup(layout.createSequentialGroup().addComponent(tableScrollPane1).addComponent(tableScrollPane2).addComponent(tableScrollPane3))
                .addGroup(layout.createSequentialGroup()));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(count).addComponent(countField).addComponent(countButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(create1).addComponent(create2).addComponent(operate))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(load1).addComponent(load2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(save1).addComponent(save2).addComponent(save3))
                .addGroup(layout.createParallelGroup().addComponent(label1).addComponent(label2).addComponent(label3))
                .addGroup(layout.createParallelGroup().addComponent(tableScrollPane1).addComponent(tableScrollPane2).addComponent(tableScrollPane3))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)));
        setLocationRelativeTo(null);
    }


}

