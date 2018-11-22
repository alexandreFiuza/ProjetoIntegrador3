/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author arthu
 */
public class TelaAdmPrincipal extends javax.swing.JInternalFrame {

    JDesktopPane jDesktopPrincipal = new JDesktopPane();

    public TelaAdmPrincipal() {
        initComponents();
    }

    TelaAdmPrincipal(JDesktopPane jDesktopPrincipal) {
        this();
        this.jDesktopPrincipal = jDesktopPrincipal;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAgencia = new javax.swing.JButton();
        jButtonConta1 = new javax.swing.JButton();

        setTitle("AgenciaPI3 - Administração");

        jButtonAgencia.setText("AGENCIA");
        jButtonAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgenciaActionPerformed(evt);
            }
        });

        jButtonConta1.setText("CONTA");
        jButtonConta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConta1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButtonAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButtonConta1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgenciaActionPerformed

        try {

            TelaAgencia telaAgencia = new TelaAgencia(jDesktopPrincipal);
            jDesktopPrincipal.add(telaAgencia);
            telaAgencia.setLocation(20, 15);
            telaAgencia.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButtonAgenciaActionPerformed

    private void jButtonConta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConta1ActionPerformed
        // TODO add your handling code here:
        try {

            TelaConta telaConta = new TelaConta(jDesktopPrincipal);
            jDesktopPrincipal.add(telaConta);
            telaConta.setLocation(20, 15);
            telaConta.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_jButtonConta1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgencia;
    private javax.swing.JButton jButtonConta1;
    // End of variables declaration//GEN-END:variables
}
