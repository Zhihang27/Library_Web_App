package librarySystem;

import java.util.*;
import java.sql.*;

public class MemberDAO {
	
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
	
	public static int save(Member m) {
		int status = 0;
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `members` (`firstName`, `lastName`, `idNumber`, `facultyCat`, `department`, `phoneNumber`, `email`) VALUES (?, ?, ?, ?, ?, ?, ?); ");
			ps.setString(1, m.getFirstName());
			ps.setString(2, m.getLastName());
			ps.setString(3, m.getIDNumber());
			ps.setString(4, m.getFacultyCat());
			ps.setString(5, m.getDepartment());
			ps.setString(6, m.getPhoneNumber());
			ps.setString(7, m.getEmail());
			
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int update(Member m) {
		int status = 0;
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE `members` SET firstName = ?, lastName = ?, idNumber = ?, facultyCat = ?, department = ?, phoneNumber = ?, email = ? WHERE id = ? ");
			ps.setString(1, m.getFirstName());
			ps.setString(2, m.getLastName());
			ps.setString(3, m.getIDNumber());
			ps.setString(4, m.getFacultyCat());
			ps.setString(5, m.getDepartment());
			ps.setString(6, m.getPhoneNumber());
			ps.setString(7, m.getEmail());
			ps.setInt(8, m.getID());
			
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
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `members` WHERE id = ? ");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Member getMemberByID(int id) {
		Member m = new Member();
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `members` WHERE id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				m.setID(rs.getInt(1));
				m.setFirstName(rs.getString(2));
				m.setLastName(rs.getString(3));
				m.setIDNumber(rs.getString(4));
				m.setFacultyCat(rs.getString(5));
				m.setDepartment(rs.getString(6));
				m.setPhoneNumber(rs.getString(7));
				m.setEmail(rs.getString(8));
			} 
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
		
	}
	
	public static List <Member> getAllMembers() {
		List<Member> list = new ArrayList <Member>();
		
		try {
			Connection connection = BookDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `members`");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setID(rs.getInt(1));
				m.setFirstName(rs.getString(2));
				m.setLastName(rs.getString(3));
				m.setIDNumber(rs.getString(4));
				m.setFacultyCat(rs.getString(5));
				m.setDepartment(rs.getString(6));
				m.setPhoneNumber(rs.getString(7));
				m.setEmail(rs.getString(8));
				list.add(m);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
