package Services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Enteties.Book;
import Enteties.Cart;
import Enteties.User;
import Model.MethodsCart;

@Path("/CartService")
public class CartService {
  MethodsCart cd=null;
  Book b=new Book();
  User u=new User();
  
  
  @POST
  @Path("/addCartObj")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public void addCartObj( Cart c) throws ClassNotFoundException, SQLException {
		cd=new MethodsCart();
		cd.AddCartObj(c);
		
	}
  
  
  @GET
  @Path("/getCartByUser/{id_user}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public ArrayList<Cart> getCartByUser(@PathParam("id_user") int id_user)throws ClassNotFoundException, SQLException{
	  cd=new MethodsCart();
	return cd.GetCartByUser(id_user);
  }
  
  @GET
  @Path("/getUser/{id_user}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public User getUser(@PathParam("id_user") int id_user)throws ClassNotFoundException, SQLException{
	  cd=new MethodsCart();
	return cd.getUser(id_user);
  }
  
  @GET
  @Path("/getBook/{id_book}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Book getBook(@PathParam("id_book") int id_book)throws ClassNotFoundException, SQLException{
	  cd=new MethodsCart();
	return cd.getBook(id_book);
  }
  
  @DELETE
  @Path("/deleteFromCart/{id_cart}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public void DeleteFromCart(@PathParam("id_cart") int id_cart)throws ClassNotFoundException, SQLException{
	  cd=new MethodsCart();
	  cd.DeleteFromCart(id_cart);
  }
	
}
