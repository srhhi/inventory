package supplier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupplierDelete
 */
@WebServlet("/SupplierDelete")
public class SupplierDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
		System.out.println("ID from splView :"+supplier_id);
		SupplierModel splModelObj = new SupplierModel();
		splModelObj.deleteSupplierBySupplier_id(supplier_id);
		
		System.out.println("Data is successfully deleted in deleteSupplier");
		
		HttpSession session = request.getSession();
		session.setAttribute("status", "row deleted");
		session.setAttribute("success", "Data successfully deleted");
		
		response.sendRedirect("splView.jsp");
	}
}