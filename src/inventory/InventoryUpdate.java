package inventory;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InventoryUpdate
 */
@WebServlet("/InventoryUpdate")
public class InventoryUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve all inputs from user
		int inv_id = Integer.parseInt(request.getParameter("inv_id"));
		String product_name = request.getParameter("product_name");
		String supplier_name = request.getParameter("supplier_name");
		int stock_in = Integer.parseInt(request.getParameter("stock_in"));
		int stock_out = Integer.parseInt(request.getParameter("stock_out"));
		int stock_balance = Integer.parseInt(request.getParameter("stock_balance"));

		//retrieve date received value
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		Date stock_date=null;
		try
		{
			stock_date=format.parse(request.getParameter("stock_date"));
		}
		catch(java.text.ParseException e)
		{
			e.printStackTrace();
		}
		
		String status = request.getParameter("status");
		
		// declare inventory object
		Inventory iv=new Inventory();
		
		iv.setInv_id(inv_id);
		iv.setProduct_name(product_name);
		iv.setSupplier_name(supplier_name);
		iv.setStock_in(stock_in);
		iv.setStock_out(stock_out);
		iv.setStock_balance(stock_balance);
		iv.setStock_date(stock_date);
		iv.setStatus(status);
		
		// initialize inventoryModel object
		InventoryModel im= new InventoryModel();
		
		try
		{
			im.updateInventory(iv);
		}
		catch(SQLException e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Data is successfully updated in updateInventory");
		
		// initialize session
		HttpSession session = request.getSession();
		session.setAttribute("status", "row updated");
		session.setAttribute("success", "Data successfully updated");
		
		response.sendRedirect("invView.jsp");
	}
}