
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class main extends javax.swing.JFrame {

    Connection conn = new connection().connect();
    DbConnect c = new DbConnect();
    // DecimalFormat df = new DecimalFormat("$#.00");

    public main() throws Exception {
        initComponents();
        setResizable(false);
        populateJTable();
        display();

    }

    public void display() throws SQLException {

        ResultSet rs = null;
        String from, to, all;

        String sql = "SELECT `pickup_data`, `drop_date` FROM `pickup` ORDER BY `pickup_id` DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {
                int p = rs.getInt(1);
                int d = rs.getInt(2);
                //display in jlabel of main page
                from = String.valueOf(p);
                to = String.valueOf(d);
                int total = d - p;
                all = "Intended date - " + from + " to " + to + " total of " + total + " days!";
                jLabelDate.setText(all);
                ps.close();
            }

        } catch (Exception e) {
            System.out.println("Error retrieving from pickup table:" + e);
        }

        //return rs;
        rs.close();

    }

    public void populateJTable() throws Exception {

        // DbConnect c = new DbConnect();
        ArrayList<items> list = c.BindTable();
        String[] columnName = {"NAME", "MODEL", "PRICE/DAY($)", "IMAGE", "STATUS", "GEAR TYPE", "SEATS"};
        Object[][] rows = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            //rows[i][0] = list.get(i).getInt();
            rows[i][0] = list.get(i).getCarName();
            rows[i][1] = list.get(i).getAccessories();
            rows[i][2] = list.get(i).getPrice();
            if (list.get(i).getImage() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
                        .getScaledInstance(150, 120, Image.SCALE_SMOOTH));

                rows[i][3] = image;
            } else {
                rows[i][3] = null;
            }
            rows[i][4] = list.get(i).getStatus();
            rows[i][5] = list.get(i).getGear();
            rows[i][6] = list.get(i).getSeat();
        }

        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);

    }

    public void category1() throws Exception {

        // DbConnect c = new DbConnect();
        ArrayList<items> list = c.selectCat();
        String[] columnName = {"NAME", "MODEL", "PRICE/DAY($)", "IMAGE", "STATUS", "GEAR TYPE", "SEATS"};
        Object[][] rows = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            //rows[i][0] = list.get(i).getInt();
            rows[i][0] = list.get(i).getCarName();
            rows[i][1] = list.get(i).getAccessories();
            rows[i][2] = list.get(i).getPrice();
            if (list.get(i).getImage() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
                        .getScaledInstance(150, 120, Image.SCALE_SMOOTH));

                rows[i][3] = image;
            } else {
                rows[i][3] = null;
            }
            rows[i][4] = list.get(i).getStatus();
            rows[i][5] = list.get(i).getGear();
            rows[i][6] = list.get(i).getSeat();
        }

        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);

    }

    public void category2() throws Exception {

        // DbConnect c = new DbConnect();
        ArrayList<items> list = c.selectCat2();
        String[] columnName = {"NAME", "MODEL", "PRICE/DAY($)", "IMAGE", "STATUS", "GEAR TYPE", "SEATS"};
        Object[][] rows = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            //rows[i][0] = list.get(i).getInt();
            rows[i][0] = list.get(i).getCarName();
            rows[i][1] = list.get(i).getAccessories();
            rows[i][2] = list.get(i).getPrice();
            if (list.get(i).getImage() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
                        .getScaledInstance(150, 120, Image.SCALE_SMOOTH));

                rows[i][3] = image;
            } else {
                rows[i][3] = null;
            }
            rows[i][4] = list.get(i).getStatus();
            rows[i][5] = list.get(i).getGear();
            rows[i][6] = list.get(i).getSeat();
        }

        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTab = new javax.swing.JTabbedPane();
        jPanelMycar = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanelContact = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        busBtn = new javax.swing.JButton();
        carBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        allBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        bookBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTab.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

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
        jScrollPane.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelMycarLayout = new javax.swing.GroupLayout(jPanelMycar);
        jPanelMycar.setLayout(jPanelMycarLayout);
        jPanelMycarLayout.setHorizontalGroup(
            jPanelMycarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMycarLayout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMycarLayout.setVerticalGroup(
            jPanelMycarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
            .addGroup(jPanelMycarLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTab.addTab("HOME", jPanelMycar);

        javax.swing.GroupLayout jPanelContactLayout = new javax.swing.GroupLayout(jPanelContact);
        jPanelContact.setLayout(jPanelContactLayout);
        jPanelContactLayout.setHorizontalGroup(
            jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        jPanelContactLayout.setVerticalGroup(
            jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        jTab.addTab("CONTACT US", jPanelContact);

        busBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        busBtn.setText("SMALL CARS");
        busBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busBtnActionPerformed(evt);
            }
        });

        carBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        carBtn.setText("BIG CARS");
        carBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("CATEGORY");

        allBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        allBtn.setText("ALL CARS");
        allBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Book to see total");

        jLabel6.setText("Amount to be paid");

        btnView.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        btnView.setText("VIEW BOOKING");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(busBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(carBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(allBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(allBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(busBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(carBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(32, 12, 243));
        jLabel1.setFont(new java.awt.Font("TlwgTypewriter", 1, 48)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.activeCaption);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACE CAR RENTALS");

        jLabel3.setFont(new java.awt.Font("Tibetan Machine Uni", 1, 20)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.activeCaption);
        jLabel3.setText("MAKE YOUR CHOICE IS UP TO YOU!!!");

        jLabelDate.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabelDate.setText("date");

        bookBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        bookBtn.setText("BOOK NOW");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTab))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(268, 268, 268))
                    .addComponent(jTab, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busBtnActionPerformed
        if (evt.getSource() == busBtn) {
            try {

                category1();

            } catch (Exception ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_busBtnActionPerformed

    private void carBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carBtnActionPerformed
        if (evt.getSource() == carBtn) {
            try {

                category2();
            } catch (Exception ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_carBtnActionPerformed

    private void allBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBtnActionPerformed
        if (evt.getSource() == allBtn) {
            try {

                populateJTable();
            } catch (Exception ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_allBtnActionPerformed

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed

        if (evt.getSource() == bookBtn) {
            ResultSet rs = null;

            String from, to, all;

            String sql = "SELECT `pickup_data`, `drop_date` FROM `pickup` ORDER BY `pickup_id` DESC";
            String sql1 = "SELECT `stock_id` FROM `stock` WHERE `accessories`=?";
            String sql2 = "SELECT COUNT(*) FROM `stock`";
            String sql3 = "SELECT COUNT(*) FROM `cart`";
            if (jTable1.getSelectedRow() != -1) {

                try {
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    PreparedStatement ps3 = conn.prepareStatement(sql3);

                    ResultSet rs2 = ps2.executeQuery();
                    ResultSet rs3 = ps3.executeQuery();

                    if (rs2.next()) {
                        int countStock = rs2.getInt(1);
                        if (rs3.next()) {

                            int countCart = rs3.getInt(1);
                            if (countStock >= countCart) {

                                String name = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                                String model = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();

                                String price = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                                Double prices = Double.parseDouble(price);
                                ImageIcon image = (ImageIcon) jTable1.getValueAt(jTable1.getSelectedRow(), 3);
                                // Image img = image.getImage();

                                BufferedImage img = new BufferedImage(image.getIconWidth(), image.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                                Graphics2D g2d = img.createGraphics();

                                g2d.dispose();

                                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                                    ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
                                    try {
                                        ImageIO.write(img, "jpeg", ios);
                                        // Set a flag to indicate that the write was successful
                                    } finally {
                                        ios.close();
                                    }
                                    byte[] bytes = baos.toByteArray();
                                    try {
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        PreparedStatement p1 = conn.prepareStatement(sql1);
                                        p1.setString(1, model);
                                        ResultSet r = p1.executeQuery();
                                        rs = ps.executeQuery();

                                        if (rs.next()) {
                                            if (r.next()) {
                                                int stock = r.getInt(1);
                                                int p = rs.getInt(1);
                                                int d = rs.getInt(2);

                                                DbConnect con = new DbConnect();
                                                con.addToCart(name, model, prices, bytes, p, d, stock);
                                                //new cart().dispose();

                                            }
                                            r.close();

                                        }

                                        rs.close();

                                    } catch (Exception e) {
                                        System.out.println("Error retrieving from pickup table:" + e);
                                    }

                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry all our cars are booked!!");

                            }
                        }
                        rs3.close();

                    } else {
                        System.out.println("could not retrieve from Stock table!");
                        
                    }
                    rs2.close();

                } catch (SQLException ex) {
                    System.out.println("could not retrieve from cart and stock!" + ex);
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "You have not selected item!!");
            }
        }

    }//GEN-LAST:event_bookBtnActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        try {

            new cart().show();
            dispose();

        } catch (Exception ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewActionPerformed

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
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main().setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(main.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allBtn;
    private javax.swing.JButton bookBtn;
    private javax.swing.JButton btnView;
    private javax.swing.JButton busBtn;
    private javax.swing.JButton carBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelMycar;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTabbedPane jTab;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
