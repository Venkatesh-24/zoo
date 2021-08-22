package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import pojo.Visitor;

/**
 * 
 */
@WebServlet("/SignUp")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
    }

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String emailId = request.getParameter("emailId");
			String country = request.getParameter("country");
			Visitor visitor = new Visitor(username,password,emailId,country);
			Integer userId = null;			
			userId = LoginDAO.validateLogin(visitor);
			
			if(userId!= null)
			{
				// add alert for user already signed up
				response.sendRedirect("./jsp/login.jsp");
			}
			else {
				Integer newUserId = null;
				newUserId = LoginDAO.Signup(visitor);
				
				if(newUserId != null)
				{
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					String url = "./jsp/user_home.jsp?userId=" + newUserId + "&username=" + username;
					response.sendRedirect(url);
				}
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
