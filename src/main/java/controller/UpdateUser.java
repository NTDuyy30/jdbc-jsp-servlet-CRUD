package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.UserDAOHandler;
import model.User;

/**
 * Servlet implementation class adduser
 */
@WebServlet(name = "UpdateUser", urlPatterns = { "/update-user" })
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=utf-8";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new UserDAOHandler().getUserById(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("user", user.getUsername());
		session.setAttribute("pass", user.getPassword());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormUpdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
