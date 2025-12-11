package view;

import bean.Produtos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Controla os dados da tabela de consulta de produtos
 */
public class ControllerProdutos extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public Produtos getBean(int rowIndex) {
        return (Produtos) lista.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // ID, Nome, Valor, Grupo
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produtos produto = (Produtos) lista.get(rowIndex);
        
        if (columnIndex == 0) return produto.getIdprodutos();
        if (columnIndex == 1) return produto.getNome();
        if (columnIndex == 2) return produto.getValorUnitario();
        if (columnIndex == 3) return produto.getGrupo();
        
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "ID";
        if (column == 1) return "Nome";
        if (column == 2) return "Valor Unit.";
        if (column == 3) return "Grupo";
        return "";
    }
}