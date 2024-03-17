package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		//TODO: Check email and password with record from db
		if(email.equals("staff@ims.com") && password.equals("staff123")){
			HttpSession session = request.getSession();
			session.setAttribute("status", "loggedin");
			session.setAttribute("role", "staff");
			session.setAttribute("success", "You've successfully logged in.");
			
			response.sendRedirect("index.jsp");
		}
		else if(email.equals("manager@ims.com") && password.equals("manager123")){
			HttpSession session = request.getSession();
			session.setAttribute("status", "loggedin");
			session.setAttribute("role", "manager");
			session.setAttribute("success", "You've successfully logged in.");
			
			response.sendRedirect("index.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("danger", "Login failed. Check your email and password. Please re-login.");
			response.sendRedirect("login.jsp");
		}
	}
}