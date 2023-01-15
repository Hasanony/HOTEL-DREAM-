
import java.sql.*;

public class Connect {

public Connection c;
    public Statement s;
    Connect() {
        
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
              c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","123");
              s = c.createStatement();
             if(c!=null){
                 System.out.println("succefully connected");
             }
         
             
            
        } catch (Exception ex) {
          ex.printStackTrace();
            System.out.println("not connected");
        }
    
    }   
    
    
}
