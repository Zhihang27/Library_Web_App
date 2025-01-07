package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class editMemberServlet2
 */
public class editMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMemberServlet2() {
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
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String idNumber = request.getParameter("idNumber");
		String facultyCat = request.getParameter("facultyCat");
		String department = request.getParameter("department");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
		Member m = new Member();
		m.setID(id);
		m.setFirstName(firstName);
		m.setLastName(lastName);
		m.setIDNumber(idNumber);
		m.setFacultyCat(facultyCat);
		m.setDepartment(department);
		m.setPhoneNumber(phoneNumber);
		m.setEmail(email);
		
		int status = MemberDAO.update(m);
		if(status > 0) {
			response.sendRedirect("viewMemberServlet");
		} else {
			out.println("Sorry, unable to update the member.");
		}
		
		out.close();
	}

}
