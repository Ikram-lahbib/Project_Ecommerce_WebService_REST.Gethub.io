package Services;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Enteties.Category;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import Model.MethodsCategory;


//@Singleton
@Path("/Categories")
public class CategoryService {
	MethodsCategory mc=null ;
	public CategoryService () throws ClassNotFoundException, SQLException {
		mc=new MethodsCategory();
	}
	@POST
	@Path("/addCategory/{name}/{image}/{desc}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes(MediaType.APPLICATION_XML)
	 public void AddCategory(@PathParam("name") String name,@PathParam("image") String image,@PathParam("desc") String desc) throws ClassNotFoundException, SQLException {
		mc.AddCategory(name, image, desc);
	}
	
	@POST
	@Path("/addCategoryobj")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes(MediaType.APPLICATION_XML)
	 public void AddCategoryObj(Category c) throws ClassNotFoundException, SQLException {
		mc.AddCategoryObj(c);
	}
	
	
	@PUT
	@Path("/updateCategory/{id}/{name}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes(MediaType.APPLICATION_XML)
	public void UpdateCategory(@PathParam("id")int id,@PathParam("name") String name) throws ClassNotFoundException, SQLException {
		mc.UpdateCategory(id, name);
	}
	
	@DELETE
	@Path("/deleteCategory/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes(MediaType.APPLICATION_XML)
	public void deleteCategory(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		mc.DeleteCategory(id);
	}
	
	@GET
	@Path("/getAllCategory")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Category> getALLCategory() throws SQLException{
		return mc.GetALLCategory();
		
	}
	@GET
	@Path("/getCategoryName/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes(MediaType.APPLICATION_XML)
	public String getCategoryName(@PathParam("id") int id) throws ClassNotFoundException, SQLException{
		return mc.getCategoryName(id);
		
	}
	
	
	@GET
	@Path("/getCategory/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//@Consumes(MediaType.APPLICATION_XML)
	public Category getCategory(@PathParam("id") int id) throws ClassNotFoundException, SQLException{
		return mc.getCategory(id);
		
	}
    

    
    
	
	
	

}
