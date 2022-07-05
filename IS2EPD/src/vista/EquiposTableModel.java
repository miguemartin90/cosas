/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.Equipo;

/**
 *
 * @author Rafa
 */
public class EquiposTableModel implements TableModel {

    private List<Equipo> equipos = new ArrayList<Equipo>();
    private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
        fireContentsChanged();
    }

    public Equipo getRow(int indexRow) {
        return equipos.get(indexRow);
    }

    public int getRowCount() {
        return equipos.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Nombre";
                break;
            case 1:
                name = "Pais";
                break;
            case 2:
                name = "Posición en el Grupo";
                break;
            case 3:
                name = "Grupo";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipo equipo = equipos.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = equipo.getNombre();
                break;
            case 1:
                value = equipo.getPais();
                break;
            case 2:
                value = equipo.getPos_grupo();
                break;
            case 3:
                value = equipo.getGrupo();
                break;
        }
        return value;

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    protected void fireContentsChanged() {
        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : listeners) {
            listener.tableChanged(event);
        }
    }
}
