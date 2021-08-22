package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDAO;
import pojo.Visit;

/**
 * 
 */
@WebServlet("/Visit")
public class VisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisitServlet() {
        super();
    }

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Enumeration<String> names = request.getParameterNames();
		ArrayList<Integer> animalIds = new ArrayList<>();
		
		while(names.hasMoreElements())
		{
			String name = (String)names.nextElement();
			if(name.startsWith("animal"))
			{
				String parsedAnimalId = name.split("_")[1];
				int animalId = Integer.valueOf(parsedAnimalId);
				animalIds.add(animalId);	
			}
		}
		
		int userId = Integer.valueOf(request.getParameter("userId"));
		
		Visit visit = new Visit(userId,animalIds);
		
		try {
			String username = VisitDAO.visitNow(visit);
			response.sendRedirect("./jsp/user_home.jsp?userId=" + userId + "&username=" + username);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}

}
