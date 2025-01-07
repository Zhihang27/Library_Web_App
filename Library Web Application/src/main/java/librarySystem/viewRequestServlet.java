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
 * Servlet implementation class viewRequestServlet
 */
public class viewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='Request_Book_Form.html'>Add New Request</a>");
        out.println("<h1>Request List</h1>");
        List<Request> list = RequestDAO.getAllRequests();
        
        out.println("<table border='1' width='100%'>");
        out.println("<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Library ID</th><th>Title</th><th>Author First Name</th><th>Author Last Name</th><th>More Info</th><th>Edit</th><th>Delete</th></tr>");
        for (Request r:list) {
            out.println("<tr><td>" + r.getID() + "</td><td>" + r.getFirstName() + "</td><td>" + r.getLastName() + "</td>");
            out.println("<td>" + r.getIDLibrary() + "</td><td>" + r.getTitle() + "</td>");
            out.println("<td>" + r.getAuthorFirstName() + "</td><td>" + r.getAuthorLastName() + "</td>");
            out.println("<td>" + r.getMoreInfo() + "</td>");
            out.println("<td><a href='editRequestServlet?id=" + r.getID() + "'>edit</a></td>");
            out.println("<td><a href='deleteRequestServlet?id=" + r.getID() + "'>delete</a></td></tr>");
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
