package librarySystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class showBookList
 */
public class showMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showMemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter responseWriter = response.getWriter();
		// identify the path to the file so it can be read on the webpage
		// String pathToFile = "/Users/alex.chm/Documents/CMPSC221 SEC01/Eclipse/Library Web Application/saved_data/newMember.csv";
        
		try {
			// mysql driver load
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/libraryWebAppDB", "root", "");
			// execute sql command
			Statement stm = connection.createStatement();
			// execute a statement
			ResultSet resultSet = stm.executeQuery("SELECT * FROM members");
			
			responseWriter.println("<!DOCTYPE html>");
			responseWriter.println("<html><head><title>Library Members</title></head><body>");
			responseWriter.println("<h1>List of Library Members:</h1>");
			responseWriter.println("<table border='1'> <tr> <th>ID</th> <th>First Name</th> <th>Last Name</th> <th>Student Number</th> <th>Faculty</th> <th>Department</th> <th>Phone Number</th> <th>Email</th>");
			
			// use result set to print
			while(resultSet.next()) {
				responseWriter.println("<tr>");
				responseWriter.println("<td>" + resultSet.getString(1) + "</td>");
				responseWriter.println("<td>" + resultSet.getString(2) + "</td>");
				responseWriter.println("<td>" + resultSet.getString(3) + "</td>");
				responseWriter.println("<td>" + resultSet.getString(4) + "</td>");
				responseWriter.println("<td>" + resultSet.getString(5) + "</td>");
				responseWriter.println("<td>" + resultSet.getString(6) + "</td>");
				responseWriter.println("<td>" + resultSet.getString(7) + "</td>");
				responseWriter.println("<td>" + resultSet.getString(8) + "</td>");
				responseWriter.println("</tr>");
			}
			
			responseWriter.println("</table>");
			responseWriter.println("</body></html>");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// read all the books from the .csv file using a Scanner
        // Scanner scanner = new Scanner(new File(pathToFile));
        // while (scanner.hasNextLine()) {
            // String member = scanner.nextLine();
            // // out.println(member + "<br>"); // it prints each book on a new line but without correct formatting
            // // split each book into an array and then join the elements with a ", "
            // String[] memberDetails = member.split(","); 
            // String formattedOutput = String.join(", ", memberDetails);
            // responseWriter.println(formattedOutput + "<br>");
        // }
        
        // scanner.close();
        
        // responseWriter.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
