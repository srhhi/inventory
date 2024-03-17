package supplier;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SupplierAdd
 */
@WebServlet("/SupplierAdd")
public class SupplierAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierAdd() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve all inputs from user
		String supplier_name = request.getParameter("supplier_name");
		String supplier_city = request.getParameter("supplier_city");
		String supplier_phone = request.getParameter("supplier_phone");

		// declare supplier object
		Supplier sp=new Supplier();
		
		sp.setSupplier_name(supplier_name);
		sp.setSupplier_city(supplier_city);
		sp.setSupplier_phone(supplier_phone);
		
		// initialize supplierModel object
		SupplierModel sm=new SupplierModel();
		
		try
		{
			sm.addSupplier(sp);
			System.out.println("Data is successfully added into addSupplier");
		}
		catch(SQLException e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// initialize session
		HttpSession session = request.getSession();
		session.setAttribute("status", "row added");
		session.setAttribute("success", "Data successfully added");
		
		response.sendRedirect("splView.jsp");
	}
}