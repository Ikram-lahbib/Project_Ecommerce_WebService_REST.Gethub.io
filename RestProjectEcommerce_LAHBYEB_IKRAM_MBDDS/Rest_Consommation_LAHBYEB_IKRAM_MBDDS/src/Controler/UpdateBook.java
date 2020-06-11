package Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import Enteties.Book;
import Enteties.Category;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
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
		WebTarget target = client.target("http://localhost:8081/RestProjectEcommerce/rest/BookService");
		Book b=new Book();
		Category c =new Category();
		int id_book=Integer.parseInt(request.getParameter("id_book"));
		String Name=request.getParameter("name");
		String Writer=request.getParameter("writer");
		String Image=request.getParameter("image");
		double Price=Double.parseDouble(request.getParameter("price"));
		int Stock =Integer.parseInt(request.getParameter("stock"));
		int id_Category=Integer.parseInt(request.getParameter("category"));
		String Date =request.getParameter("date");
		String Summary=request.getParameter("summary");
		c.setId_Catygory(id_Category);
		b.setBook_Name(Name);
		b.setWriter_Name(Writer);
		b.setBook_Image(Image);
		b.setBook_Price(Price);
		b.setBook_Stock(Stock);
		b.setBook_Catygory(c);
		b.setDate_Add_Book(Date);
		b.setBook_Summary(Summary);
		target.path("/updateBook/"+ id_book).request().put(Entity.json(b));
        response.sendRedirect("AllBook.jsp");
	}

}
