package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class editRequestServlet
 */
public class editRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editRequestServlet() {
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
        System.out.println("Received ID: " + sid);
        int id = Integer.parseInt(sid);
        
        Request r = RequestDAO.getRequestByID(id);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Edit Request Form</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form name='editRequestForm' method='post' action='editRequestServlet2'>");
        out.println("<input type='hidden' name='id' value='" + r.getID() + "'>");
        out.println("<h1>Edit Request</h1>");

        out.println("Student Name<br>");
        out.println("<input type='text' name='firstName' value='" + r.getFirstName() + "' placeholder='First'> <input type='text' name='lastName' value='" + r.getLastName() + "' placeholder='Last'>");
        out.println("<br><br>");

        out.println("Library ID<br>");
        out.println("<input type='text' name='idLibrary' value='" + r.getIDLibrary() + "'>");
        out.println("<br><br>");

        out.println("Book Title<br>");
        out.println("<input type='text' name='title' value='" + r.getTitle() + "'>");
        out.println("<br><br>");

        out.println("Author<br>");
        out.println("<input type='text' name='authorFirstName' value='" + r.getAuthorFirstName() + "' placeholder='First'> <input type='text' name='authorLastName' value='" + r.getAuthorLastName() + "' placeholder='Last'>");
        out.println("<br><br>");

        out.println("More information about the book requested:<br>");
        out.println("<textarea rows='8' cols='48' name='moreInfo'>" + r.getMoreInfo() + "</textarea>");
        out.println("<br><br>");

        out.println("<input type='submit' value='Edit & Save'>");
      
        out.println("</form>");
        out.println("<br>");
        out.println("<a href='viewRequestServlet'>Show Book Requests List</a>");

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
