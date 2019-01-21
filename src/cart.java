
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class cart extends javax.swing.JFrame {

    Connection conn = new connection().connect();
    //DbConnect c = new DbConnect();
    Statement st;
    DecimalFormat df = new DecimalFormat("$#.00");

    public cart() throws Exception {
        initComponents();
        cart();
        count();
        //countCat();
        
       
    }
    

    public void count() throws SQLException {
        ResultSet rs = null;
        String from, to, all;

        String sql = "SELECT COUNT(*) FROM `stock`";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int p = rs.getInt(1);
                String sum = " The total of " + String.valueOf(p) + " cars is available now!";

                jlCarTotal.setText(sum);
                System.out.println(p);
            }

        } catch (Exception e) {
            System.out.println("Error retrieving from stock table in couunt:" + e);
            e.printStackTrace();
        }

        rs.close();
        

    }

    public ArrayList<items> CartSelect() throws SQLException {

        ArrayList<items> list = new ArrayList<items>();

        st = conn.createStatement();
        ResultSet rs = null;
        Double pri = 0.0;
        Double total = 0.0;
        int f = 0, t = 0, d = 0;
        Double calculate = 0.0;
        try {
            rs = st.executeQuery("SELECT `name`, `model`, `price`, `image`, `from_date`, `to_date` FROM `cart`");

            items p;
            while (rs.next()) {
                //System.out.println(rs.getString(""));
                p = new items(
                        //rs.getInt(1),
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getBytes(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                list.add(p);
                f += p.getFrom();
                t += p.getTo();
                pri += p.getPrice();
                total = (t-f) * pri;
                String tot = df.format(total).toString();
                calc.setText(tot);
            }

        } catch (SQLException ex) {
            System.out.println("Could not select record from cart table" + ex);
        }

        rs.close();
        st.close();
        return list;
    }

    public void cart() throws Exception {
        //DbConnect c = new DbConnect();
        ArrayList<items> list = CartSelect();
        String[] columnName = {"NAME", "MODEL", "PRICE/DAY($)", " ", "BOOK FROM", "BOOK TO"};
        Object[][] rows = new Object[list.size()][6];
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
            rows[i][4] = list.get(i).getFrom();
            rows[i][5] = list.get(i).getTo();

        }

        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
        

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        calc = new javax.swing.JLabel();
        jTextFrom = new javax.swing.JTextField();
        jTextTo = new javax.swing.JTextField();
        jlCarTotal = new javax.swing.JLabel();
        jTCar = new javax.swing.JTextField();
        jBtnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("TlwgTypewriter", 1, 48)); // NOI18N
        jLabel1.setText("MY BOOKING");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnRemove.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        btnRemove.setText("REMOVE CAR");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnChange.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        btnChange.setText("CHANGE BOOKING");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnPay.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        btnPay.setText("PAY");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("TlwgTypewriter", 1, 18)); // NOI18N
        jLabel2.setText("TOTAL:");

        calc.setText("jLabel3");

        jTextFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFromActionPerformed(evt);
            }
        });

        jlCarTotal.setText("jLabel3");

        jTCar.setEditable(false);
        jTCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCarActionPerformed(evt);
            }
        });

        jBtnHome.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jBtnHome.setText("HOME");
        jBtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlCarTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTCar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jTextFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextTo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBtnHome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCarTotal)
                    .addComponent(jTCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(calc))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
      if(evt.getSource()==btnRemove)
      {
          String p=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
          //int r= Integer.parseInt(p);
          // int i=jTable1.getSelectedRow();
          try {
              DbConnect c=new DbConnect();
               System.out.println("could not delete from cart" + p);
              c.DeleteCart(p);
          } catch (Exception ex) {
              Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jTextFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFromActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed

        if (evt.getSource() == btnPay) {
            JOptionPane.showMessageDialog(null, "Login to complete payment");

            new Login().show();
            //main m=new main();
            dispose();
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        /* String from = jTextFrom.getText();
        String to = jTextTo.getText();
        int From = Integer.parseInt(from);
        int To = Integer.parseInt(to);*/

        if (evt.getSource() == btnChange) {
            ResultSet rs = null;
            try {
                st = conn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            //if (jTable1.getSelectedRow() != -1) {
                //String FROM = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
                //String TO = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
               // jTextFrom.setText(FROM);
               // jTextTo.setText(TO);

                String from = jTextFrom.getText();
                String to = jTextTo.getText();
                String car=jTCar.getText();
                
               
                int From = Integer.parseInt(from);
                int To = Integer.parseInt(to);
                DbConnect c;
                try {
                    c = new DbConnect();
                    c.updateDate(From, To,car);
                    
                } catch (Exception ex) {
                    System.out.println("problem getting update"+ex);
                }
                

            //}

        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
   
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i=jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        jTextFrom.setText( model.getValueAt(i, 4).toString());
        jTextTo.setText(model.getValueAt(i, 5).toString());
        jTCar.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCarActionPerformed

    private void jBtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHomeActionPerformed
       if(evt.getSource()==jBtnHome){
           try {
               main m=new main();
               m.show();
               dispose();
           } catch (Exception ex) {
               Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_jBtnHomeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new cart().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel calc;
    private javax.swing.JButton jBtnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCar;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFrom;
    private javax.swing.JTextField jTextTo;
    private javax.swing.JLabel jlCarTotal;
    // End of variables declaration//GEN-END:variables
}
