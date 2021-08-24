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
import java.util.ArrayList;
import pojo.Visit;
import pojo.VisitDetails;
import pojo.VisitFilter;


public class VisitDAO {
	
	static String url;
	static {
		try {
			url = "jdbc:mysql://localhost:3306/Zoo?autoReconnect=true&useSSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static String visitNow(Visit visit) throws ClassNotFoundException, SQLException
	{
		int userId = visit.getuserId();
		System.out.println(userId);
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		String retrieve = "select userId, visitId from Visits group by userId, visitId having userId = ? order by visitId desc limit 1"; 
		String insert = "insert into Visits values (?,?,?,?)";
		String username = " select username from Customers where userId = " + userId;
		Connection connection = DriverManager.getConnection(url,"root","Legendary.1");
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
	
	public ArrayList<VisitDetails> getVisitDetails(VisitFilter filter) throws SQLException
	{
		int userId = filter.getUserId();
		int start = filter.getStart();
		int limit = filter.getLimit();	
		
		String detail = "select visitId, visitDate, animalName, amount " + 
				"from Visits v " + 
				"join Animals a on v.animalId = a.animalId " + 
				"where (userId = ? and visitId between ? and ?) "+ 
				"group by visitId, visitDate, animalName, amount " + 
				"order by visitId " ;
		Connection connection = DriverManager.getConnection(url,"root","Legendary.1");
		PreparedStatement statement = connection.prepareStatement(detail);
		statement.setInt(1, userId);
		statement.setInt(2, start);
		statement.setInt(3, (start + limit-1));		
		ResultSet set = statement.executeQuery();
		ArrayList<VisitDetails> detailList = new ArrayList<>();
		while(set.next()) {
			 int visitId = set.getInt(1);
             Date date = set.getDate(2);
    	   	 String animalName = set.getString(3);
    	   	 int amount = set.getInt(4);
    	     VisitDetails details = new VisitDetails(visitId,date,animalName,amount);
    	   	 detailList.add(details);
		}
		return detailList;
	}
}
