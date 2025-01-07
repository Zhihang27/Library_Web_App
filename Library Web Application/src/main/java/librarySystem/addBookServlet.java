package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class addBookServlet
 */
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String summary = request.getParameter("summary");
		String isbn = request.getParameter("isbn");
		String[] genres = request.getParameterValues("genre");
		String genre = (genres != null) ? String.join(", ", genres) : "";
		// String genre = request.getParameter("genre");
		
		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setSummary(summary);
		b.setISBN(isbn);
		b.setGenre(genre);
		
		int status = BookDAO.save(b);
		if (status > 0) {
			out.print("<p>Book saved successfully!</p>");
			request.getRequestDispatcher("Add_Book_Form.html").include(request, response);
		} else {
			out.println("Sorry, unable to save the book.");
		}
		
		out.close();
		
	}

}
