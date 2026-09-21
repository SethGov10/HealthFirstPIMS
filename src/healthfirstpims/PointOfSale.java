/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package healthfirstpims;

/**
 *
 * @author user
 */
public class PointOfSale extends javax.swing.JFrame {
    private int userId;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PointOfSale.class.getName());

    /**
     * Creates new form PointOfSale
     */
    public PointOfSale() {
    initComponents();
    setupCart();
    loadMedicines();
}
 
    public PointOfSale(int userId) {
    initComponents();
    this.userId = userId;
    setupCart();
    loadMedicines();
}
    
private void setupCart() {

    javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel();

    model.addColumn("Medicine ID");
    model.addColumn("Medicine");
    model.addColumn("Quantity");
    model.addColumn("Price");
    model.addColumn("Subtotal");

    tblCart.setModel(model);
    lblTotal.setText("0.00");
}


private void loadMedicines() {

    javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel();

    model.addColumn("ID");
    model.addColumn("Medicine");
    model.addColumn("Type");
    model.addColumn("Price");
    model.addColumn("Available Stock");

    String sql = "SELECT medicine_id, name, medicine_type, price, quantity_in_stock "
            + "FROM medicines "
            + "WHERE quantity_in_stock > 0";

    try (
        java.sql.Connection con = DBConnection.getConnection();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery()
    ) {

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getInt("medicine_id"),
                rs.getString("name"),
                rs.getString("medicine_type"),
                rs.getBigDecimal("price"),
                rs.getInt("quantity_in_stock")
            });
        }

        tblMedicines.setModel(model);

    } catch (java.sql.SQLException e) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Could not load medicines:\n" + e.getMessage()
        );
    }
}
    private void calculateTotal() {

    double total = 0.0;

    for (int i = 0; i < tblCart.getRowCount(); i++) {
        total += Double.parseDouble(
                tblCart.getValueAt(i, 4).toString()
        );
    }

    lblTotal.setText(String.format("%.2f", total));
}
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicines = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnAddToCart = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JButton();
        btnClearCart = new javax.swing.JButton();
        btntRemoveItem = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("POINT OF SALE ");

        tblMedicines.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMedicines);

        jLabel2.setText("Quantity:");

        btnAddToCart.setText("ADD TO CART");
        btnAddToCart.addActionListener(this::btnAddToCartActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("SHOPPING CART");

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCart);

        jLabel4.setText("TOTAL: R");

        lblTotal.setText("0.00");

        btnCheckout.setText("CHECKOUT");
        btnCheckout.addActionListener(this::btnCheckoutActionPerformed);

        btnClearCart.setText("CLEAR CART");
        btnClearCart.addActionListener(this::btnClearCartActionPerformed);

        btntRemoveItem.setText("REMOVE");
        btntRemoveItem.addActionListener(this::btntRemoveItemActionPerformed);

        btnBack.setText("BACK");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddToCart)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))))
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCheckout)
                .addGap(51, 51, 51)
                .addComponent(btnClearCart)
                .addGap(56, 56, 56)
                .addComponent(btntRemoveItem)
                .addGap(49, 49, 49)
                .addComponent(btnBack)
                .addGap(286, 286, 286))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddToCart)
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btntRemoveItem)
                    .addComponent(btnClearCart)
                    .addComponent(btnCheckout))
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        int selectedRow = tblMedicines.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a medicine first."
    );
    return;
}

if (txtQuantity.getText().trim().isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please enter a quantity."
    );
    return;
}

try {

    int quantity = Integer.parseInt(txtQuantity.getText().trim());

    if (quantity <= 0) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Quantity must be greater than 0."
        );
        return;
    }

    int medicineId =
            Integer.parseInt(tblMedicines.getValueAt(selectedRow, 0).toString());

    String medicine =
            tblMedicines.getValueAt(selectedRow, 1).toString();

    double price =
            Double.parseDouble(tblMedicines.getValueAt(selectedRow, 3).toString());

    int availableStock =
            Integer.parseInt(tblMedicines.getValueAt(selectedRow, 4).toString());

    if (quantity > availableStock) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Not enough stock available."
        );
        return;
    }

    double subtotal = price * quantity;

    javax.swing.table.DefaultTableModel cartModel =
            (javax.swing.table.DefaultTableModel) tblCart.getModel();

    cartModel.addRow(new Object[]{
        medicineId,
        medicine,
        quantity,
        price,
        subtotal
    });

    calculateTotal();

    txtQuantity.setText("");

} catch (NumberFormatException e) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please enter a valid quantity."
    );
}
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btntRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntRemoveItemActionPerformed
        int selectedRow = tblCart.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select an item from the cart."
    );
    return;
}

javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) tblCart.getModel();

model.removeRow(selectedRow);

calculateTotal();
    }//GEN-LAST:event_btntRemoveItemActionPerformed

    private void btnClearCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCartActionPerformed
       javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel) tblCart.getModel();

model.setRowCount(0);

lblTotal.setText("0.00");
txtQuantity.setText("");
    }//GEN-LAST:event_btnClearCartActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CashierDashboard dashboard = new CashierDashboard();
dashboard.setVisible(true);
dashboard.setLocationRelativeTo(null);
this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        if (tblCart.getRowCount() == 0) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "The cart is empty."
    );
    return;
}

double total = Double.parseDouble(lblTotal.getText());

int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Complete sale for R" + String.format("%.2f", total) + "?",
        "Confirm Checkout",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (confirm != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

java.sql.Connection con = null;

try {

    con = DBConnection.getConnection();
    con.setAutoCommit(false);

    // Save the main sale
    String saleSql =
            "INSERT INTO sales (user_id, sale_date, total_amount) "
            + "VALUES (?, NOW(), ?)";

    java.sql.PreparedStatement salePst =
            con.prepareStatement(
                    saleSql,
                    java.sql.Statement.RETURN_GENERATED_KEYS
            );

    salePst.setInt(1, userId);
    salePst.setDouble(2, total);
    salePst.executeUpdate();

    java.sql.ResultSet keys = salePst.getGeneratedKeys();

    if (!keys.next()) {
        throw new java.sql.SQLException("Could not create sale.");
    }

    int saleId = keys.getInt(1);

    // Save each cart item
    String itemSql =
            "INSERT INTO sale_items "
            + "(sale_id, medicine_id, quantity_sold, price_at_sale) "
            + "VALUES (?, ?, ?, ?)";

    String stockSql =
            "UPDATE medicines "
            + "SET quantity_in_stock = quantity_in_stock - ? "
            + "WHERE medicine_id = ? AND quantity_in_stock >= ?";

    for (int i = 0; i < tblCart.getRowCount(); i++) {

        int medicineId =
                Integer.parseInt(tblCart.getValueAt(i, 0).toString());

        int quantity =
                Integer.parseInt(tblCart.getValueAt(i, 2).toString());

        double price =
                Double.parseDouble(tblCart.getValueAt(i, 3).toString());

        java.sql.PreparedStatement stockPst =
                con.prepareStatement(stockSql);

        stockPst.setInt(1, quantity);
        stockPst.setInt(2, medicineId);
        stockPst.setInt(3, quantity);

        int updated = stockPst.executeUpdate();

        if (updated == 0) {
            throw new java.sql.SQLException(
                    "Not enough stock for one of the medicines."
            );
        }

        java.sql.PreparedStatement itemPst =
                con.prepareStatement(itemSql);

        itemPst.setInt(1, saleId);
        itemPst.setInt(2, medicineId);
        itemPst.setInt(3, quantity);
        itemPst.setDouble(4, price);

        itemPst.executeUpdate();

        itemPst.close();
        stockPst.close();
    }
StringBuilder bill = new StringBuilder();

bill.append("        HEALTHFIRST PHARMACY\n");
bill.append("================================\n");
bill.append("Sale ID: ").append(saleId).append("\n");
bill.append("Cashier ID: ").append(userId).append("\n");
bill.append("Date: ").append(
        new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm")
                .format(new java.util.Date())
).append("\n");
bill.append("================================\n\n");

for (int i = 0; i < tblCart.getRowCount(); i++) {

    String medicine =
            tblCart.getValueAt(i, 1).toString();

    int quantity =
            Integer.parseInt(tblCart.getValueAt(i, 2).toString());

    double price =
            Double.parseDouble(tblCart.getValueAt(i, 3).toString());

    double subtotal =
            Double.parseDouble(tblCart.getValueAt(i, 4).toString());

    bill.append(medicine).append("\n");

    bill.append(quantity)
            .append(" x R")
            .append(String.format("%.2f", price))
            .append(" = R")
            .append(String.format("%.2f", subtotal))
            .append("\n\n");
}

bill.append("================================\n");
bill.append("TOTAL: R")
        .append(String.format("%.2f", total))
        .append("\n");
bill.append("================================\n");
bill.append("Thank you for your purchase!\n");
    con.commit();

    salePst.close();
    keys.close();

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Sale completed successfully!\n"
            + "Sale ID: " + saleId + "\n"
            + "Total: R" + String.format("%.2f", total)
    );
Bill billWindow = new Bill(saleId, bill.toString());
billWindow.setLocationRelativeTo(null);
billWindow.setVisible(true);
    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblCart.getModel();

    model.setRowCount(0);

    lblTotal.setText("0.00");
    txtQuantity.setText("");

    loadMedicines();

} catch (java.sql.SQLException e) {

    if (con != null) {
        try {
            con.rollback();
        } catch (java.sql.SQLException ex) {
            // Nothing else required here
        }
    }

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Checkout failed:\n" + e.getMessage()
    );

} finally {

    if (con != null) {
        try {
            con.setAutoCommit(true);
            con.close();
        } catch (java.sql.SQLException e) {
            // Connection is already being closed
        }
    }
}
    }//GEN-LAST:event_btnCheckoutActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PointOfSale().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnClearCart;
    private javax.swing.JButton btntRemoveItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblMedicines;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
