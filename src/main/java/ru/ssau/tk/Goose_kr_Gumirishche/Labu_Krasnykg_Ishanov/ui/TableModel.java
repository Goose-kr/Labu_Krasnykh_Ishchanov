package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TableModel extends AbstractTableModel {
    private static final int VALUE_X_COLUMN_NUMBER = 0;
    private static final int VALUE_Y_COLUMN_NUMBER = 1;
    private final ArrayList<String[]> strings;

    public TableModel(ArrayList<String[]> strings) {
        this.strings = strings;
    }

    @Override
    public int getRowCount() {
        return strings.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case VALUE_X_COLUMN_NUMBER:
                return "XValues";
            case VALUE_Y_COLUMN_NUMBER:
                return "YValues";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case VALUE_X_COLUMN_NUMBER:
            case VALUE_Y_COLUMN_NUMBER:
                return strings.get(rowIndex)[columnIndex];
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        if (columnIndex == VALUE_X_COLUMN_NUMBER||columnIndex==VALUE_Y_COLUMN_NUMBER) {
            strings.set(rowIndex, String.valueOf(o));
        }
        else {
            return;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case VALUE_X_COLUMN_NUMBER:
            case VALUE_Y_COLUMN_NUMBER:
                return true;
        }
        return false;
    }


}
