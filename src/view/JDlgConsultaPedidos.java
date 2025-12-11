/*
 * JDlgConsultaPedidos.java
 * Consulta de Vendas com PDF
 */
package view;

import dao.PedidosDao;
import bean.Pedidos; // Certifica-te que tens este Bean
import java.util.List;
import javax.swing.JOptionPane;

public class JDlgConsultaPedidos extends javax.swing.JDialog {

    private ControllerPedidos controllerPedidos;
    private PedidosDao pedidosDao;

    public JDlgConsultaPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Consulta de Vendas");

        // 1. Busca os dados
        pedidosDao = new PedidosDao();
        List lista = pedidosDao.listAll();
        
        // 2. Configura o Controller
        controllerPedidos = new ControllerPedidos();
        controllerPedidos.setList(lista);
        
        // 3. Liga na tabela
        jTable1.setModel(controllerPedidos);
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

        // Painel Topo
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setText("Consulta de Vendas");
        jPanel1.add(jLabel1);

        // Tabela
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jScrollPane1.setViewportView(jTable1);

        // Botões
        jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); 
        jBtnOk.setText("Fechar");
        jBtnOk.addActionListener(evt -> jBtnOkActionPerformed(evt));

        jBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); 
        jBtnImprimir.setText("Imprimir / PDF");
        jBtnImprimir.addActionListener(evt -> jBtnImprimirActionPerformed(evt));

        // Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnOk)
                    .addComponent(jBtnImprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {                                       
        this.dispose();
    }                                      

    // Lógica para gerar PDF da tabela de Vendas
    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            boolean completo = jTable1.print(javax.swing.JTable.PrintMode.FIT_WIDTH, 
                    new java.text.MessageFormat("Relatório de Vendas"), 
                    new java.text.MessageFormat("Página {0}"));
            
            if (completo) {
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
            }
        } catch (java.awt.print.PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Erro na impressão: " + ex.getMessage());
        }
    } 

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JDlgConsultaPedidos(new javax.swing.JFrame(), true).setVisible(true));
    }

    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}