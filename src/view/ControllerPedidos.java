/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Pedidos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerPedidos extends AbstractTableModel {

    private List lstPedidos;

    public void setList(List lstPedidos) {
        this.lstPedidos = lstPedidos;
    }
    
    public Pedidos getBean(int rowIndex) {
        return (Pedidos) lstPedidos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstPedidos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedidos pedidos = (Pedidos) lstPedidos.get( rowIndex);
        if ( columnIndex == 0 ){
            return pedidos.getIdpedidos();
        } else if (columnIndex ==1) {
            return pedidos.getData();        
        } else if (columnIndex ==2) {
            return pedidos.getTotal();
        } else if (columnIndex ==3) {
            return pedidos.getClientes() .getNome();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Data";         
        } else if ( columnIndex == 2) {
            return "Total";
        } else if ( columnIndex == 3) {
            return "Ciente";
        } 
        return "";
    }
}
