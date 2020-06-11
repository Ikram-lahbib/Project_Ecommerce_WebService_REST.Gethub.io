package Enteties;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements  Serializable {
	
	private int id_user;
	private String User_Name;
	private String User_login;
	private String User_Password;
	private String Date_Add_User;
	private int Role;
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_login() {
		return User_login;
	}
	public void setUser_login(String user_login) {
		User_login = user_login;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	public String getDate_Add_User() {
		return Date_Add_User;
	}
	public void setDate_Add_User(String date_Add_User) {
		Date_Add_User = date_Add_User;
	}
	
	public int getRole() {
		return Role;
	}
	public void setRole(int role) {
		Role = role;
	}
	public User(String user_Name, String user_login, String user_Password, String date_Add_User,int role) {
		super();
		User_Name = user_Name;
		User_login = user_login;
		User_Password = user_Password;
		Date_Add_User = date_Add_User;
		Role=role;
		
	}
	public User() {
		super();
	}
	 

}
