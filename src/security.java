
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class security extends javax.swing.JFrame {

    protected Statement st = null;
    protected Resultset rs = null;
    //  st = con.createStatement();
    Connection con = new connection().connect();

    int count = 0;
    int scount = 1;

    public security() {
        initComponents();
    }

    public void all() throws Exception {
        try {
            DbConnect c = new DbConnect();
            ArrayList<items> list = c.stock();
            for (int i = 0; i < list.size(); i++) {
             String arr=list.get(i).toString();
             String q=arr.trim();
            int m =Integer.parseInt(q);
                c.DeleteAllCart(m);
                System.out.println("stock items deleted");
                }
            
        } catch (Exception e) {
            System.out.println("problem delete from stock" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jtScode = new javax.swing.JPasswordField();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter 3 digit security code");

        btnSubmit.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jtScode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtScodeActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtScode, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtScode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (evt.getSource() == btnSubmit) {
            String sec = jtScode.getText();
            int code = Integer.parseInt(sec);

            try {
                st = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(security.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs = null;
            String sql = "SELECT `security_code` FROM `user` WHERE security_code=?";
            if (scount != 3) {
                try {
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setInt(1, code);
                    ResultSet r = p.executeQuery();

                    if (r.next()) {
                        post mm = new post();
                        mm.show();
                        DbConnect c = new DbConnect();
                        c.Clear();
                        all();

                    } else if (scount == 1) {
                        JOptionPane.showMessageDialog(null, "Incorrect security code you have 2 more attempts");
                        scount++;
                    } else if (scount == 2) {
                        JOptionPane.showMessageDialog(null, "Incorrect security code you have 1 more attempts");
                        scount++;
                    }
                    r.close();
                    p.close();
                } catch (Exception e) {
                    System.out.println("could not retrieve from user in security code:" + e);
                }
            } else {

                JOptionPane.showMessageDialog(null, "You entered wrong card number 3 times restart the App!");
                System.exit(0);
            }

        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jtScodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtScodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtScodeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try {
            // TODO add your handling code here:
            new cart().show();
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(security.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new security().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jtScode;
    // End of variables declaration//GEN-END:variables
}
