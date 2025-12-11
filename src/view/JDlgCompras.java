/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.VendedorDao;
import dao.ClientesDao;
import dao.ProdutosDao;
import bean.Vendedor;
import bean.Clientes;
import bean.PedidosProdutos;
import bean.Produtos;
import tools.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class JDlgCompras extends javax.swing.JDialog {

    private boolean incluir;
    private ProdutosDao comprasDao;
    private Produtos compra;
    private List<PedidosProdutos> listaProdutos; // Itens da compra
    private ControllerComprasProdutos pedidosProdutosTableModel;

    public JDlgCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        // Inicialização de DAOs, Lista e Tabela
        comprasDao = new ProdutosDao();
        listaProdutos = new ArrayList<>();
        pedidosProdutosTableModel = new ControllerComprasProdutos(listaProdutos);
        jTable1.setModel(pedidosProdutosTableModel);

        // Configurações Iniciais dos Botões
        // Desabilita campos e botões de produtos no início
        Util.habilitar(false, jTxtCodigo, jTxtTotal, jCboClientes, jCboFornecedor,
                jBtnConfirmar, jBtnCancelar,
                jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd); // Botões de produto desabilitados
        
        // Habilita botões principais
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar);

        carregarCombos();
    }

    private void carregarCombos() {
        VendedorDao fornecedoresDao = new VendedorDao();
        List listaF = (List) fornecedoresDao.listAll();
        jCboFornecedor.removeAllItems();
        for (Object object : listaF) {
            jCboFornecedor.addItem((Vendedor) object);
        }
        
        ClientesDao compradorDao = new ClientesDao();
        List listaC = (List) compradorDao.listAll();
        jCboClientes.removeAllItems();
        for (Object object : listaC) {
            jCboClientes.addItem((Clientes) object);
        }
    }

    // Converte dados da tela para o Bean Produtos
    // Converte dados da tela para o Bean Produtos
    public Produtos viewBean() {
        if (compra == null) {
            compra = new Produtos();
        }
        
        // Proteção para não dar erro se o código estiver vazio
        if (!jTxtCodigo.getText().trim().isEmpty()) {
            // CORREÇÃO AQUI: O método no seu bean é setIdprodutos
            compra.setIdprodutos(Util.strToInt(jTxtCodigo.getText()));
        }

        compra.setFornecedor((Vendedor) jCboFornecedor.getSelectedItem());
        compra.setClientes((Clientes) jCboClientes.getSelectedItem());
        compra.setTotal(Util.strToDouble(jTxtTotal.getText()));

        // Cria o HashSet novo para evitar erro de conversão
        compra.setPedidosProdutos(new java.util.HashSet<>(listaProdutos));

        return compra;
    }
    // Método chamado pelo JDlgPedidosProdutos para adicionar um item.
    public void adicionarProduto(PedidosProdutos cp) {
        listaProdutos.add(cp);
        pedidosProdutosTableModel.setList(listaProdutos); // Atualiza a JTable
        recalcularTotalCompra(); // Atualiza o campo total
    }

    private void recalcularTotalCompra() {
        double total = 0.0;
        for (PedidosProdutos cp : listaProdutos) {
            total += cp.getTotal(); // Certifique-se que PedidosProdutos tem getTotal() ou calcule (qtd * valor)
        }
        jTxtTotal.setText(Util.doubleToStr(total));

        if (compra != null) {
            compra.setTotal(total);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCboClientes = new javax.swing.JComboBox<Clientes>();
        jCboFornecedor = new javax.swing.JComboBox<Vendedor>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtTotal = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jBtnIncluirProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Comprador");

        jCboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClientesActionPerformed(evt);
            }
        });

        jCboFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboFornecedorActionPerformed(evt);
            }
        });

        jLabel2.setText("Fornecedor");

        jLabel3.setText("Valor total");

        jTxtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTotalActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
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

        jLabel4.setText("Codigo");

        jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterarProd.setText("Alterar");
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png"))); // NOI18N
        jBtnExcluirProd.setText("Excluir");
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnIncluirProd.setText("Incluir");
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBtnIncluirProd)
                                .addComponent(jBtnAlterarProd))
                            .addComponent(jBtnExcluirProd))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTxtTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(31, 31, 31))
                                        .addComponent(jCboFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(32, 32, 32)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(191, 191, 191))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnIncluir)
                            .addComponent(jBtnAlterar)
                            .addComponent(jBtnExcluir)
                            .addComponent(jBtnConfirmar)
                            .addComponent(jBtnCancelar)
                            .addComponent(jBtnPesquisar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAlterarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnExcluirProd)))
                .addGap(0, 90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClientesActionPerformed

    private void jCboFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboFornecedorActionPerformed

    private void jTxtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTotalActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
       Util.habilitar(true, jTxtCodigo, jTxtTotal, jCboClientes, jCboFornecedor, 
                jBtnConfirmar, jBtnCancelar,
                jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
        
        // Desabilita botões principais
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnPesquisar, jBtnExcluir);

        Util.limpar(jTxtTotal, jTxtCodigo);

        incluir = true;
        compra = new Produtos();
        listaProdutos.clear();
        pedidosProdutosTableModel.setList(listaProdutos);
        jTxtTotal.setText("0.00");
        
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
       // TODO: Implementar lógica de busca/alteração se necessário
        Util.habilitar(true, jTxtCodigo, jTxtTotal, jCboClientes, jCboFornecedor, 
                jBtnConfirmar, jBtnCancelar,
                jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnPesquisar, jBtnExcluir);
        incluir = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        //        if (Util.perguntar("Deseja Excluir?") == true) {
        //            UsuariosDao usuariosDao = new UsuariosDao();
        //            usuariosDao.delete(viewBean());
        //        }
        //        Util.limpar(jTxtCodigo, jTxtNome, jTxtApelido,
        //            jFmtCpf, jFmtDataDeNascimento, jPwfSenha,
        //            jCboNivel, jChbAtivo);
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        compra = viewBean();

        try {
            if (incluir) {
                comprasDao.insert(compra);
            } else {
                comprasDao.update(compra);
            }
            Util.mensagem("Compra salva com sucesso!");

            // Desabilita campos após a confirmação
            Util.habilitar(false, jTxtCodigo, jTxtTotal, jCboClientes, jCboFornecedor,
                    jBtnConfirmar, jBtnCancelar,
                    jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
            
            Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar, jBtnExcluir);

            Util.limpar(jTxtCodigo, jTxtTotal);
            listaProdutos.clear();
            pedidosProdutosTableModel.setList(listaProdutos);

        } catch (Exception e) {
            e.printStackTrace(); // Ajuda a ver o erro no console
            JOptionPane.showMessageDialog(this, "Erro ao salvar compra: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
      // Cancela e bloqueia tudo novamente
        Util.habilitar(false, jTxtCodigo, jTxtTotal, jCboClientes, jCboFornecedor,
                jBtnConfirmar, jBtnCancelar,
                jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
        
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar, jBtnExcluir);
        
        Util.limpar(jTxtCodigo, jTxtTotal);
        listaProdutos.clear();
        pedidosProdutosTableModel.setList(listaProdutos);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        //        JDlgUsuariosPesquisar jDlgUsuariosPesquisar = new JDlgUsuariosPesquisar(null, true);
        //        jDlgUsuariosPesquisar.setTelaAnterior(this);
        //        jDlgUsuariosPesquisar.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
int linha = jTable1.getSelectedRow();
        if (linha != -1) {
            JDlgComprasProdutos telaProdutos = new JDlgComprasProdutos(null, true, this);
            
            // Pega o produto selecionado na lista
            // TODO: Criar método setBean em JDlgComprasProdutos para carregar os dados
            // PedidosProdutos produtoSelecionado = listaProdutos.get(linha);
            // telaProdutos.setBean(produtoSelecionado); 
            
            telaProdutos.setVisible(true);
        } else {
            Util.mensagem("Selecione um produto para alterar.");
        }
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
   int linha = jTable1.getSelectedRow();
        if (linha != -1) {
            if (Util.perguntar("Deseja remover este produto da compra?")) {
                listaProdutos.remove(linha);
                pedidosProdutosTableModel.setList(listaProdutos); // Atualiza a tabela
                recalcularTotalCompra(); // Atualiza o total
            }
        } else {
            Util.mensagem("Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
                                               
    // Cria a tela de produtos passando 'this' (a tela atual) como pai
    JDlgComprasProdutos telaProdutos = new JDlgComprasProdutos(null, true, this);
        telaProdutos.setVisible(true);
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // CORREÇÃO: Abre JDlgCompras
                JDlgCompras dialog = new JDlgCompras(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<bean.Clientes> jCboClientes;
    private javax.swing.JComboBox<bean.Vendedor> jCboFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JFormattedTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables

}
