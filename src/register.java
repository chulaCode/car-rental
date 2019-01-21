
import java.awt.Dimension;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class register extends JFrame implements ActionListener {

    JPanel panelMain = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panelForm = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    JButton button = new JButton("REGISTER");
    JTextField txt1 = new JTextField(20);
    JTextField txt2 = new JTextField(20);
    JTextField txt3 = new JTextField(20);
    JTextField txt4 = new JTextField(20);
    JPasswordField password = new JPasswordField(20);
    JPasswordField repeat_pass = new JPasswordField(20);
    JTextField txt6 = new JTextField(20);
    JTextField txt7 = new JTextField(20);

    //JTextField txt8 = new JTextField(20);
    //JTextField txt9 = new JTextField(20);
    //JTextField txt10 = new JTextField(20);
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    JFormattedTextField txt10 = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField txt9 = new JFormattedTextField(NumberFormat.getIntegerInstance());
    //JFormattedTextField txt8 = new JFormattedTextField();
   JFormattedTextField  txt8= new JFormattedTextField(NumberFormat.getIntegerInstance());

    /*
    formatter.setValueClass(Integer.class);
    formatter.setMinimum(0);
    formatter.setMaximum(Integer.MAX_VALUE);
    formatter.setAllowsInvalid(false);
    // If you want the value to be committed on each keystroke instead of focus lost
    formatter.setCommitsOnValidEdit(true);
    JFormattedTextField field = new JFormattedTextField(formatter);

    JOptionPane.showMessageDialog(null, field);

    // getValue() always returns something valid
    System.out.println(field.getValue());*/
    public register() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);

        setResizable(false);
        //center frame to the middle
        setLocationRelativeTo(null);
        //setLayout(new FlowLayout());

        getContentPane().add(panelMain);
        panelMain.add(panelForm);

        c.weighty = 3;
        JLabel label = new JLabel("REGISTER  ", (int) JLabel.CENTER_ALIGNMENT);
        label.setFont(new Font("serif", Font.BOLD, 30));
        panelForm.add(label);

        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.gridx = 0;
        c.gridy = 1;

        JLabel label1 = new JLabel("FIRSTNAME :  ");
        label1.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label1), c);

        // c.gridx = 0;
        c.gridy++;

        //c.gridy++;
        //c.anchor = GridBagConstraints.LAST_LINE_START;
        c.ipadx = 3;
        c.ipady = 3;
        JLabel label2 = new JLabel("LASTNAME :  ");
        label2.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label2), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label3 = new JLabel("USERNAME :  ");
        label3.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label3), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;
        JLabel label4 = new JLabel("EMAIL :  ");
        label4.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label4), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label8 = new JLabel("PASSWORD :  ");
        label8.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label8), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label11 = new JLabel(" RE-ENTER PASSWORD :  ");
        label11.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label11), c);

       
        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label7 = new JLabel("PHONE :  ");
        label7.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label7), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label9 = new JLabel("CARD NUMBER :  ");
        label9.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label9), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label10 = new JLabel("SECURITY CODE :  ");
        label10.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label10), c);
        
         c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label6 = new JLabel("CITY :  ");
        label6.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label6), c);


        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        JLabel label5 = new JLabel("ADDRESS :  ");
        label5.setFont(new Font("TlwgTypewriter", Font.BOLD, 18));
        panelForm.add((label5), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

       
JLabel label20 = new JLabel("field 7,8,9 accepts only numbers");
        label20.setFont(new Font("TlwgTypewriter", Font.PLAIN, 12));
        panelForm.add((label20), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        button.setPreferredSize(new Dimension(120, 32));
        panelForm.add((button), c);
        //end of view
 
        c.gridx = 1;
        c.gridy = 1;

        // txt1.setPreferredSize(new Dimension(200, 28));
        panelForm.add((txt1), c);

        c.gridx = 1;
        c.gridy++;

        //txt2.setPreferredSize(new Dimension(200, 28));
        panelForm.add((txt2), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        //txt3.setPreferredSize(new Dimension(200, 28));
        panelForm.add((txt3), c);

        c.gridy++;
        c.ipady = 3;
        c.ipadx = 3;

        // txt4.setPreferredSize(new Dimension(200, 28));
        panelForm.add((txt4), c);
        c.gridy++;

        // password.setPreferredSize(new Dimension(200, 20));
        panelForm.add((password), c);

        c.gridy++;

        //repeat_pass.setPreferredSize(new Dimension(200, 28));
        panelForm.add((repeat_pass), c);

        c.gridy++;

        //phone;
        panelForm.add((txt8), c);
        c.gridy++;

        // card number
        panelForm.add((txt9), c);
        c.gridy++;
       
        // If you want the value to be committed on each keystroke instead of focus lost
        //security
        txt8.setPreferredSize(new Dimension(225, 18));
        panelForm.add((txt10), c);
        c.gridy++;

//JFormattedTextField txt9 = new JFormattedTextField(formatter);
        txt9.setPreferredSize(new Dimension(225, 18));
        panelForm.add((txt6), c);

        //JFormattedTextField txt10 = new JFormattedTextField(formatter);
        txt10.setPreferredSize(new Dimension(225, 18));
        c.gridy++;
        panelForm.add((txt7), c);

        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        String text = txtQty1.getText();
    if(text != null) {
        if(!text.matches("[0-9]*")) {
            txtQty1.setText(" ");                
        }
         */
        // DbConnect connect = new DbConnect();
        String FN, LN, UN, email, pass, repeat, add, city;
        String phone, card, security;
        FN = txt1.getText();
        LN = txt2.getText();
        UN = txt3.getText();
        email = txt4.getText();
        pass = password.getText();
        repeat = repeat_pass.getText();
        add = txt6.getText();
        city = txt7.getText();/*
        int phones = Integer.parseInt(txt8.getText());
        int ca = Integer.parseInt(txt9.getText());
        int se = Integer.parseInt(txt10.getText());*/
        phone = txt8.getText();
        card = txt9.getText();
        security = txt10.getText();
         int phones = Integer.parseInt(txt8.getText());
       
        int ca = Integer.parseInt(txt9.getText());
        int se = Integer.parseInt(txt10.getText());
        if (e.getSource() == button) {
            /*
                if (phon != null) {
                    if (!phone.matches("[0-9]*")) {
                        JOptionPane.showMessageDialog(null, " Enter numbers");

                    } else {
                        phone = Integer.parseInt(phon);

                        if (!cards.matches("[0-9]*")) {
                            JOptionPane.showMessageDialog(null, " Enter numbers");

                        } else {
                            phone = Integer.parseInt(phon);

                            if (!cards.matches("[0-9]*")) {
                                JOptionPane.showMessageDialog(null, " Enter numbers");

                            } else {
                                card = Integer.parseInt(cards);

                                if (!sec.matches("[0-9]*")) {
                                    JOptionPane.showMessageDialog(null, " Enter numbers");

                                } else {
                                    security = Integer.parseInt(sec);
                                    if (security < 99 && security > 999) {

                                        JOptionPane.showMessageDialog(null, " Enter only 3 digits!");

             */
            try {
                DbConnect connect = new DbConnect();

                if (!pass.equalsIgnoreCase(repeat)) {
                    JOptionPane.showMessageDialog(null, " Entered password must match repeat password");
                } else if (connect.isValidEmailAddress(email) == false) {
                    JOptionPane.showMessageDialog(null, "email must be in a correct format Ex: code@gmail.com");
                } else if ((se < 99) || (se < 999)) {
                    JOptionPane.showMessageDialog(null, "enter 3 didgit number");

                } else if ((!card.matches("[0-9]*"))||(!phone.matches("[0-9]*"))||(!security.matches("[0-9]*"))) {
JOptionPane.showMessageDialog(null, " Enter numbers only!! ");

                } else {
                    connect.register(FN, LN, UN, email, pass, add, city, phones, ca, se);
                    JOptionPane.showMessageDialog(null, " you have registered successfully ");

                    new index().show();
                    dispose();

                }
            } catch (Exception ex) {
                System.out.println("error inserting into table");
            }
        }
    }

    public static void main(String[] args) throws Exception {

        register i = new register();
        i.show();
    }

}
