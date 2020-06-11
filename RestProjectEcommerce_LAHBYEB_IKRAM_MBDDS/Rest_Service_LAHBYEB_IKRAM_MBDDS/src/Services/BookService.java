package Services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Enteties.Book;
import Model.MethodsBook;
import Model.MethodsCategory;

@Path("/BookService")
public class BookService {
   MethodsBook bd=null;
   Book b=new Book();
    @POST
	@Path("/addBook")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public void AddCategory(Book b) throws ClassNotFoundException, SQLException {
		bd=new MethodsBook();
		bd.AddBook(b);
		
	}
    
    @PUT
	@Path("/updateBook/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public void updateBook(@PathParam("id") int id,Book b) throws ClassNotFoundException, SQLException {
		bd=new MethodsBook();
		bd.UpdateBook(id, b);
		
	}
    
    @DELETE
	@Path("/deleteBook/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public void deleteBook(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		bd=new MethodsBook();
		bd.DeleteBook(id);
		
	}
    
    @GET
	@Path("/getBook/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public Book getBook(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		bd=new MethodsBook();
		return bd.GetBook(id);
		
	}
    
    @GET
	@Path("/getAllBook")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public  ArrayList<Book> getAllBook() throws ClassNotFoundException, SQLException {
		bd=new MethodsBook();
		return bd.GetAllBook();
		
	}
    
    @GET
	@Path("/getBookByDate/{date}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public  ArrayList<Book> getBookByDate(@PathParam("date") String date) throws ClassNotFoundException, SQLException {
		bd=new MethodsBook();
		return bd.GetBookByDate(date);
		
	}
    @GET
	@Path("/getBookByCategory/{id_category}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public  ArrayList<Book> getBookByCategory(@PathParam("id_categorry") int id_category) throws ClassNotFoundException, SQLException {
		bd=new MethodsBook();
		return bd.GetBookByCategory(id_category);
		
	}
    
    
   
}
