package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.ui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    private static final int INDEX_COLUMN_NUMBER = 0;
    private static final int VALUE_X_COLUMN_NUMBER = 1;
    private static final int VALUE_Y_COLUMN_NUMBER = 2;
    private static final long serialVersionUID = 5759471071820281777L;
    private final ArrayList<String> stringsY;
    private final ArrayList<String> stringsX;

    public MyTableModel(ArrayList<String> stringsX, ArrayList<String> stringsY) {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return rowIndex;
            case VALUE_X_COLUMN_NUMBER:
                return stringsX.get(rowIndex);
            case VALUE_Y_COLUMN_NUMBER:
                return stringsY.get(rowIndex);
        }
        throw new UnsupportedOperationException();
    }

    public void setValueAt(Object aValueX, Object aValueY, int rowIndex, int columnIndex) {
        if (columnIndex != VALUE_X_COLUMN_NUMBER) {
            return;
        }
        stringsX.set(rowIndex, String.valueOf(aValueX));
        stringsY.set(rowIndex, String.valueOf(aValueY));
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case INDEX_COLUMN_NUMBER:
                return false;
            case VALUE_X_COLUMN_NUMBER | VALUE_Y_COLUMN_NUMBER:
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
            case VALUE_Y_COLUMN_NUMBER:
                return "ValueY";
        }
        return super.getColumnName(column);
    }


}
