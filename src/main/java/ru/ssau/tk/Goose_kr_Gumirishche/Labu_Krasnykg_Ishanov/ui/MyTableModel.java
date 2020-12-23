package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    private static final int INDEX_COLUMN_NUMBER = 0;
    private static final int VALUE_X_COLUMN_NUMBER = 1;
    private static final long serialVersionUID = 5759471071820281777L;
    private final ArrayList<String> strings;

    public MyTableModel(ArrayList<String> strings) {
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
    public void setValueAt(Object aValueX, int rowIndex, int columnIndex) {
        if (columnIndex != VALUE_X_COLUMN_NUMBER) {
            return;
        }
       strings.set(rowIndex,String.valueOf(aValueX));
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

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case INDEX_COLUMN_NUMBER:
                return "Index";
            case VALUE_X_COLUMN_NUMBER:
                return "ValueX";
        }
        return super.getColumnName(column);
    }


}
