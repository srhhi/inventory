package inventory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InventoryDelete
 */
@WebServlet("/InventoryDelete")
public class InventoryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inv_id = Integer.parseInt(request.getParameter("inv_id"));
		System.out.println("ID from invView :"+inv_id);
		InventoryModel invModelObj = new InventoryModel();
		invModelObj.deleteInventoryByInv_id(inv_id);
		
		System.out.println("Data is successfully deleted in deleteInventory");
		
		HttpSession session = request.getSession();
		session.setAttribute("status", "row deleted");
		session.setAttribute("success", "Data successfully deleted");
		
		response.sendRedirect("invView.jsp");
	}
}