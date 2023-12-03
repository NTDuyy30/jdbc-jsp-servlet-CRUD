package view;

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
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		UserDAOHandler userDaoHandler = new UserDAOHandler();
		
		out.append("<!doctype html>");
		out.append("<html lang=\"en\">");
		out.append("<head>");
		out.append("<meta charset=\"utf-8\">");
		out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.append("<title>Bootstrap demo</title>");
		out.append("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">");
		out.append("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\" integrity=\"sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.append("</head>");
		out.append("<body>");
		
		out.append("<div class=\"container\">");
//		title
		out.append("<h1 class=\"text-center\">User list</h1>");
		out.append("<hr>");
		
//		Add user
		out.append("<div style=\"margin-bottom:10px;\">");
		out.append("<a href=\"form.jsp\" class=\"btn btn-primary\">Add User</a>");
		out.append("</div>");
		
//		table data
		out.append("<div class=\"card\">");
		out.append("<div class=\"card-body\">");
		out.append("<table class=\"table table-striped\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th scope=\"col\">Id</th>");
		out.append("<th scope=\"col\">Username</th>");
		out.append("<th scope=\"col\">Password</th>");
		out.append("<th scope=\"col\">Operation</th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		
		ArrayList<User> items = userDaoHandler.getUsers(null, (byte)20);
		items.forEach(item -> {
			out.append("<tr>");
			out.append("<th scope=\"row\">"+item.getId()+"</th>");
			out.append("<td>"+item.getUsername()+"</td>");
			out.append("<td>"+item.getPassword()+"</td>");
			out.append("<td><a href=\"update-user?id="+item.getId()+"\" type=\"button\" class=\"btn btn-outline-info\"><i class=\"fa-solid fa-pen-to-square\"></i> Edit</a> "
					+ "<button type=\"button\" class=\"btn btn-outline-danger\" data-bs-toggle=\"modal\" data-bs-target=\"#del"+item.getId()+"\"><i class=\"fa-solid fa-trash-can\"></i> Delete</button></td>");
			out.append("</tr>");
			
//			Show del modal
			out.append(this.getDelModal(item));
		});
		
		out.append("</tbody>");
		out.append("</table>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		
		out.append("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>");
		out.append("</body>");
		out.append("</html>");
	}
	
	private StringBuilder getDelModal(User item) {
		StringBuilder out = new StringBuilder();
//		<!-- Modal -->
		out.append("<div class=\"modal fade modal-lg\" id=\"del"+item.getId()+"\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">");
		out.append("<div class=\"modal-dialog\">");
		out.append("<div class=\"modal-content\">");
		out.append("<div class=\"modal-header bg-danger bg-gradient text-white\">");
		out.append("<h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\"><i class=\"fa-solid fa-triangle-exclamation\"></i> Confirm deletion</h1>");
		out.append("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>");
		out.append("</div>");
		out.append("<div class=\"modal-body text-success-emphasis\">");
		out.append("<h3>Are you sure to delete <b>"+item.getUsername()+"</b>?</h3>");
		out.append("</div>");
		out.append("<div class=\"modal-footer\">");
		out.append("<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\"><i class=\"fa-solid fa-x\"></i> Close</button>");
		out.append("<a href=\"delete-user?id="+item.getId()+"\" class=\"btn btn-primary\"><i class=\"fa-solid fa-trash-can\"></i> Delete</a>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		out.append("</div>");
		return out;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
