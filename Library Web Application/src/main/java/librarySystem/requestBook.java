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
 * Servlet implementation class requestBook
 */
public class requestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Request_Book_Form.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String idLibrary = request.getParameter("idLibrary");
		String title = request.getParameter("title");
		String authorFirstName = request.getParameter("authorFirstName");
		String authorLastName = request.getParameter("authorLastName");
		String moreInfo = request.getParameter("moreInfo");
		
		// setting filewriter to true for append mode, otherwise it would overwrite the file each time
		// FileWriter fw = new FileWriter("/Users/alex.chm/Documents/CMPSC221 SEC01/Eclipse/Library Web Application/saved_data/requestBook.csv", true);
		// PrintWriter pw = new PrintWriter(fw);
		// pw.println(firstName + "," + lastName + "," + idLibrary + "," + title + "," + authorFirstName + "," + authorLastName + "," + moreInfo);
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
			stm.execute("INSERT INTO `book_requests` (`id`, `firstName`, `lastName`, `idLibrary`, `title`, `authorFirstName`, "
					+ "`authorLastName`, `moreInfo`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '"+idLibrary+"', '"+title+"', "
							+ "'"+authorFirstName+"', '"+authorLastName+"', '"+moreInfo+"'); ");
			// stm.execute("INSERT INTO `book_requests` (`id`, `firstName`, `lastName`, `idLibrary`, `title`, `authorFirstName`, `authorLastName`, `moreInfo`) VALUES (NULL, '"+firstName+"', '"+lastName+"', '"+idLibrary+"', '"+title+"', '"+authorFirstName+"', '"+authorLastName+"', '"+moreInfo+"'); ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Success.html");

	}
}