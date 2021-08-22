package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Visitor;

public class LoginDAO {
	
	static String url;
	static {
		try {
			url = "jdbc:mysql://localhost:3306/ZooProject?autoReconnect=true&useSSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Integer validateLogin(Visitor visitor) throws SQLException, ClassNotFoundException
	{		
		Connection connection = DriverManager.getConnection(url,"root","");
		String query = "select * from Customers where username = ? and password = ?";   
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, visitor.getUsername());
		statement.setString(2, visitor.getPassword());
		ResultSet result = statement.executeQuery();
		
		Integer id = null;
		if(result.next())
		{
			id =  result.getInt(1);
		}
		
		connection.close();
		return id;
		
	}
	
	public static Integer Signup(Visitor visitor) throws SQLException, ClassNotFoundException
	{
		Connection connection = DriverManager.getConnection(url,"root","");
		String query = "insert into Customers (username,emailId,password,country) values (?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, visitor.getUsername());
		statement.setString(2, visitor.getEmailId());
		statement.setString(3, visitor.getPassword());
		statement.setString(4, visitor.getCountry());	
		statement.executeUpdate();
		String getId = "select * from Customers where username = ? and password = ?";
		PreparedStatement st = connection.prepareStatement(getId);
		st.setString(1, visitor.getUsername());
		st.setString(2, visitor.getPassword());
		
		ResultSet set  = st.executeQuery();
		
		Integer userId = null;
		
		if(set.next())
		{
			userId = set.getInt(1);
		}
		
		connection.close();
		return userId;
		
	}

}
