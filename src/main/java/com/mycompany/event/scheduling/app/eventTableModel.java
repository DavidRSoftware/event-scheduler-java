package com.mycompany.event.scheduling.app;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;
import javax.swing.event.TableModelEvent;

/**
 *
 * @author david
 */
public class eventTableModel extends AbstractTableModel {

    private boolean DEBUG = true;
    private String[] columnNames = {"Event Name", "Event Date"};
    private Object[][] data = {};

    Vector dataVec = new Vector();

    public eventTableModel() {
        for (int i = 0; i < data.length; i++) {
            dataVec.addElement(data[i]);
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return dataVec.size();
    }

    public Object getValueAt(int row, int col) {
        Object[] rowData = (Object[]) dataVec.elementAt(row);
        return rowData[col];
    }

    public void addRow(Object[] rowData) {
        dataVec.addElement(rowData);
        fireTableChanged(new TableModelEvent(this));
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
}
