
import java.awt.Container;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class index extends JFrame implements ActionListener {

    //JTextField txt = new JTextField();
    JComboBox station = new JComboBox();
    JButton button = new JButton("Find car");
    JPanel panelMain = new JPanel();
    JPanel panelForm = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    //Date picker
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    //model.setDate(20,04,2014);
    Properties p = new Properties();
    Properties q = new Properties();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
// Don't know about the formatter, but there it is...
    Date date = new Date();
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

    Date selectedDate = (Date) datePicker.getModel().getValue();
    Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
    //drop-off date picker
    JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, q);
    JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

    Date selectedDate2 = (Date) datePicker2.getModel().getValue();
    Calendar selectedValue2 = (Calendar) datePicker2.getModel().getValue();

    public index() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        //let it not e resised
        setResizable(false);
        //center frame to the middle
        setLocationRelativeTo(null);
        //setLayout(new FlowLayout());

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        selectedDate = (java.sql.Date) datePicker.getModel().getValue();
        selectedDate2 = (java.sql.Date) datePicker2.getModel().getValue();

        getContentPane().add(panelMain);
        panelMain.add(panelForm);

        JLabel label1 = new JLabel("FIND YOUR IDEAL CAR", JLabel.LEFT);
        label1.setFont(new Font("Serif", Font.BOLD, 35));
        panelForm.add((label1), c);

        c.gridx = 0;
        c.gridy = 1;

        //c.gridy++;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.ipadx = 3;
        c.ipady = 3;
        JLabel label2 = new JLabel("Pick-up Location");
        label2.setFont(new Font("TlwgTypewriter", Font.PLAIN, 18));
        panelForm.add((label2), c);

        c.gridy++;
        c.ipady = 5;
        c.ipadx = 5;
        //txt.setPreferredSize(new Dimension(450,28));
        station.addItem("Lemar bus station");
        station.addItem("City Center bus station");
        station.addItem("Castle bus station");
        station.addItem("Lc waikiki bus station");
        station.addItem("Kaliland bus station");
        station.addItem("Emu bus station");
        station.addItem("Guzerene bus station");
        station.addItem("police bus station");
        station.addItem("Hamilkoy ");
        station.addItem("ciu");
        station.addItem("Near east");
        station.addItem("Gau");
        station.addItem("General Hospital");
        panelForm.add((station), c);

        c.gridy++;
        JLabel label3 = new JLabel("Pick-up Date");
        label3.setFont(new Font("TlwgTypewriter", Font.PLAIN, 18));
        panelForm.add((label3), c);

        c.gridy++;
        panelForm.add((datePicker), c);

        c.gridy++;
        c.ipady = 4;
        c.ipadx = 4;
        JLabel label4 = new JLabel("Drop-off Date");
        label4.setFont(new Font("TlwgTypewriter", Font.PLAIN, 18));
        panelForm.add((label4), c);

        c.gridy++;
        panelForm.add((datePicker2), c);

        c.gridy++;
        JLabel label8 = new JLabel("-----------------");
        label8.setFont(new Font("TlwgTypewriter", Font.ITALIC, 14));
        panelForm.add((label8), c);

        c.gridy++;

        JLabel label5 = new JLabel("No credit card fee");
        label5.setFont(new Font("TlwgTypewriter", Font.ITALIC, 14));
        panelForm.add((label5), c);

        c.gridy++;
        JLabel label6 = new JLabel("No Ammendment fee");
        label6.setFont(new Font("TlwgTypewriter", Font.ITALIC, 14));
        panelForm.add((label6), c);

        c.gridy++;
        JLabel label7 = new JLabel("24/7 phone supprt");
        label7.setFont(new Font("TlwgTypewriter", Font.ITALIC, 11));
        panelForm.add((label7), c);

        c.gridy++;
        c.weightx = 3;
        c.weighty = 3;

        JLabel label9 = new JLabel("-----------------");
        label9.setFont(new Font("TlwgTypewriter", Font.ITALIC, 14));
        panelForm.add((label9), c);

        c.gridy++;
        c.weightx = 3;
        c.weighty = 3;

        button.setPreferredSize(new Dimension(120, 32));
        panelForm.add((button), c);
        //end of view

        button.addActionListener(this);

    }

    public static void main(String[] args) throws Exception {
        DbConnect connect = new DbConnect();

        index i = new index();
        i.show();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            int d = datePicker.getModel().getDay();
            int m = datePicker.getModel().getMonth();
            int y = datePicker.getModel().getYear();
            int d2 = datePicker2.getModel().getDay();
            int m2 = datePicker2.getModel().getMonth();
            int y2 = datePicker2.getModel().getYear();
            String stat = station.getSelectedItem().toString();
            System.out.println("localtime" + Calendar.getInstance().get(Calendar.MONTH));

            if ((m > m2) && (y > y2) && (d > d2)) {
                JOptionPane.showMessageDialog(null, "pickup date must be less than drop off date THANKS!!");

            } else if ((d2 - d) > 30) {
                JOptionPane.showMessageDialog(null, "Car can only be rented for a maximum of 30 days THANKS!!");

            } // else if((m>date.getMonth())||(m2>date.getMonth())){
            // JOptionPane.showMessageDialog(null, "Select current month thanks");
            // }
            else if ((y < Calendar.getInstance().get(Calendar.YEAR)) || (y2 < Calendar.getInstance().get(Calendar.YEAR))) {
                JOptionPane.showMessageDialog(null, "Select current year thanks");
            } else {
                if ((m < Calendar.getInstance().get(Calendar.MONTH)) || (m2 < Calendar.getInstance().get(Calendar.MONTH))) {

                    JOptionPane.showMessageDialog(null, "Select current month thanks");
                } else {
                    if ((d < date.getDate()) || (d2 < date.getDate())) {
                        JOptionPane.showMessageDialog(null, "Select current date thanks");
                    } else {
                        try {
                            DbConnect connect = new DbConnect();
                            connect.insert(stat, d, d2);
                            new main().show();
                            new index().dispose();

                        } catch (Exception ex) {
                            System.out.println("Records not inserted!" + ex);

                        }
                    }

                }

            }
        }
    }
}
