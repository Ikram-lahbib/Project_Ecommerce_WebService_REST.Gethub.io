package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	
    private Connection cnx=null;
   private Statement st=null;
 
   private String url="jdbc:mysql://localhost/siteecommerce?zeroDate TimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
   
   public DBconnection() throws SQLException, ClassNotFoundException
   {
       
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, "root", "");
            st = cnx.createStatement();
   }
   
   public Statement getStatement() throws SQLException
   {
       return st;
   }

}
