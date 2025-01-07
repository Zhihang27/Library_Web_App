package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Servlet implementation class viewBookServlet
 */
public class viewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='Add_Book_Form.html'>Add New Book</a>");
		out.println("<h1>Book List</h1>");
		List<Book> list = BookDAO.getAllBooks();
		
		out.println("<table border='1' width='100%'>");
		out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Summary</th><th>ISBN</th><th>Genre</th><th>Edit</th><th>Delete</th></tr>");
		for (Book b:list) {
			out.println("<tr><td>" + b.getID() + "</td><td>" + b.getTitle() + "</td><td>" + b.getAuthor() + "</td>");
			out.println("<td>" + b.getSummary() + "</td><td>" + b.getISBN() + "</td><td>" + b.getGenre() + "</td>");
			out.println("<td><a href='editBookServlet?id=" + b.getID() + "'>edit</a></td>");
			out.println("<td><a href='deleteBookServlet?id=" + b.getID() + "'>delete</a></td></tr>");
		}
		out.println("</table>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
