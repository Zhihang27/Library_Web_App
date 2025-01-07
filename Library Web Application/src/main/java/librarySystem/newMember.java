package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class newMember
 */
public class newMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Library_Membership_Form.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String idNumber = request.getParameter("idNumber");
		String facultyCat = request.getParameter("facultyCat");
		String department = request.getParameter("department");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
		// setting filewriter to true for append mode, otherwise it would overwrite the file each time
		// FileWriter fw = new FileWriter("/Users/alex.chm/Documents/CMPSC221 SEC01/Eclipse/Library Web Application/saved_data/newMember.csv", true); 
		// PrintWriter pw = new PrintWriter(fw);
		// pw.println(firstName + "," + lastName + "," + idNumber + "," + facultyCat + "," + department + "," + phoneNumber + "," + email);
		// pw.close();
		// fw.close();
		
		try {
			// mysql driver load
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/libraryWebAppDB", "root", "");
			
			// execute sql command
			Statement stm = connection.createStatement();
			
			// execute a statement
			stm.execute("INSERT INTO `members` (`id`, `firstName`, `lastName`, `idNumber`, `facultyCat`, `department`, "
					+ "`phoneNumber`, `email`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '"+idNumber+"', '"+facultyCat+"', "
							+ "'"+department+"', '"+phoneNumber+"', '"+email+"'); ");
			// stm.execute("INSERT INTO `members` (`id`, `firstName`, `lastName`, `idNumber`, `facultyCat`, `department`, `phoneNumber`, `email`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '"+idNumber+"', '"+facultyCat+"', '"+department+"', '"+phoneNumber+"', '"+email+"'); ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Success.html");
	}
}
