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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Visitor visitor = new Visitor(username,password);
		Integer userId = null;
		
		try {
			userId = LoginDAO.validateLogin(visitor);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(userId != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);		
			System.out.println("UserId : " + userId + " , name : " + username);
			
			response.sendRedirect("./jsp/user_home.jsp?userId=" + userId + "&username=" + username);
				// userId and userName is sent to client for further request handling
		}
		else {
			response.sendRedirect("./jsp/login.jsp");
		}
	}

}
