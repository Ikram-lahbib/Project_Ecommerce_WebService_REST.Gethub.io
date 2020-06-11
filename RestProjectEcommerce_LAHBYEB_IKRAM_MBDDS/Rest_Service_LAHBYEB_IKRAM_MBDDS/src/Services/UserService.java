package Services;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Enteties.Book;
import Enteties.User;
import Model.MethodsBook;
import Model.MethodsUsers;


@Path("/UserService")
public class UserService {
	MethodsUsers ud=null;
	User u=new User();
	
	@POST
	@Path("/addUser")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public void AddUser(User u) throws ClassNotFoundException, SQLException {
		ud=new MethodsUsers();
		ud.AddUser(u);
		
	}
	
	@GET
	@Path("/authUser/{login}/{password}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public User authUser(@PathParam("login") String login,@PathParam("password") String password) throws ClassNotFoundException, SQLException {
		ud=new MethodsUsers();
		return ud.AuthUser(login, password);
		
	}
	
	@GET
	@Path("/getUser/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public User getUser(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		ud=new MethodsUsers();
		return ud.GetUser(id);
		
	}
   
	
}
