package view;

import bean.Clientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Controla os dados da tabela de consulta de clientes
 */
public class ControllerClientes extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged(); // Atualiza a tabela visualmente
    }

    public Clientes getBean(int rowIndex) {
        return (Clientes) lista.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // ID, Nome, CPF, RG
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clientes cliente = (Clientes) lista.get(rowIndex);
        
        if (columnIndex == 0) return cliente.getIdclientes();
        if (columnIndex == 1) return cliente.getNome();
        if (columnIndex == 2) return cliente.getCpf();
        if (columnIndex == 3) return cliente.getRg(); // Usando RG que existe no seu bean
        
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "ID";
        if (column == 1) return "Nome";
        if (column == 2) return "CPF";
        if (column == 3) return "RG";
        return "";
    }
}