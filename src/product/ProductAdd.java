package product;

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
 * Servlet implementation class ProductAdd
 */
@WebServlet("/ProductAdd")
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAdd() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve all inputs from user
		String serial_number = request.getParameter("serial_number");
		String product_name = request.getParameter("product_name");
		String category = request.getParameter("category");
		float unit_price = Float.parseFloat(request.getParameter("unit_price"));

		//retrieve date received value
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		Date date_receive=null;
		try
		{
			date_receive=format.parse(request.getParameter("date_receive"));
		}
		catch(java.text.ParseException e)
		{
			e.printStackTrace();
		}
		
		// declare product object
		Product pd=new Product();
		
		pd.setSerial_number(serial_number);
		pd.setProduct_name(product_name);
		pd.setCategory(category);
		pd.setUnit_price(unit_price);
		pd.setDate_receive(date_receive);
		
		// initialize productModel object
		ProductModel pm=new ProductModel();
		
		try
		{
			pm.addProduct(pd);
			System.out.println("Data is successfully added into addProduct");
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
		
		response.sendRedirect("prdView.jsp");
	}
}