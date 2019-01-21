
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class connection {
    
   private Connection DBConnection;
    //declaring variable for connecting to database
    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection to DB was successful");
            
        }
        catch(ClassNotFoundException e){
            System.out.println("connection to DB failed" +e);
        }
        String url="jdbc:mysql://localhost:3306/car_rental";
        
        try{
            DBConnection =(Connection) DriverManager.getConnection(url,"root", "");
            //connection to database
            System.out.println("Database Connected");
       
        }
        catch(Exception e){
            System.out.println("Database could not create connection" +e);
        }
        return DBConnection;
    }
    
}
