package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import Enteties.User;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/UserService");
		User u =new User();
		
		if(request.getParameter("op").equals("register-submit")) {
		
		String Username=request.getParameter("username");
		String Password=request.getParameter("password");
		String Login=request.getParameter("email");
		String Date=request.getParameter("date");
		u.setUser_Name(Username);
		u.setUser_Password(Password);
		u.setUser_login(Login);
		u.setDate_Add_User(Date);
		u.setRole(2);
		target.path("/addUser").request().post(Entity.json(u));
		HttpSession ses = request.getSession();
		ses.setAttribute("username", u.getUser_Name());
		ses.setAttribute("iduser", u.getId_user());
		ses.setAttribute("loginuser", u.getUser_login());
		response.sendRedirect("Home.jsp");
	  }
		if(request.getParameter("op").equals("Log In")) {
			String Password=request.getParameter("password");
			String Login=request.getParameter("email");
			u=target.path("/authUser/"+Login+"/"+Password).request().get(User.class);
			if(u!=null)
			{
				if(u.getRole()==1) {
					response.sendRedirect("AddBook.jsp");
				}
				else {
				HttpSession ses = request.getSession();
				ses.setAttribute("username", u.getUser_Name());
				ses.setAttribute("iduser", u.getId_user());
				ses.setAttribute("loginuser", u.getUser_login());
				response.sendRedirect("Home.jsp");
				}
			}else {
				response.sendRedirect("Register.jsp");
			
		}
		}
		
		
		
		
	}

}
