package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DBconnection;
import Enteties.Category;

public class MethodsCategory {
	
	private Statement st;
    private DBconnection cnx;
    private ResultSet rs;
    
      public MethodsCategory() throws SQLException, ClassNotFoundException
    {
    cnx=new DBconnection();
    st=cnx.getStatement();
    }
      public void AddCategory(String name,String image,String desc) 
      {
          try {
			st.executeUpdate("insert into category (Category_Name,Image,Description) Values('"+name+"','"+image+"','"+desc+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      public void AddCategoryObj(Category c) 
      {
          try {
			st.executeUpdate("insert into category (Category_Name,Image,Description) Values('"+c.getName_Category()+"','"+c.getImage_Category()+"','"+c.getDescription_Category()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      public void UpdateCategory(int id,String name) 
      {
          try {
			st.executeUpdate("update Category set Category_Name='"+name+"' where id_Category="+id+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
         public void DeleteCategory(int id) 
      {
          try {
			st.executeUpdate("delete from category where id_Category="+id+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
         
         public ArrayList<Category> GetALLCategory() 
         {
        	 
        	 ArrayList<Category> cs=new ArrayList<Category>();
        	 try {
				rs=st.executeQuery("select * from category;");
				while(rs.next())
	             {
	                 Category c=new Category();
	                 c.setId_Catygory(rs.getInt(1));
	                 c.setName_Category(rs.getString(2));
	                 c.setImage_Category(rs.getString(3));
	                 c.setDescription_Category(rs.getString(4));
	                 cs.add(c);    
	             }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
        	 
			return cs;
        	 
         }
         public String getCategoryName(int id) 
         {
        	  String nc = null;
              try {
				rs=st.executeQuery("select Category_Name  from category where id_Category="+id+";");
				  if( rs.next()) {
					nc=rs.getString("Category_Name");
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              return nc ;
         }
         public Category getCategory(int id) 
         {
        	  Category c=new Category();
              try {
				rs=st.executeQuery("select *  from category where id_Category="+id+";");
				  if(rs.next()) {
					  c.setId_Catygory(rs.getInt(1));
					  c.setName_Category(rs.getString(2));
					  c.setImage_Category(rs.getString(3));
					  c.setDescription_Category(rs.getString(4));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              return c;
  
         }

}
