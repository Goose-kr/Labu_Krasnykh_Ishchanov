package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelResult extends AbstractTableModel {
    private static final int VALUE_X_COLUMN_NUMBER = 0;
    private static final int VALUE_Y_COLUMN_NUMBER = 1;
    private static final long serialVersionUID = -6636948117254566264L;
    private final ArrayList<String> stringsX;
    private final ArrayList<String> stringsY;

    public TableModelResult(ArrayList<String> stringsX, ArrayList<String> stringsY) {
        this.stringsX = stringsX;
        this.stringsY = stringsY;
    }

    @Override
    public int getRowCount() {
        return stringsX.size();
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
                return stringsX.get(rowIndex);
            case VALUE_Y_COLUMN_NUMBER:
                return stringsY.get(rowIndex);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        if (columnIndex == VALUE_X_COLUMN_NUMBER) {
            stringsX.set(rowIndex, String.valueOf(o));
        } else if (columnIndex == VALUE_Y_COLUMN_NUMBER) {
            stringsY.set(rowIndex, String.valueOf(o));
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}

