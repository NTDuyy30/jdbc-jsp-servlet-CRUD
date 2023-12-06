package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.UserDAOHandler;
import model.User;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/load-by-id":
				this.loadUserById(request, response);
				break;
			case "/add":
				this.addUser(request, response);
				break;
			case "/delete":
				this.deleteUser(request, response);
				break;
			case "/update":
				this.updateUser(request, response);
				break;
			default:
				this.loadAllUser(request, response);
				break;
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> items = new UserDAOHandler().getUsers(null, (byte)20);
		request.setAttribute("items", items);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
	
	private void loadUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new UserDAOHandler().getUserById(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("FormUpdate.jsp").forward(request, response);
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		User user = new User();
		
		String idStr = request.getParameter("id");
		if (idStr != "") {
			int id = Integer.parseInt(idStr);
			user.setId(id);
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user.setUsername(username);
		user.setPassword(password);
		
		if (new UserDAOHandler().addUser(user)) {
			response.sendRedirect("load");
		} else {
			pw.append("<h1>ID exsist</h1>");
			pw.append("<h2><a href=\"load\">Back to Home</a></h2>");
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new UserDAOHandler().deleteUser(id);
		response.sendRedirect("load");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		new UserDAOHandler().updateUser(new User(id, username, password));
		response.sendRedirect("load");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
