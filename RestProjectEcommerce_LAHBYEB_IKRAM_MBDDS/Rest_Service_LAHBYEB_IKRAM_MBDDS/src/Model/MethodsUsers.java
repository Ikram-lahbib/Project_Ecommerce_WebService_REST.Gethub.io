package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.DBconnection;
import Enteties.User;


public class MethodsUsers {
	private Statement st;
    private DBconnection cnx;
    private ResultSet rs;
    public MethodsUsers() throws SQLException, ClassNotFoundException
    {
    cnx=new DBconnection();
    st=cnx.getStatement();
    }
    public void AddUser(User U) throws SQLException
    {
    	st.executeUpdate("insert into user (Username,Login,Password,Date,Role) Values('"+U.getUser_Name()+"','"+U.getUser_login()+"','"+U.getUser_Password()+"','"+U.getDate_Add_User()+"','"+U.getRole()+"')");
    }
    public User AuthUser(String login ,String password) throws SQLException
    {
    	User u =new User();
    	rs=st.executeQuery("select * from user where Login='"+login+"'and Password ='"+password+"'");
    	if (rs.next()) {
    		u.setId_user(rs.getInt(1));
    		u.setUser_Name(rs.getString(2));
    		u.setUser_login(rs.getString(3));
    		u.setUser_Password(rs.getString(4));
    		u.setDate_Add_User(rs.getString(5));
    		u.setRole(rs.getInt(6));
    	}
		return u;
    	
    }
    public User GetUser(int id) throws SQLException{
    	User u =new User();
    	rs=st.executeQuery("select * from user where id_user="+id);
    	if (rs.next()) {
    		u.setId_user(rs.getInt(1));
    		u.setUser_Name(rs.getString(2));
    		u.setUser_login(rs.getString(3));
    		
    	}
		return u;
    	
    }

}
