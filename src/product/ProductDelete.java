package product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductDelete
 */
@WebServlet("/ProductDelete")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		System.out.println("ID from prdView :"+product_id);
		ProductModel prdModelObj = new ProductModel();
		prdModelObj.deleteProductByProduct_id(product_id);
		
		System.out.println("Data is successfully deleted in deleteProduct");
		
		HttpSession session = request.getSession();
		session.setAttribute("status", "row deleted");
		session.setAttribute("success", "Data successfully deleted");
		
		response.sendRedirect("prdView.jsp");
	}
}