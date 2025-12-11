package view;

import bean.PedidosProdutos; // Ou ComprasProdutos, dependendo do que você decidiu usar
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerComprasProdutos extends AbstractTableModel {
    private List<PedidosProdutos> lista;

    public ControllerComprasProdutos(List<PedidosProdutos> lista) {
        this.lista = lista;
    }

    // Atualiza a lista caso adicione/remova algo
    public void setList(List<PedidosProdutos> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Produto, Qtd, Valor Unit, Total
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PedidosProdutos item = lista.get(rowIndex);
        if (columnIndex == 0) return item.getProdutos(); // Supõe que tenha toString no Produto
        if (columnIndex == 1) return item.getQuantidade();
        if (columnIndex == 2) return item.getValorUnitario();
        if (columnIndex == 3) return item.getQuantidade() * item.getValorUnitario(); // Total
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "Produto";
        if (column == 1) return "Qtd";
        if (column == 2) return "Valor Unit.";
        if (column == 3) return "Total";
        return "";
    }
}