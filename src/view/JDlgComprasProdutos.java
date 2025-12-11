/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProdutosDao;
import bean.Produtos;
import bean.PedidosProdutos; 
import tools.Util;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author paulo
 */
public class JDlgComprasProdutos extends javax.swing.JDialog {

    private JDlgCompras telaAnterior; // Referência à tela principal

    public JDlgComprasProdutos(java.awt.Frame parent, boolean modal, JDlgCompras tela) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        telaAnterior = tela;

        carregarProdutos(); // Carrega produtos no jCboProdutos
        configurarListeners(); // Configura cálculo automático

        // O campo total é apenas leitura, calculado automaticamente
        jTxtTotalItem.setEnabled(false);
    }

    // Construtor vazio apenas para testes visuais (usado pelo main)
    public JDlgComprasProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        carregarProdutos();
        configurarListeners();
    }

    private void carregarProdutos() {
        ProdutosDao produtosDao = new ProdutosDao();
        List<Produtos> lista = (List<Produtos>) produtosDao.listAll();
        
        jCboProdutos.removeAllItems();
        for (Produtos p : lista) {
            jCboProdutos.addItem(p);
        }
    }

    private void configurarListeners() {
        // Quando muda o produto no combo, pega o preço dele
        jCboProdutos.addActionListener(e -> {
            Produtos p = (Produtos) jCboProdutos.getSelectedItem();
            if (p != null) {
                // Preenche o valor unitário com o preço do cadastro
                jTxtValorUnitario.setText(Util.doubleToStr(p.getValorUnitario()));
                calcularTotal();
            }
        });

        // Listener para os campos de Quantidade e Valor Unitário calcularem ao digitar
        DocumentListener listener = new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { calcularTotal(); }
            @Override public void removeUpdate(DocumentEvent e) { calcularTotal(); }
            @Override public void changedUpdate(DocumentEvent e) { calcularTotal(); }
        };
        jTxtQuantidade.getDocument().addDocumentListener(listener);
        jTxtValorUnitario.getDocument().addDocumentListener(listener);
    }

    private void calcularTotal() {
        try {
            double qtd = Util.strToDouble(jTxtQuantidade.getText());
            double valor = Util.strToDouble(jTxtValorUnitario.getText());
            double total = qtd * valor;
            
            jTxtTotalItem.setText(Util.doubleToStr(total));
        } catch (Exception e) {
            jTxtTotalItem.setText("0.00");
        }
    }

    // Converte dados da tela para o Bean
    public PedidosProdutos viewBean() {
        PedidosProdutos item = new PedidosProdutos();

        // Verifica se o item selecionado é válido
        Object selecionado = jCboProdutos.getSelectedItem();
        if (selecionado instanceof Produtos) {
             item.setProdutos((Produtos) selecionado);
        }
       
        item.setQuantidade(Util.strToInt(jTxtQuantidade.getText()));
        item.setValorUnitario(Util.strToDouble(jTxtValorUnitario.getText()));
        
        return item;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCboProdutos = new javax.swing.JComboBox<Produtos>();
        jLabel2 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTxtTotalItem = new javax.swing.JFormattedTextField();
        jTxtValorUnitario = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Produtos");

        // O action listener foi movido para configurarListeners() para evitar duplicidade

        jLabel2.setText("Quantidade");

        jLabel3.setText("Valor Unitario");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("OK");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel4.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jTxtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtValorUnitario))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jCboProdutosActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Listener já configurado em configurarListeners()
    }                                            

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Botão OK (Confirma o item e manda para a tela de Compras)
        PedidosProdutos item = viewBean();
        if (item.getProdutos() != null) {
            // Verifica se a tela anterior existe (não é nula) antes de chamar o método
            if (telaAnterior != null) {
                telaAnterior.adicionarProduto(item);
            }
            setVisible(false);
        } else {
            Util.mensagem("Selecione um produto.");
        }
    }                                           

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Código para alterar se necessário
    }                                           

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Código para excluir se necessário
    }                                           

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        jBtnIncluirActionPerformed(evt); // Reutiliza a lógica do botão OK
    }                                             

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        setVisible(false);
    }                                            

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // Código de pesquisa se necessário
    }                                             

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(JDlgComprasProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Abre em modo de teste
                JDlgComprasProdutos dialog = new JDlgComprasProdutos(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<Produtos> jCboProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTxtQuantidade;
    private javax.swing.JFormattedTextField jTxtTotalItem;
    private javax.swing.JFormattedTextField jTxtValorUnitario;
    // End of variables declaration                   
}