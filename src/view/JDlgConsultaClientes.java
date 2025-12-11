/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import dao.ClientesDao;
import bean.Clientes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDlgConsultaClientes extends javax.swing.JDialog {

    // Declaração dos objetos de controle
    private ControllerClientes controllerClientes;
    private ClientesDao clientesDao;

    // Construtor
    public JDlgConsultaClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); // Inicia o desenho da tela
        setLocationRelativeTo(null); // Centraliza
        setTitle("Consulta de Clientes"); // Título da janela

        // 1. Busca os dados do banco de dados
        clientesDao = new ClientesDao();
        List lista = (List) clientesDao.listAll();
        
        // 2. Configura o Controller com a lista recebida
        controllerClientes = new ControllerClientes();
        controllerClientes.setList(lista);
        
        // 3. Liga o controller na tabela visual
        jTable1.setModel(controllerClientes);
    }

    // --- MÉTODOS DE EVENTOS (AÇÕES DOS BOTÕES) ---

    // Botão Fechar
    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {                                       
        this.dispose(); // Fecha a janela
    }                                      

    // Botão Imprimir / PDF (PONTO EXTRA)
    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            // Comando nativo do Java Swing para imprimir JTable
            // Abre a janela de impressão do sistema operacional.
            // O usuário deve selecionar "Microsoft Print to PDF" ou "Salvar como PDF".
            boolean completo = jTable1.print(javax.swing.JTable.PrintMode.FIT_WIDTH, 
                    new java.text.MessageFormat("Relatório de Clientes"), 
                    new java.text.MessageFormat("Página {0}"));
            
            if (completo) {
                JOptionPane.showMessageDialog(null, "Documento gerado/impresso com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Ação cancelada.");
            }
        } catch (java.awt.print.PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + ex.getMessage());
        }
    }

    // --- DESENHO DA TELA (INITCOMPONENTS) ---
    // Este código cria os painéis, botões e tabelas automaticamente.
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnOk = new javax.swing.JButton();
        jBtnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // --- Configuração do Topo (Título) ---
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setText("Consulta de Clientes");
        jPanel1.add(jLabel1);

        // --- Configuração da Tabela ---
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jScrollPane1.setViewportView(jTable1);

        // --- Configuração do Botão Fechar ---
        jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); 
        jBtnOk.setText("Fechar");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        // --- Configuração do Botão Imprimir ---
        jBtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); 
        jBtnImprimir.setText("Imprimir / PDF");
        jBtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImprimirActionPerformed(evt);
            }
        });

        // --- Layout (Posicionamento) ---
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

    /**
     * Método Main para teste individual da tela
     */
    public static void main(String args[]) {
        /* Configuração Visual (Look and Feel) */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgConsultaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Cria e exibe o diálogo */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgConsultaClientes dialog = new JDlgConsultaClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Declaração de variáveis visuais
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}