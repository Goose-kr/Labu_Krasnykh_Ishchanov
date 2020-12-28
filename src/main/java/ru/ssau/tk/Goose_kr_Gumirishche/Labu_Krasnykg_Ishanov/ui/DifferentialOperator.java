package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.TabulatedFunction;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.io.FunctionsIO;
import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.operations.TabulatedDifferentialOperator;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DifferentialOperator extends JDialog {
    //Таблица результата
    private final List<String> xValuesResult = new ArrayList<>(0);
    private final List<String> yValuesResult = new ArrayList<>(0);
    private final AbstractTableModel tableModelResult = new TableModel1(xValuesResult, yValuesResult, false);
    private final JTable tableResult = new JTable(tableModelResult);

    private final java.util.List<String> xValuesInitial = new ArrayList<>();
    private final List<String> yValuesInitial = new ArrayList<>();
    private final AbstractTableModel tableModelInitial = new TableModel1(xValuesInitial, yValuesInitial, true);
    private final JTable tableInitial = new JTable(tableModelInitial);

    private final JButton button = new JButton("Вычислить..");
    private final JButton buttonResult = new JButton("Сохранить результат");

    private final JButton buttonCreate = new JButton("Создать..");
    private final JButton buttonSave = new JButton("Сохранить..");
    private final JButton buttonDownload = new JButton("Загрузить..");
    private final JFileChooser save = new JFileChooser();
    private final JFileChooser downloadChooser = new JFileChooser();

    private final TabulatedDifferentialOperator differentialOperator;

    protected TabulatedFunction functionResult;
    protected TabulatedFunction functionInitial;


    protected DifferentialOperator() {
        super();
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setModal(true);
        setBounds(100, 100, 800, 700);
        differentialOperator= new TabulatedDifferentialOperator(Menu.factory);

        compose();
        addButtonListeners();

        CreatingArray.checkBoxSave.setVisible(false);
        CreatingFunction.checkBoxSave.setVisible(false);

        tableInitial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setVisible(true);
    }

    private void addButtonListeners() {
        //создание функции
        buttonCreate.addActionListener(e -> {
            Object[] buttonsName = {"Массив", "Функция", "Отмена"};
            int resultDialog = JOptionPane.showOptionDialog(new JFrame(), "Как вы хотите создать функцию?",
                    "Создать..", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, buttonsName, buttonsName[2]);
            xValuesInitial.clear();
            yValuesInitial.clear();

            xValuesResult.clear();
            yValuesResult.clear();

            switch (resultDialog) {
                case 0:
                    new CreatingArray(function -> functionInitial = function);
                    break;
                case 1:
                    new CreatingFunction(function -> functionInitial = function);
                    break;
            }

            for (int i = 0; i < functionInitial.getCount(); i++) {
                xValuesInitial.add(i, String.valueOf(functionInitial.getX(i)));
                yValuesInitial.add(i, String.valueOf(functionInitial.getY(i)));

                tableModelInitial.fireTableDataChanged();
            }
        });

        //подсчет и вывод результата
        button.addActionListener(e -> {
            //заменить измененные значения функции
            tableInitial.clearSelection();
            xValuesResult.clear();
            yValuesResult.clear();

            double[] arrayX = convert(xValuesInitial);
            double[] arrayY = convert(yValuesInitial);

            //подсчет производной и вставка в таблицу
            functionResult = differentialOperator.derive(Menu.factory.create(arrayX, arrayY));
            for (int i = 0; i < functionResult.getCount(); i++) {
                xValuesResult.add(i, String.valueOf(functionResult.getX(i)));
                yValuesResult.add(i, String.valueOf(functionResult.getY(i)));

                tableModelResult.fireTableDataChanged();
            }
        });

        buttonSave.addActionListener(e -> {
            int returnVal = save.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = save.getSelectedFile() + "bin";
                int flag = 1;
                File file = new File(fileName);
                if (file.exists()) {
                    flag = -1;
                    int ind = JOptionPane.showConfirmDialog(this, "Файл с таким названием существует.",
                            "Предупреждение", JOptionPane.ERROR_MESSAGE);
                    if (ind == 0) {
                        JOptionPane.showConfirmDialog(this, "Введите название файла", "Предупреждение", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (flag != -1) {
                    try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
                        if (functionInitial != null) {
                            FunctionsIO.serialize(out, functionInitial);
                            JOptionPane.showMessageDialog(this,
                                    "Файл '" + file.getName() +
                                            " сохранен");
                        } else {
                            throw new IOException();
                        }
                    } catch (Exception exception) {
                        new Err(this, exception);
                    }
                }

            }
        });
        buttonResult.addActionListener(e -> {
            int returnVal = save.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = save.getSelectedFile() + "bin";
                int flag = 1;
                File file = new File(fileName);
                if (file.exists()) {
                    flag = -1;
                    int ind = JOptionPane.showConfirmDialog(this, "Файл с таким названием существует.",
                            "Предупреждение", JOptionPane.ERROR_MESSAGE);
                    if (ind == 0) {
                        JOptionPane.showConfirmDialog(this, "Введите название файла", "Предупреждение", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (flag != -1) {
                    try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
                        if (functionResult != null) {
                            FunctionsIO.serialize(out, functionResult);
                            JOptionPane.showMessageDialog(this,
                                    "Файл '" + file.getName() +
                                            " сохранен");
                        } else {
                            throw new IOException();
                        }
                    } catch (Exception exception) {
                        new Err(this, exception);
                    }
                }
            }
        });

        buttonDownload.addActionListener(e ->
        {
            int returnVal = downloadChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = downloadChooser.getSelectedFile();
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
                    xValuesInitial.clear();
                    yValuesInitial.clear();
                    tableModelInitial.fireTableDataChanged();
                    functionInitial = FunctionsIO.deserialize(in);
                    int count = functionInitial.getCount();
                    for (int i = 0; i < count; i++) {
                        xValuesInitial.add(i, String.valueOf(functionInitial.getX(i)));
                        yValuesInitial.add(i, String.valueOf(functionInitial.getY(i)));
                        tableModelInitial.fireTableDataChanged();
                    }
                    buttonCreate.setEnabled(false);

                    button.setEnabled(true);
                    buttonSave.setEnabled(true);
                } catch (IOException | ClassNotFoundException exception) {
                    new Err(this, exception);
                }
            }
        });
    }

    private void compose() {
        JPanel panelResult = new JPanel();
        GroupLayout layoutResult = new GroupLayout(panelResult);
        panelResult.setLayout(layoutResult);
        layoutResult.setAutoCreateGaps(true);
        layoutResult.setAutoCreateContainerGaps(true);

        JScrollPane scrollPaneResult = new JScrollPane(tableResult);
        layoutResult.setHorizontalGroup(
                layoutResult.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layoutResult.createSequentialGroup()
                                .addComponent(buttonResult)
                                .addComponent(button))
                        .addComponent(scrollPaneResult));

        layoutResult.setVerticalGroup(layoutResult.createSequentialGroup()
                .addGroup(layoutResult.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(buttonResult)
                        .addComponent(button))
                .addComponent(scrollPaneResult));


        JPanel panelInitial = new JPanel();
        GroupLayout layoutInitial = new GroupLayout(panelInitial);
        panelInitial.setLayout(layoutInitial);
        layoutInitial.setAutoCreateGaps(true);
        layoutInitial.setAutoCreateContainerGaps(true);

        JScrollPane scrollPaneInitial = new JScrollPane(tableInitial);
        layoutInitial.setHorizontalGroup(
                layoutInitial.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layoutInitial.createSequentialGroup()
                                .addComponent(buttonCreate)
                                .addComponent(buttonDownload)
                                .addComponent(buttonSave))
                        .addComponent(scrollPaneInitial));

        layoutInitial.setVerticalGroup(layoutInitial.createSequentialGroup()
                .addGroup(layoutInitial.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(buttonCreate)
                        .addComponent(buttonDownload)
                        .addComponent(buttonSave))
                .addComponent(scrollPaneInitial));


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup().addGroup(layout.createSequentialGroup()
                .addComponent(panelInitial)
                .addComponent(panelResult)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup()
                .addComponent(panelInitial)
                .addComponent(panelResult)));

       /* getContentPane().setBackground(Settings.color);
        panelInitial.setBackground(Settings.color);
        panelResult.setBackground(Settings.color);*/
    }

    private double[] convert(List<String> values) {
        double[] array = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            String num = values.get(i);
            array[i] = Double.parseDouble(num);
        }
        return array;

    }
}

