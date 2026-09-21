/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package healthfirstpims;

/**
 *
 * @author user
 */
public class Bill extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Bill.class.getName());

    /**
     * Creates new form Bill
     */
    public Bill() {
        initComponents();
    }

   public Bill(int saleId, String billText) {
    initComponents();
    txtBill.setText(billText);
    txtBill.setCaretPosition(0);
    setTitle("HealthFirst Pharmacy - Bill #" + saleId);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBill = new javax.swing.JTextArea();
        btnPrint = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(167, 255, 164));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 139, 136));
        jLabel1.setText("CUSTOMER BILL");

        txtBill.setEditable(false);
        txtBill.setColumns(20);
        txtBill.setRows(5);
        jScrollPane1.setViewportView(txtBill);

        btnPrint.setForeground(new java.awt.Color(0, 137, 133));
        btnPrint.setText("PRINT");
        btnPrint.addActionListener(this::btnPrintActionPerformed);

        btnSave.setForeground(new java.awt.Color(0, 135, 132));
        btnSave.setText("SAVE");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnClose.setForeground(new java.awt.Color(0, 133, 133));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(this::btnCloseActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnPrint)
                        .addGap(86, 86, 86)
                        .addComponent(btnSave)
                        .addGap(94, 94, 94)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(161, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrint)
                            .addComponent(btnSave)
                            .addComponent(btnClose))
                        .addGap(102, 102, 102))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
    boolean printed = txtBill.print();

    if (printed) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Bill sent to printer successfully."
        );
    }

} catch (java.awt.print.PrinterException e) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Could not print bill:\n" + e.getMessage()
    );
}
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();

chooser.setDialogTitle("Save Customer Bill");
chooser.setSelectedFile(new java.io.File("HealthFirst_Bill.txt"));

int result = chooser.showSaveDialog(this);

if (result == javax.swing.JFileChooser.APPROVE_OPTION) {

    java.io.File file = chooser.getSelectedFile();

    try (java.io.FileWriter writer = new java.io.FileWriter(file)) {

        writer.write(txtBill.getText());

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Bill saved successfully."
        );

    } catch (java.io.IOException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Could not save bill:\n" + e.getMessage()
        );
    }
}
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

   
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Bill().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtBill;
    // End of variables declaration//GEN-END:variables
}
