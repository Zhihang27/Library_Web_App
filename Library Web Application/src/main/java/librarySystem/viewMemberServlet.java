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
public class viewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='Library_Membership_Form.html'>Add New Member</a>");
		out.println("<h1>Member List</h1>");
		List<Member> list = MemberDAO.getAllMembers();
		
		out.println("<table border='1' width='100%'>");
	    out.println("<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>ID Number</th><th>Faculty Category</th><th>Department</th><th>Phone Number</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");
		for (Member m:list) {
			out.println("<tr><td>" + m.getID() + "</td><td>" + m.getFirstName() + "</td><td>" + m.getLastName() + "</td>");
	        out.println("<td>" + m.getIDNumber() + "</td><td>" + m.getFacultyCat() + "</td><td>" + m.getDepartment() + "</td>");
	        out.println("<td>" + m.getPhoneNumber() + "</td><td>" + m.getEmail() + "</td>");
	        out.println("<td><a href='editMemberServlet?id=" + m.getID() + "'>edit</a></td>");
	        out.println("<td><a href='deleteMemberServlet?id=" + m.getID() + "'>delete</a></td></tr>");
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
