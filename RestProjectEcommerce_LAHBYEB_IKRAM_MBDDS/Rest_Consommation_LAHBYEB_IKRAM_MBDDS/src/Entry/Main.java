package Entry;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Enteties.Category;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

//import Beans.Category;

public class Main {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/Categories/getAllCategory");
		/*try {
			System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		List<Category> categorys = target.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(new GenericType<List<Category>>(){});
	     
	     for(Category b : categorys) {
	     System.out.println(b.getName_Category());
	      }
		//String cat=target.request(MediaType.APPLICATION_JSON).get(String.class);
		//serialiser(cat);
		//System.out.println(cat);
		//XmlMapper xmlMapper = new XmlMapper();
		//Category[] value = xmlMapper.readValue(cat, Category[].class);
		
		/*ObjectMapper mapper = new ObjectMapper();
		try {
			Category[] categorie=mapper.readValue(cat,Category[].class);
			for(Category c:categorie) {
				System.out.println(c.getName_Category());
			}
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
}
	
}
