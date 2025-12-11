/*
 * JDlgConsultaProdutos.java
 */
package view;

import dao.ProdutosDao;
import bean.Produtos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDlgConsultaProdutos extends javax.swing.JDialog {

    private ControllerProdutos controllerProdutos;
    private ProdutosDao produtosDao;

    public JDlgConsultaProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Consulta de Produtos");

        // 1. Busca dados
        produtosDao = new ProdutosDao();
        List lista = produtosDao.listAll();
        
        // 2. Configura Controller
        controllerProdutos = new ControllerProdutos();
        controllerProdutos.setList(lista);
        

        jTable1.setModel(controllerProdutos);
    }

   
    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            boolean completo = jTable1.print(javax.swing.JTable.PrintMode.FIT_WIDTH, 
                    new java.text.MessageFormat("Relatório de Produtos"), 
                    new java.text.MessageFormat("Página {0}"));
            
            if (completo) {
                JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
            }
        } catch (java.awt.print.PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + ex.getMessage());
        }
    } 

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {                                       
        this.dispose();
    }

    // --- DESIGN AUTOMÁTICO ---
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnOk = new javax.swing.JButton();
        jBtnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Painel de Título
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.Bevel