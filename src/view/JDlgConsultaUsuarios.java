/*
 * JDlgConsultaUsuarios.java
 */
package view;

import dao.UsuariosDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDlgConsultaUsuarios extends javax.swing.JDialog {

    // Declaração do Controller que você já tem
    private ControllerUsuarios controllerUsuarios;
    private UsuariosDao usuariosDao;

    public JDlgConsultaUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Consulta de Usuários");

        // 1. Busca os dados usando o DAO de Usuários
        usuariosDao = new UsuariosDao();
        List lista = (List) usuariosDao.listAll(); // Cast para List se necessário
        
        // 2. Configura o Controller que você me mandou
        controllerUsuarios = new ControllerUsuarios();
        controllerUsuarios.setList(lista);
        
        // 3. Liga na tabela visual
        jTable1.setModel(controllerUsuarios);
    }

    // --- AÇÃO DO BOTÃO IMPRIMIR (PONTO EXTRA) ---
    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            boolean completo = jTable1.print(javax.swing.JTable.PrintMode.FIT_WIDTH, 
                    new java.text.MessageFormat("Relatório de Usuários"), 
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

    // --- DESIGN AUTOMÁTICO (Não precisa desenhar nada) ---
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnOk = new javax.swing.JButton();
        jBtnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Topo
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setText("Consulta de Usuários");
        jPanel1.add(jLabel1);

        // Tabela
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jScrollPane1.setViewportView(jTable1);

        // Botão Fechar
        jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); 
        jBtnOk.setText("Fechar");
        jBtnOk.addActionListener(evt -> jBtnOkActionPerformed(evt));

        // Botão Imprimir
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JDlgConsultaUsuarios(new javax.swing.JFrame(), true).setVisible(true));
    }

    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}