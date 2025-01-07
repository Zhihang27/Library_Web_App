package librarySystem;

import java.util.*;
import java.sql.*;

public class BookDAO {
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection("jdbc:mysql://localhost/libraryWebAppDB", "root", "");
		} catch (Exception e)  {
			System.out.println(e);
		}
		return connection;
	}
	
	public static int save(Book b) {
		int status = 0;
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `books` (`title`, `author`, `summary`, `isbn`, `genre`) VALUES (?, ?, ?, ?, ?); ");
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getSummary());
			ps.setString(4, b.getISBN());
			ps.setString(5, b.getGenre());
			
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int update(Book b) {
		int status = 0;
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE `books` SET title = ?, author = ?, summary = ?, isbn = ?, genre = ? WHERE id = ? ");
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getSummary());
			ps.setString(4, b.getISBN());
			ps.setString(5, b.getGenre());
			ps.setInt(6, b.getID());
			
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id) {
		int status = 0;
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `books` WHERE id = ? ");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Book getBookByID(int id) {
		Book b = new Book();
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `books` WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b.setID(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setSummary(rs.getString(4));
				b.setISBN(rs.getString(5));
				b.setGenre(rs.getString(6));
			} 
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
		
	}
	
	public static List <Book> getAllBooks() {
		List<Book> list = new ArrayList <Book>();
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `books`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setID(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setSummary(rs.getString(4));
				b.setISBN(rs.getString(5));
				b.setGenre(rs.getString(6));
				list.add(b);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
