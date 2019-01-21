
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DbConnect {

    /*
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/car_rental";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";*/
    // private Connection con;
    protected Statement st = null;
    protected Resultset rs = null;
    int scount = 1;
    //  st = con.createStatement();
    Connection con = new connection().connect();

    public DbConnect() throws Exception {
        /* try {
            Class.forName(DATABASE_DRIVER);
            System.out.println("Driver loaded!");
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connceted successfully to " + DATABASE_URL);

        } catch (Exception e) {
            System.out.println("Error loading driver:" + e);
        }*/

    }
    
    public void Clear() throws SQLException
    {
        st = con.createStatement();
        
        try{
           
            String sql="DELETE FROM `cart`";
            st.executeUpdate(sql);
            System.out.println("cart cleared");
        }catch(Exception e)
         {
           System.out.println("Could not delete all rows"+e);
         }
    }
    public void DeleteAllCart(int i) throws SQLException
    {
         st = con.createStatement();
          String sql="DELETE FROM `stock` WHERE `stock_id`=? ";
         try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
                  // + "//INNER JOIN (`stock`) ON (`stock`.`stock_id`=`cart`.`stock_id` ";
             //FROM `cart` c, `stock` s WHERE c.`cart_id`=s.`cart_id`";
             ps.executeUpdate();
               System.out.println("Cart items cleared");
            /* 
               SELECT * FROM t1 LEFT JOIN (t2, t3, t4)
                 ON (t2.a=t1.a AND t3.b=t1.b AND t4.c=t1.c)

            
DELETE t1, t2 FROM t1 INNER JOIN t2 INNER JOIN t3
WHERE t1.id=t2.id AND t2.id=t3.id;
`*/

         }catch(Exception e)
         {
           System.out.println("Could not delete all rows"+e);
         }
    }

    public void DeleteCart(String item) throws SQLException {
        st = con.createStatement();
        
        String sql = "DELETE FROM `cart` WHERE `model`=?";
         System.out.println("could not delete from cart" + item);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item);
             System.out.println("could not delete from cart" + item);

            ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "DELETION SUCCESSFULL");
           cart c=new cart();
           c.show();
           cart ca=new cart();
           ca.dispose();

        } catch (Exception e) {
            System.out.println("could not delete from cart" + e);
        }

    }

    public void addToCart(String name, String model, Double price, byte[] image, int from, int to,int stock) throws SQLException {
        st = con.createStatement();

        String sql = "INSERT INTO cart (name,model,price,image, from_date,to_date,stock_id) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, model);
            ps.setDouble(3, price);
            ps.setBytes(4, image);
            ps.setInt(5, from);
            ps.setInt(6, to);
            ps.setInt(7, stock);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Item added to cart check my booking tab!");
            //ps.close();

            new main().dispose();
            new cart().show();
        } catch (Exception e) {
            System.out.println("Records cannot be inserted into cart table"+e);
            e.printStackTrace();
        }

        st.close();

    }

    public void display() throws SQLException {
        st = con.createStatement();
        ResultSet rs = null;

        String from, to, all;
        try {
            rs = st.executeQuery("SELECT `pickup_data`, `drop_date` FROM `pickup` ORDER BY `pickup_id` DESC");

            if (rs.next()) {
                int p = rs.getInt(1);
                int d = rs.getInt(2);
                //display in jlabel of main page
                from = String.valueOf(p);
                to = String.valueOf(d);
                all = "Rented From " + from + " To" + to;
                // DbConnect c=new DbConnect();
                //c.setValue(all);
                //System.out.println("Error retrieving from pickup table:" +p+" "+d );
            }

        } catch (Exception e) {
            System.out.println("Error retrieving from pickup table:" + e);
        }

        //return rs;
        rs.close();
        st.close();
    }

    public void updateDate(int from, int to, String car) throws SQLException {
        st = con.createStatement();
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT `cart_id`,`from_date`,`to_date`,`model` FROM `cart`");
            //rs = st.executeQuery("SELECT `email`, `password` FROM `(\"user`");
            // PreparedStatement ps = con.prepareStatement(sql1);

            System.out.println("Value gotten from database:" + from + " " + to);

            if (rs.next()) {

                int fr = rs.getInt(1);
                int t = rs.getInt(2);
                String c = rs.getString(3);
                //String pass=  rs.g2tStri;ng(2);

                System.out.println("Value gotten from database:" + fr + " " + t);
                //if ((fr==from)&&(t==to)) {

                if ((from > 31) || (to > 31) || (from < 1) || (to < 1)) {
                    JOptionPane.showMessageDialog(null, "pick an actual date");

                } else {
                    if ((from == 31) || (to == 31)) {
                        JOptionPane.showMessageDialog(null, "sorry booking not allowed on the 31st thanks for your ");
                    } else {

                        if (from - to <= 30) {
                            String sql = "UPDATE `cart` SET `from_date`=?,`to_date`=? WHERE `model`=?";
                            PreparedStatement p = con.prepareStatement(sql);
                            p.setInt(1, from);
                            p.setInt(2, to);
                            p.setString(3, car);

                            p.executeUpdate();
                            JOptionPane.showMessageDialog(null, "BOOKING DATE UPDATED");

                            cart l = new cart();
                            l.show();
                            cart f = new cart();
                            f.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "booking must be maximum of 30days!");

                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "enter only number");

            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("error retrieving from user in password reset:" + e);
        }
    }

    public void password(String u_email, String pas) throws SQLException {

        st = con.createStatement();
        ResultSet rs = null;
        try {
            String sql1 = "SELECT `email`,`password` FROM `user` WHERE `email`=? ";
            //rs = st.executeQuery("SELECT `email`, `password` FROM `(\"user`");
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setString(1, u_email);

            rs = ps.executeQuery();

            if (rs.next()) {

                String in_email = rs.getString(1);
                String pass = rs.getString(2);
                //String pass=  rs.getString(2);

                System.out.println("Value gotten from database:" + in_email + " " + pass);
                if (in_email.equalsIgnoreCase(u_email)) {
                    String sql = "UPDATE `user` SET `password`=? WHERE `email`=?";
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setString(1, pas);
                    p.setString(2, u_email);
                    p.executeUpdate();
                    JOptionPane.showMessageDialog(null, "PASSWORD UPDATED SUCCESSFUL");

                    Login l = new Login();
                    l.show();
                    ForgotPassword f = new ForgotPassword();
                    f.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "EMAIL DOESN'T MATCH REGISTERED EMAIL!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "invalid email!");

            }
            rs.close();
            ps.close();
            st.close();

        } catch (Exception e) {
            System.out.println("error retrieving from user in password reset:" + e);
        }
    }

    /*
    public void login(String email, String password) throws SQLException, Exception {
        st = con.createStatement();
        ResultSet rs = null;
        String sql = "SELECT `email`,`password` FROM `user` WHERE email=? AND password=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            
             
            if (rs.next()) {
                // System.out.println(email);
                String digit= JOptionPane.showInputDialog("enter 3 digit card number");
                int no=Integer.parseInt(digit);
                 String sqli = "SELECT `security_code `FROM `user` WHERE security_code=?";
                 try{
                     PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, email);
           
           ResultSet r = ps.executeQuery();
           if(r.next())
           {
                cart mm = new cart();
                mm.show();

           }
            
                 }catch (Exception e) {
            System.out.println("could not retrieve from user in security code:" + e);
        }


                
                
               
            } else {
                JOptionPane.showMessageDialog(null, "invalid email or password");

            }
            rs.close();
            ps.close();
            st.close();

        } catch (Exception e) {
            System.out.println("could not login:" + e);
        }

    }*/
    public void security(int card) throws SQLException {

        st = con.createStatement();
        ResultSet rs = null;
        String sql = "SELECT `security_code` FROM `user` WHERE security_code=?";

        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, card);
            ResultSet r = p.executeQuery();

            if (r.next()) {
                cart mm = new cart();
                mm.show();

            } else if (scount == 1) {
                JOptionPane.showMessageDialog(null, "Incorrect security code you have 2 more attempts");
                scount++;
            } else if ((!r.next()) && (scount == 2)) {
                JOptionPane.showMessageDialog(null, "Incorrect security code you have 1 more attempts");
                scount++;
            }

            r.close();
            p.close();
        } catch (Exception e) {
            System.out.println("could not retrieve from user in security code:" + e);
        }

    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public void insert(String loc, int from, int to) throws SQLException {
        st = con.createStatement();

        String sql = "INSERT INTO pickup (location,pickup_data,drop_date) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, loc);
            ps.setInt(2, from);
            ps.setInt(3, to);

            ps.execute();
            System.out.println("Records inserted dBConnect class");
            ps.close();

        } catch (Exception e) {
            System.out.println("Records cannot be inserted dBConnect class");
            e.printStackTrace();
        }
        st.close();

    }

    public void register(String firstname, String lastname, String username, String email, String pass,
            String add, String city, int phone, int card, int security) throws SQLException {
        st = con.createStatement();

        String sql = "INSERT INTO user (firstname,lastname,username,email, password,address,city,phone,card,security_code) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, username);
            ps.setString(4, email);
            ps.setString(5, pass);
            ps.setString(6, add);
            ps.setString(7, city);
            ps.setInt(8, phone);
            ps.setInt(9, card);
            ps.setInt(10, security);

            ps.execute();
            System.out.println("Records inserted into user table ");
            ps.close();

        } catch (Exception e) {
            System.out.println("Records cannot be inserted into user table");
            e.printStackTrace();
        }

        st.close();

    }

    public ArrayList<items> BindTable() throws SQLException {

        ArrayList<items> list = new ArrayList<items>();

        st = con.createStatement();
        ResultSet rs = null;

        try {
            rs = st.executeQuery("SELECT `stock_id`, `car_name`, `accessories`, `price`, `image`, `status`, `gear`, `seat` FROM `stock`");

            items p;
            while (rs.next()) {
                //System.out.println(rs.getString(""));
                p = new items(
                        //rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getBytes(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
                list.add(p);

                // JOptionPane.showMessageDialog(null, "value frm db are:"+rs.getString(2)+"-"
                //+"-"+rs.getString(3)+"-"+rs.getDouble(4)+"-"+rs.getBytes(5)+"-"+ rs.getBoolean(6)+"-"+rs.getInt(7)+"-"+rs.getInt(8));
            }
            //JOptionPane.showMessageDialog(null," p value is"+list);

        } catch (SQLException ex) {
            System.out.println("Could not select record from stock" + ex);
        }
        rs.close();
        st.close();
        return list;

    }
    public ArrayList<items>stock() throws SQLException
    {
        ArrayList<items>list= new ArrayList<items>();
        st = con.createStatement();
        ResultSet rs = null;
        
        try{
            rs = st.executeQuery("SELECT `stock_id` FROM `stock`");
            
            items p;
            while(rs.next())
            {
                p= new items(
                        rs.getInt(1)
                       
                );
                list.add(p);
                 System.out.println(p.getStock());
                        
            }
            
            
        }catch(Exception e)
        {
            System.out.println("could not get stock id"+e);
        }
        rs.close();
        st.close();
        return list;
    }

    public ArrayList<items> selectCat() throws SQLException {
        ArrayList<items> list = new ArrayList<items>();

        st = con.createStatement();
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT`stock_id`,`car_name`, `accessories`, `price`, `image`, `status`, `gear`, `seat` FROM `stock`"
                    + " WHERE `category`=1");

            items p;
            while (rs.next()) {
                //System.out.println(rs.getString(""));
                p = new items(
                        //rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getBytes(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
                list.add(p);

                // JOptionPane.showMessageDialog(null, "value frm db are:"+rs.getString(2)+"-"
                //+"-"+rs.getString(3)+"-"+rs.getDouble(4)+"-"+rs.getBytes(5)+"-"+ rs.getBoolean(6)+"-"+rs.getInt(7)+"-"+rs.getInt(8));
            }
            //JOptionPane.showMessageDialog(null," p value is"+list);

        } catch (SQLException ex) {
            System.out.println("Could not select record from stock" + ex);
        }
        rs.close();
        st.close();
        return list;
    }

    public ArrayList<items> selectCat2() throws SQLException {
        ArrayList<items> list = new ArrayList<items>();

        st = con.createStatement();
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT `stock_id`, `car_name`, `accessories`, `price`, `image`, `status`, `gear`, `seat` FROM `stock`"
                    + " WHERE `category`=2");

            items p;
            while (rs.next()) {
                //System.out.println(rs.getString(""));
                p = new items(
                        //rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getBytes(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
                list.add(p);

                // JOptionPane.showMessageDialog(null, "value frm db are:"+rs.getString(2)+"-"
                //+"-"+rs.getString(3)+"-"+rs.getDouble(4)+"-"+rs.getBytes(5)+"-"+ rs.getBoolean(6)+"-"+rs.getInt(7)+"-"+rs.getInt(8));
            }
            //JOptionPane.showMessageDialog(null," p value is"+list);

        } catch (SQLException ex) {
            System.out.println("Could not select record from stock" + ex);
        }
        rs.close();
        st.close();

        return list;
    }

}
