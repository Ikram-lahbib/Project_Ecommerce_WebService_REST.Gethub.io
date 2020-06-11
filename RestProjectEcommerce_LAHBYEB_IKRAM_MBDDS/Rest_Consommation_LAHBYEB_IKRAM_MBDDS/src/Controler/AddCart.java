package Controler;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.ws.rs.core.MediaType;

import Enteties.Book;
import Enteties.Cart;
import Enteties.User;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/CartService");
		WebTarget target2 = client.target("http://localhost:8081/RestProjectEcommerce/rest/BookService");
		WebTarget target3 = client.target("http://localhost:8081/RestProjectEcommerce/rest/UserService");
		int id_book=Integer.parseInt(request.getParameter("id_book"));
		HttpSession ses = request.getSession();
		int id_user =(int)ses.getAttribute("iduser");
		Book b=new Book();
		User u=new User();
		b=target2.path("/getBook/"+ id_book).request(MediaType.APPLICATION_JSON).get(Book.class);
		u=target3.path("/getUser/"+ id_user).request(MediaType.APPLICATION_JSON).get(User.class);
		Cart c=new Cart(u.getId_user(),b.getBook_Image(),b.getBook_Name(),b.getBook_Price());
		target.path("/addCartObj").request().post(Entity.json(c));
		response.sendRedirect("AddCart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
