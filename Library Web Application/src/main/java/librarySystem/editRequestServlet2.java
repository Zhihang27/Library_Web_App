package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class editRequestServlet2
 */
public class editRequestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editRequestServlet2() {
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
        String idLibrary = request.getParameter("idLibrary");
        String title = request.getParameter("title");
        String authorFirstName = request.getParameter("authorFirstName");
        String authorLastName = request.getParameter("authorLastName");
        String moreInfo = request.getParameter("moreInfo");
        
        Request r = new Request();
        r.setID(id);
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setIDLibrary(idLibrary);
        r.setTitle(title);
        r.setAuthorFirstName(authorFirstName);
        r.setAuthorLastName(authorLastName);
        r.setMoreInfo(moreInfo);
        
        int status = RequestDAO.update(r);
        if (status > 0) {
            response.sendRedirect("viewRequestServlet");
        } else {
            out.println("Sorry, unable to update the request.");
        }
        
        out.close();
	}

}
