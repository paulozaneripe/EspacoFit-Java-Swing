/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Rafael
 */
public class TelaCadastroCompra extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCompra
     */
    public TelaCadastroCompra() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDados = new javax.swing.JPanel();
        jPanelBotoes = new javax.swing.JPanel();
        jBotaoNovo = new javax.swing.JButton();
        jBotaoCancelar = new javax.swing.JButton();
        jBotaoGravar = new javax.swing.JButton();
        jBotaoBuscar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelFornecedor = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jLabelValor = new javax.swing.JLabel();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField();
        jLabelDesconto = new javax.swing.JLabel();
        jFormattedTextFieldDesconto = new javax.swing.JFormattedTextField();
        jLabelData = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário de Cadastro de Compra");
        setResizable(false);

        jPanelTitulo.setBackground(new java.awt.Color(201, 117, 6));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(533, 75));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Compra");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelTitulo, java.awt.BorderLayout.NORTH);

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBotoes.setPreferredSize(new java.awt.Dimension(533, 75));

        jBotaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bullet_page_white.png"))); // NOI18N
        jBotaoNovo.setText("Novo");
        jBotaoNovo.setMaximumSize(new java.awt.Dimension(72, 26));
        jBotaoNovo.setMinimumSize(new java.awt.Dimension(72, 26));
        jBotaoNovo.setPreferredSize(new java.awt.Dimension(96, 26));
        jBotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoNovoActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jBotaoNovo);

        jBotaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bullet_cross.png"))); // NOI18N
        jBotaoCancelar.setText("Cancelar");
        jBotaoCancelar.setEnabled(false);
        jBotaoCancelar.setMaximumSize(new java.awt.Dimension(72, 26));
        jBotaoCancelar.setMinimumSize(new java.awt.Dimension(72, 26));
        jBotaoCancelar.setPreferredSize(new java.awt.Dimension(110, 26));
        jBotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoCancelarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jBotaoCancelar);

        jBotaoGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk_black.png"))); // NOI18N
        jBotaoGravar.setText("Gravar");
        jBotaoGravar.setEnabled(false);
        jBotaoGravar.setMaximumSize(new java.awt.Dimension(72, 26));
        jBotaoGravar.setMinimumSize(new java.awt.Dimension(72, 26));
        jBotaoGravar.setPreferredSize(new java.awt.Dimension(96, 26));
        jBotaoGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoGravarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jBotaoGravar);

        jBotaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bullet_magnify.png"))); // NOI18N
        jBotaoBuscar.setText("Buscar");
        jBotaoBuscar.setMaximumSize(new java.awt.Dimension(72, 26));
        jBotaoBuscar.setMinimumSize(new java.awt.Dimension(72, 26));
        jBotaoBuscar.setPreferredSize(new java.awt.Dimension(96, 26));
        jBotaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoBuscarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jBotaoBuscar);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/control_power.png"))); // NOI18N
        jButton5.setText("Sair");
        jButton5.setMaximumSize(new java.awt.Dimension(72, 26));
        jButton5.setMinimumSize(new java.awt.Dimension(72, 26));
        jButton5.setPreferredSize(new java.awt.Dimension(96, 26));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButton5);

        jLabelID.setText("ID");

        jLabelFornecedor.setText("Fornecedor");

        jLabelValor.setText("Valor");

        jFormattedTextFieldValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLabelDesconto.setText("Desconto");

        jFormattedTextFieldDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLabelData.setText("Data");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldData.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelFornecedor)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jComboBoxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelValor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDesconto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelData)
                            .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jLabelFornecedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValor)
                    .addComponent(jLabelDesconto)
                    .addComponent(jLabelData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanelDados, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBotaoNovoActionPerformed

    private void jBotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBotaoCancelarActionPerformed

    private void jBotaoGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoGravarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBotaoGravarActionPerformed

    private void jBotaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBotaoBuscarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotaoBuscar;
    private javax.swing.JButton jBotaoCancelar;
    private javax.swing.JButton jBotaoGravar;
    private javax.swing.JButton jBotaoNovo;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JFormattedTextField jFormattedTextFieldDesconto;
    private javax.swing.JFormattedTextField jFormattedTextFieldValor;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDesconto;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
