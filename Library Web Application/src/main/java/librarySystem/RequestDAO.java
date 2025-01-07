package librarySystem;

import java.util.*;
import java.sql.*;

public class RequestDAO {
	
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
	
	public static int save(Request r) {
        int status = 0;
        
        try {
            Connection connection = RequestDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `book_requests` (`firstName`, `lastName`, `idLibrary`, `title`, `authorFirstName`, `authorLastName`, `moreInfo`) VALUES (?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, r.getFirstName());
            ps.setString(2, r.getLastName());
            ps.setString(3, r.getIDLibrary());
            ps.setString(4, r.getTitle());
            ps.setString(5, r.getAuthorFirstName());
            ps.setString(6, r.getAuthorLastName());
            ps.setString(7, r.getMoreInfo());
            
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
	
	public static int update(Request r) {
        int status = 0;
        
        try {
            Connection connection = RequestDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE `book_requests` SET firstName = ?, lastName = ?, idLibrary = ?, title = ?, authorFirstName = ?, authorLastName = ?, moreInfo = ? WHERE id = ?");
            ps.setString(1, r.getFirstName());
            ps.setString(2, r.getLastName());
            ps.setString(3, r.getIDLibrary());
            ps.setString(4, r.getTitle());
            ps.setString(5, r.getAuthorFirstName());
            ps.setString(6, r.getAuthorLastName());
            ps.setString(7, r.getMoreInfo());
            ps.setInt(8, r.getID());
            
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
            Connection connection = RequestDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM `book_requests` WHERE id = ?");
            ps.setInt(1, id);
            
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
	
	public static Request getRequestByID(int id) {
        Request r = new Request();
        
        try {
            Connection connection = RequestDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `book_requests` WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                r.setID(rs.getInt(1)); // "id"
                r.setFirstName(rs.getString(2)); // "firstName"
                r.setLastName(rs.getString(3));
                r.setIDLibrary(rs.getString(4));
                r.setTitle(rs.getString(5));
                r.setAuthorFirstName(rs.getString(6));
                r.setAuthorLastName(rs.getString(7));
                r.setMoreInfo(rs.getString(8));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return r;
    }
	
	public static List<Request> getAllRequests() {
        List<Request> list = new ArrayList<Request>();
        
        try {
            Connection connection = RequestDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `book_requests`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Request r = new Request();
                r.setID(rs.getInt(1));
                r.setFirstName(rs.getString(2));
                r.setLastName(rs.getString(3));
                r.setIDLibrary(rs.getString(4));
                r.setTitle(rs.getString(5));
                r.setAuthorFirstName(rs.getString(6));
                r.setAuthorLastName(rs.getString(7));
                r.setMoreInfo(rs.getString(8));
                list.add(r);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
