package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.WebParam;

import DBConnection.DBconnection;
import Enteties.Book;
import Enteties.Cart;
import Enteties.Category;
import Enteties.User;



public class MethodsCart {
	private Statement st ;
    private DBconnection conx ;
    private ResultSet rs ;
    
    public MethodsCart() throws SQLException, ClassNotFoundException
     {
    	conx=new DBconnection();
    	st=conx.getStatement();
    }
    /*public void AddCart(User u,Book b) throws SQLException, ClassNotFoundException
    {
    	st.executeUpdate("insert into cart (id_User,Image_book,Name_book,Price_book) values ('"+u.getId_user()+"','"+b.getBook_Image()+"','"+b.getBook_Name()+"','"+b.getBook_Price()+"')");
    }*/
    public void AddCart(int id_user,String image_book,String name_book,double price_book) throws SQLException, ClassNotFoundException
    {
    	st.executeUpdate("insert into cart (id_User,Image_book,Name_book,Price_book) values('"+id_user+"','"+image_book+"','"+name_book+"','"+price_book+"')");
    }
    
    public void AddCartObj(Cart c) 
    {
    	try {
			st.executeUpdate("insert into cart (id_User,Image_book,Name_book,Price_book) values('"+c.getId_User()+"','"+c.getImage_book()+"','"+c.getName_book()+"','"+c.getPrice_book()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public ArrayList<Cart> GetCartByUser(int id_user) throws SQLException, ClassNotFoundException
    {
    	rs=st.executeQuery("select * from cart where id_user="+id_user);
    	
    	ArrayList<Cart> cs=new ArrayList<>();
    	while(rs.next()) {
    	  Cart c =new Cart();
    	   c.setId_Cart(rs.getInt(1));
    	   c.setId_User(rs.getInt(2));
    	   c.setImage_book(rs.getString(3));
    	   c.setName_book(rs.getString(4));
    	   c.setPrice_book(rs.getDouble(5));
    	   cs.add(c) ;
    	}
    	
		return cs;
    	
    }
    public void DeleteFromCart(int id_cart) throws SQLException, ClassNotFoundException
    {
    	st.executeUpdate("Delete from cart where id_cart="+id_cart);
    }
    public User getUser(int id_user) throws SQLException, ClassNotFoundException
    {
    	User u=new User();
    	rs=st.executeQuery("select * from user where id_user="+id_user);
    	if(rs.next()) {
    		u.setId_user(rs.getInt(1));
    		u.setUser_Name(rs.getString(2));
    		u.setUser_login(rs.getString(3));
    		u.setUser_Password(rs.getString(4));
    		u.setDate_Add_User(rs.getString(5));
    		u.setRole(rs.getInt(6));
    	}
    	return u;
    }
    public Book getBook(int id_book) {
    	Book b=new Book();
    	Category c =new Category();
    	try {
			rs=st.executeQuery("select * from book where id_Book="+id_book);
			if(rs.next()) {
				b.setBook_id(rs.getInt(1));
				b.setBook_Name(rs.getString(2));
				b.setWriter_Name(rs.getString(3));
				b.setBook_Image(rs.getString(4));
				b.setBook_Price(rs.getDouble(5));
				b.setBook_Stock(rs.getInt(6));
				c.setId_Catygory(rs.getInt(7));
				b.setBook_Catygory(c);
				b.setDate_Add_Book(rs.getString(8));
				b.setBook_Summary(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return b;
    	
    }
}
