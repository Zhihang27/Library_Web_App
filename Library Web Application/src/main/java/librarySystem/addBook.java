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
 * Servlet implementation class newBook
 */
public class addBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Add_Book_Form.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String summary = request.getParameter("summary");
		String isbn = request.getParameter("isbn");
		String genre = request.getParameter("genre");
		
		// setting filewriter to true for append mode, otherwise it would overwrite the file each time
		// FileWriter fw = new FileWriter("/Users/alex.chm/Documents/CMPSC221 SEC01/Eclipse/Library Web Application/saved_data/addBook.csv", true);
		// PrintWriter pw = new PrintWriter(fw);
		// pw.println(title + "," + author + "," + summary + "," + isbn + "," + genre);
		// pw.close();
		// fw.close();
		// response.getWriter().append(title + "," + author + "," + summary + "," + isbn + "," + genre);
		
		try {
			// mysql driver load
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/libraryWebAppDB", "root", "");
			
			// execute sql command
			Statement stm = connection.createStatement();
			
			// execute a statement
			stm.execute("INSERT INTO `books` (`id`, `title`, `author`, `summary`, `isbn`, `genre`) VALUES (NULL, '"+title+"', "
					+ "'"+author+"', '"+summary+"', '"+isbn+"', '"+genre+"'); ");
			// stm.execute("INSERT INTO `books` (`id`, `title`, `author`, `summary`, `isbn`, `genre`) VALUES (NULL, '"+title+"', '"+author+"', '"+summary+"', '"+isbn+"', '"+genre+"'); ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// response.getWriter().append(e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			// response.getWriter().append(e.toString());
		}
		
		response.sendRedirect("Success.html");
	}
}
