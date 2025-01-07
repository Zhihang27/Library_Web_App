package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class editBookServlet
 */
public class editBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		System.out.println("Received ID: " + sid); // was used for debugging purposes
		int id = Integer.parseInt(sid);
		
		Book b = BookDAO.getBookByID(id);
		
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Book Form</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Edit Book</h1>");
        out.println("<form method = 'post' action = 'editBookServlet2'>");
        out.println("<input type='hidden' name='id' value='" + b.getID() + "'>");
        out.println("<b>Title:</b>");
        out.println("<input type ='text' name ='title' value ='" + b.getTitle() + "' placeholder='Name of book'><br><br>");
        out.println("<b>Author:</b>");
        out.println("<input type ='text' name ='author' value ='" + b.getAuthor() + "' placeholder='Author of book'><br><br>");
        out.println("<b>Summary:</b>");
        out.println("<input type ='text' name ='summary' value ='" + b.getSummary() + "' placeholder='Summary'><br><br>");
        out.println("<b>ISBN:</b>");
        out.println("<input type ='text' name ='isbn' value ='" + b.getISBN() + "' placeholder='ISBN13'><br><br>");
        out.println("<b>Genre:</b>");
        
        out.println("<input type ='checkbox' name ='genre' value ='Fantasy'" + 
                (b.getGenre().contains("Fantasy") ? " checked" : "") + "/> Fantasy");
        out.println("<input type ='checkbox' name ='genre' value ='Science Fiction'" + 
                (b.getGenre().contains("Science Fiction") ? " checked" : "") + "/> Science Fiction");
        out.println("<input type ='checkbox' name ='genre' value ='Action'" + 
                (b.getGenre().contains("Action") ? " checked" : "") + "/> Action<br>");
        
        out.println("<br><br>");
        out.println("<input type ='submit' value ='Edit & Save'>");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>");
        out.close();	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
