
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class post extends javax.swing.JFrame {

    Connection con = (Connection) new connection().connect();
    DecimalFormat df = new DecimalFormat("$#.00");

    public post() throws SQLException {
        initComponents();
        populate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        payment = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Days = new javax.swing.JLabel();
        jBConfirm = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel1.setText("DELIVERY INFORMATION");

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

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Total amount payed in Dollars");

        payment.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Total number of Days");

        Days.setText("jLabel5");

        jBConfirm.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jBConfirm.setText("Confirm");
        jBConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Thank you for making us your choice!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jBConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(Days, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(294, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(payment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(Days)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addGap(69, 69, 69)
                        .addComponent(jBConfirm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmActionPerformed
        if (evt.getSource() == jBConfirm) {
            int dialogButton = 0;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to rent another car?", " ", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                new index().show();
                dispose();
            } else {
                int dialog = JOptionPane.showConfirmDialog(null, "Hope you enjoyed our service?", " ", dialogButton);
                if (dialog == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, " Thank you Do have a great Day!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, " so sorry we'll serve you better next time takia!");
dispose();
                }
            }
        }

    }//GEN-LAST:event_jBConfirmActionPerformed

    

    public ArrayList<items> post() throws SQLException {
        ArrayList<items> list = new ArrayList<items>();

        //st=con.createStatement();
        Statement st = con.createStatement();
        ResultSet rs = null;
        int f = 0, t = 0, pri = 0;
        int total = 0;

        try {
            rs = st.executeQuery("SELECT `name`, `model`,`price`,`from_date`,`to_date` FROM `cart`");

            items p;
            while (rs.next()) {
                //System.out.println(rs.getString(""));
                p = new items(
                        //rs.getInt(1),
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        // rs.getInt(4),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                list.add(p);
                f += p.getFrom();
                t += p.getTo();
                pri += p.getPrice();
                total = (t - f) * pri;
                String tot = df.format(total).toString();
                payment.setText(tot);
                int sum = t + f;
                String s = " " + sum + " days";
                Days.setText(s);
            }

        } catch (SQLException ex) {
            System.out.println("Could not select record from stock" + ex);
        }
        rs.close();
        st.close();
        return list;
    }

    public void populate() throws SQLException {
        // DbConnect c = new DbConnect();
        ArrayList<items> list = post();
        String[] columnName = {"NAME", "MODEL"};
        Object[][] rows = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            //rows[i][0] = list.get(i).getInt();
            rows[i][0] = list.get(i).getCarName();
            rows[i][1] = list.get(i).getAccessories();
        }

        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new post().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(post.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Days;
    private javax.swing.JButton jBConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel payment;
    // End of variables declaration//GEN-END:variables
}
