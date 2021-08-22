package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import pojo.Visit;


public class VisitDAO {
	
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


	public static String visitNow(Visit visit) throws ClassNotFoundException, SQLException
	{
		int userId = visit.getuserId();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		String retrieve = "select userId, visitId from Visits group by userId, visitId having userId = ? order by visitId desc limit 1"; 
		String insert = "insert into Visits values (?,?,?,?)";
		String username = " select username from Customers where userId = " + userId;
		Connection connection = DriverManager.getConnection(url,"root","");
		PreparedStatement statement = connection.prepareStatement(retrieve);
		statement.setInt(1, userId);
		ResultSet rs = statement.executeQuery();
		
		int nextVisit = 1;
		if(rs.next())
		{
			nextVisit = rs.getInt(2)+ 1;
		}
				
		PreparedStatement st = connection.prepareStatement(insert);
		
		for(int animalId : visit.getanimalIds())
		{
			st.setInt(1, userId);
			st.setInt(2, animalId);
			st.setInt(3, nextVisit);
			st.setDate(4, date);
			st.executeUpdate();
			
		}
		
		Statement stat = connection.createStatement();
		ResultSet resultSet = stat.executeQuery(username);
		
		username = "";
		if(resultSet.next())
		{
			username = resultSet.getString(1);
		}
		
		connection.close();
		return username;
	}
}
