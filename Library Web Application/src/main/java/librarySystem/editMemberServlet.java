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
public class editMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMemberServlet() {
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
		
		Member m = MemberDAO.getMemberByID(id);
		
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Edit Member Form</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<form name='editMemberForm' method='post' action='editMemberServlet2'>");
        out.println("<h1>Edit Member</h1>");
        out.println("<input type='hidden' name='id' value='" + m.getID() + "'>");

        out.println("Name<br>");
        out.println("<input type='text' name='firstName' value='" + m.getFirstName() + "' placeholder='First Name'> <input type='text' name='lastName' value='" + m.getLastName() + "' placeholder='Last Name'>");
        out.println("<br><br>");

        out.println("Student Number<br>");
        out.println("<input type='text' name='idNumber' value='" + m.getIDNumber() + "' placeholder='ex: 1234567'>");
        out.println("<br><br>");

        out.println("Faculty<br>");
        out.println("<select name='facultyCat'>");
        out.println("<option value='Professor'" + (m.getFacultyCat().equals("Professor") ? " selected" : "") + ">Professor</option>");
        out.println("<option value='Associate Professor'" + (m.getFacultyCat().equals("Associate Professor") ? " selected" : "") + ">Associate Professor</option>");
        out.println("<option value='Research Professor'" + (m.getFacultyCat().equals("Research Professor") ? " selected" : "") + ">Research Professor</option>");
        out.println("</select>");
        out.println("<br><br>");

        out.println("Department<br>");
        out.println("<input type='text' name='department' value='" + m.getDepartment() + "'>");
        out.println("<br><br>");

        out.println("Phone Number<br>");
        out.println("<input type='text' name='phoneNumber' value='" + m.getPhoneNumber() + "' placeholder='(000) 000-0000'><br>");
        out.println("<i>Please enter a valid phone number.</i>");
        out.println("<br><br>");

        out.println("Email<br>");
        out.println("<input type='text' name='email' value='" + m.getEmail() + "' placeholder='example@example.com'><br>");
        out.println("<i>Please enter a valid email.</i>");
        out.println("<br><br>");

        out.println("<input type='submit' value='Edit & Save'>");
        out.println("</form>");
        out.println("<br>");
        out.println("<a href='viewMemberServlet'>Show Member List</a>");

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
