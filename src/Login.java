
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    protected Statement st = null;
    protected Resultset rs = null;
    //  st = con.createStatement();
    Connection con = new connection().connect();

    int count = 0;
    int scount = 0;

    public Login() {
        initComponents();
    }

    //system code begins
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBtnLogin = new javax.swing.JButton();
        jBtnRegister = new javax.swing.JButton();
        jBtnForgot = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextEmail1 = new javax.swing.JTextField();
        jTextPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("TlwgTypewriter", 1, 20)); // NOI18N
        jLabel1.setText("ENTER PASSWORD:");

        jLabel2.setFont(new java.awt.Font("TlwgTypewriter", 1, 20)); // NOI18N
        jLabel2.setText("ENTER EMAIL:");

        jBtnLogin.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        jBtnLogin.setText("LOGIN");
        jBtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLoginActionPerformed(evt);
            }
        });

        jBtnRegister.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        jBtnRegister.setText("REGISTER");
        jBtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegisterActionPerformed(evt);
            }
        });

        jBtnForgot.setFont(new java.awt.Font("TlwgTypewriter", 1, 15)); // NOI18N
        jBtnForgot.setText("FORGOT PASSWORD");
        jBtnForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnForgotActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("TlwgTypewriter", 1, 48)); // NOI18N
        jLabel3.setText("LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jBtnForgot))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextPass, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnLogin)
                    .addComponent(jBtnRegister)
                    .addComponent(jBtnForgot, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// system codes ends.
    private void jBtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLoginActionPerformed

        String email = jTextEmail1.getText();
        String pass = jTextPass.getText();
        if (evt.getSource() == jBtnLogin) {
            if (count != 3) {
                try {
                    st = con.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet rs = null;
                String sql = "SELECT `email`,`password` FROM `user` WHERE email=? AND password=?";

                try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, email);
                    ps.setString(2, pass);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                       
                        new security().show();
                        dispose();
                  
                        /*
                try {
                    DbConnect con = new DbConnect();
                    con.login(email, pass);
                    count++;
                    //Login l=new Login();
                    dispose();
                    
                } catch (Exception ex) {
                    System.out.println("could not at connect in login"+ex);
                }
                         */
                    } else {
                        JOptionPane.showMessageDialog(null, "invalid email or password");
                        count++;

                    }
                    rs.close();
                    ps.close();
                    st.close();

                } catch (Exception e) {
                    System.out.println("could not login:" + e);
                }

            } else {
                JOptionPane.showMessageDialog(null, "You logged in 3 times without success click on forget logging to reset password" + count);

                jBtnLogin.setEnabled(false);

            }
        }

    }//GEN-LAST:event_jBtnLoginActionPerformed

    private void jBtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegisterActionPerformed
        // if(evt.getSource()==jBtnRegister)
        try {
            new register().show();
            dispose();

        } catch (Exception e) {

            System.out.println("Records not inserted!" + e);
        }

    }//GEN-LAST:event_jBtnRegisterActionPerformed

    private void jBtnForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnForgotActionPerformed
        if (evt.getSource() == jBtnForgot) {
            ForgotPassword f = new ForgotPassword();
            f.show();

            dispose();
        }
    }//GEN-LAST:event_jBtnForgotActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnForgot;
    private javax.swing.JButton jBtnLogin;
    private javax.swing.JButton jBtnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextEmail1;
    private javax.swing.JPasswordField jTextPass;
    // End of variables declaration//GEN-END:variables
}
