package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDAO;
import pojo.VisitDetails;
import pojo.VisitFilter;
/**
 * 
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// params userId, later range can be used like 1 to 10
		int userId = Integer.valueOf(request.getParameter("userId"));
		int from = Integer.valueOf(request.getParameter("from"));
		int limit = Integer.valueOf(request.getParameter("limit"));
		
		VisitFilter filter = new VisitFilter(userId,from,limit);
		
		VisitDAO dao = new VisitDAO();
		try {
			ArrayList<VisitDetails> detailList = dao.getVisitDetails(filter);
			request.setAttribute("detailList", detailList);
			String url = "/jsp/user_details.jsp?userId=" + userId + "&from=" + from + "&limit=" + limit;
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
