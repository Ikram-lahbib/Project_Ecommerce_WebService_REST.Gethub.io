package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DBconnection;
import Enteties.Book;
import Enteties.Category;


public class MethodsBook {
	
	private Statement st ;
    private DBconnection conx ;
    private ResultSet rs ;
    
    public MethodsBook() throws SQLException, ClassNotFoundException
    {
    conx=new DBconnection();
    st=conx.getStatement();
   
    }
    
    public void AddBook (Book B) throws SQLException, ClassNotFoundException
    {
    	 
         st.executeUpdate("insert into book(Name,Writer,Image,Price,Stock,id_Category,Date,Summary) values('"+B.getBook_Name()+"','"+B.getWriter_Name()+"','"+B.getBook_Image()+"','"+B.getBook_Price()+"','"+B.getBook_Stock()+"','"+B.getBook_Catygory().getId_Catygory()+"','"+B.getDate_Add_Book()+"','"+B.getBook_Summary()+"')");
    }
    
    public Book GetBook(int id) throws SQLException
    {
    	Book b=new Book();
    	Category c =new Category();
    	MethodsCategory cd =null;
		try {
			cd = new MethodsCategory();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	rs=st.executeQuery("Select * From book where id_Book ="+id);
    	if(rs.next()) {
    		b.setBook_id(rs.getInt(1));
    		b.setBook_Name(rs.getString(2));
    		b.setWriter_Name(rs.getString(3));
    		b.setBook_Image(rs.getString(4));
    		b.setBook_Price(rs.getDouble(5));
    		b.setBook_Stock(rs.getInt(6));
    		c.setId_Catygory(rs.getInt(7));
    		//c.setName_Category(cd.getCategoryName(rs.getInt(7)));
    		b.setBook_Catygory(c);
    		b.setDate_Add_Book(rs.getString(8));
    		b.setBook_Summary(rs.getString(9));
    	}
    	
		return b;
    	
    }
   public void UpdateBook(int id, Book B) throws SQLException
    {
    	st.executeUpdate(" update book set Name ="+B.getBook_Name()+"Writer="+B.getWriter_Name()+"Image="+B.getBook_Image()+"Price="+B.getBook_Price()+"Stock="+B.getBook_Stock()+"id_Category="+B.getBook_Catygory().getId_Catygory()+" Date="+B.getDate_Add_Book()+" Summary="+B.getBook_Summary()+" where id_Book="+id);
    }
   public void DeleteBook(int id )throws SQLException
   {
	   st.executeUpdate("delete from book where id_Book ="+id);
   }
   public ArrayList<Book> GetAllBook() throws SQLException
   {
    ArrayList<Book> bs=new ArrayList<>();
    MethodsCategory cd =null;
	try {
		cd = new MethodsCategory();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
   	rs=st.executeQuery("Select * From book ");
   	while (rs.next()) {
   		Book b=new Book();
   	   	Category c =new Category();
   	   	b.setBook_id(rs.getInt(1));
   		b.setBook_Name(rs.getString(2));
   		b.setWriter_Name(rs.getString(3));
   		b.setBook_Image(rs.getString(4));
   		b.setBook_Price(rs.getDouble(5));
   		b.setBook_Stock(rs.getInt(6));
   		c.setId_Catygory(rs.getInt(7));
   		//c.setName_Category(cd.getCategoryName(rs.getInt(7)));
   		b.setBook_Catygory(c);
   		b.setDate_Add_Book(rs.getString(8));
   		b.setBook_Summary(rs.getString(9));
   		
   		bs.add(b);
   	}
	return bs;
	   
   }
   public ArrayList<Book> GetBookByCategory( int id_Category) throws SQLException
   {
    ArrayList<Book> bs=new ArrayList<Book>();
   /* MethodsCategory cd =null;
    try {
		cd=new MethodsCategory();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
   	rs=st.executeQuery("select * from book where  id_Category = "+id_Category);
   	while (rs.next()) {
   		Book b=new Book();
   	   	Category c =new Category();
   	   	b.setBook_id(rs.getInt(1));
   		b.setBook_Name(rs.getString(2));
   		b.setWriter_Name(rs.getString(3));
   		b.setBook_Image(rs.getString(4));
   		b.setBook_Price(rs.getDouble(5));
   		b.setBook_Stock(rs.getInt(6));
   		c.setId_Catygory(rs.getInt(7));
   		//c.setName_Category(cd.getCategoryName(rs.getInt(7)));
   		b.setBook_Catygory(c);
   		b.setDate_Add_Book(rs.getString(8));
   		b.setBook_Summary(rs.getString(9));
   		
   		bs.add(b);
   	}
	return bs;
	   
   }
   public ArrayList<Book> GetBookByDate(String date) throws SQLException
   {
    ArrayList<Book> bs=new ArrayList<>();
    MethodsCategory cd =null;
	try {
		cd = new MethodsCategory();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   	rs=st.executeQuery("Select * From book where MONTH(Date) = "+date);
   	while (rs.next()) {
   		Book b=new Book();
   	   	Category c =new Category();
   		b.setBook_Name(rs.getString(2));
   		b.setWriter_Name(rs.getString(3));
   		b.setBook_Image(rs.getString(4));
   		b.setBook_Price(rs.getDouble(5));
   		b.setBook_Stock(rs.getInt(6));
   		c.setId_Catygory(rs.getInt(7));
   		//c.setName_Category(cd.getCategoryName(rs.getInt(7)));
   		b.setBook_Catygory(c);
   		b.setDate_Add_Book(rs.getString(8));
   		b.setBook_Summary(rs.getString(9));
   		
   		bs.add(b);
   	}
	return bs;
	   
   }
   

}
