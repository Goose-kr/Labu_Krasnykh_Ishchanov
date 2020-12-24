package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TableModelX extends AbstractTableModel {
    private static final int INDEX_COLUMN_NUMBER = 0;
    private static final int VALUE_X_COLUMN_NUMBER = 1;
    private static final long serialVersionUID = -2085652328948175353L;
    private final ArrayList<String> strings;

    public TableModelX(ArrayList<String> strings) {
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
            case INDEX_COLUMN_NUMBER:
                return "Index";
            case VALUE_X_COLUMN_NUMBER:
                return "XValues";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return rowIndex;
            case VALUE_X_COLUMN_NUMBER:
                return strings.get(rowIndex);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        if (columnIndex == VALUE_X_COLUMN_NUMBER) {
            strings.set(rowIndex, String.valueOf(o));
        } else {
            return;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return false;
            case VALUE_X_COLUMN_NUMBER:
                return true;
        }
        return false;
    }


}
