package Enteties;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Category")
public class Category implements  Serializable{
	
	private int id_Catygory;
	   private String Name_Category;
	   private String Image_Category;
	   private String Description_Category;
	   
	   
	public int getId_Catygory() {
		return id_Catygory;
	}
	public void setId_Catygory(int id_Catygory) {
		this.id_Catygory = id_Catygory;
	}
	public String getName_Category() {
		return Name_Category;
	}
	public void setName_Category(String name_Category) {
		Name_Category = name_Category;
	}


	public String getImage_Category() {
		return Image_Category;
	}
	public void setImage_Category(String image_Category) {
		Image_Category = image_Category;
	}
	public String getDescription_Category() {
		return Description_Category;
	}
	public void setDescription_Category(String description_Category) {
		Description_Category = description_Category;
	}

	public Category(String name_Category, String image_Category, String description_Category) {
		super();
		Name_Category = name_Category;
		Image_Category = image_Category;
		Description_Category = description_Category;
	}
	public Category() {
		super();
	}



}
