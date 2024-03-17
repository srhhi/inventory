package product;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ProductModel {
	// Data members of ProductModel
	private Statement statement;
	private PreparedStatement ps;
	private Connection connection;
	
	// default constructor
	public ProductModel() 
	{
		super();
	}
	// load driver and initialize connection objects
	public void initJDBC() throws SQLException
	{
		try
		{
			//try block
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");

			// Connect to a database
			connection = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/inventorydb" , "root", "");
			System.out.println("Database connected");
		}
		catch(ClassNotFoundException ex) 
		{
			//catchblock
			System.out.println("viewProduct(): "+ex);
			ex.printStackTrace();
		}
	}
	public ArrayList<Product> viewProduct()
	{
		// initialize array list object with null value
		ArrayList<Product> pdList=null;
		
		// create try-catch block
		try
		{
			initJDBC();
			// initialize ivList object
			pdList = new ArrayList<Product>();
			
			// Create a statement
			statement = (Statement) connection.createStatement();

			// Execute a statement
			ResultSet rs = statement.executeQuery("SELECT * FROM product");

			// Iterate through the result and print the product names
			while (rs.next())
			{
				Product pd=new Product();
				pd.setProduct_id(rs.getInt("product_id"));
				pd.setSerial_number(rs.getString("serial_number"));
				pd.setProduct_name(rs.getString("product_name"));
				pd.setCategory(rs.getString("category"));
				pd.setUnit_price(rs.getFloat("unit_price"));
				pd.setDate_receive(rs.getDate("date_receive"));
				//either way you also may use normal constructor to set values
				
				pdList.add(pd);
			}
			// Close the connection
			connection.close();
		}
		catch(Exception ex)
		{
			//catch-block
			System.out.println("viewProduct(): "+ex);
			ex.printStackTrace();
		}
		return pdList;
	}
	public void addProduct(Product pd) throws SQLException
	{
		// invoke
		initJDBC();
		
		//try-catch block
		try
		{
			String sql="INSERT INTO product (product_id, serial_number, product_name, category, unit_price, date_receive) VALUES (?,?,?,?,?,?)";
			
			ps=connection.prepareStatement(sql);
			ps.setInt(1, pd.getProduct_id());
			ps.setString(2, pd.getSerial_number());
			ps.setString(3, pd.getProduct_name());
			ps.setString(4, pd.getCategory());
			ps.setFloat(5, pd.getUnit_price());
			ps.setDate(6, new Date(pd.getDate_receive().getTime()));
			
			int countinsert=ps.executeUpdate();
			
			if(countinsert>0)
			{
				System.out.println("Successfully inserted new data!");
			}
		}
		// catch block
		catch(Exception ex)
		{
			System.out.println("addProduct(): "+ex);
			ex.printStackTrace();
		}
	}
	public Product getProductByProduct_id(int product_id)
	{
		Product prdObj = new Product();
		
		try
		{
			initJDBC();
			
			String sqlReturn = "SELECT * FROM product WHERE product_id ="+product_id;
			ps = connection.prepareStatement(sqlReturn);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				prdObj.setProduct_id(rs.getInt(1));
				prdObj.setSerial_number(rs.getString(2));
				prdObj.setProduct_name(rs.getString(3));
				prdObj.setCategory(rs.getString(4));
				prdObj.setUnit_price(rs.getFloat(5));
				prdObj.setDate_receive(rs.getDate(6));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prdObj;
	}
	public void updateProduct(Product pd) throws SQLException
	{
		initJDBC();
		try
		{
			String sqlUpdate = "UPDATE product SET serial_number = ?, product_name = ?, category = ?, unit_price = ?, date_receive = ? WHERE product_id = ?";
			ps = connection.prepareStatement(sqlUpdate);
			
			ps.setString(1, pd.getSerial_number());
			ps.setString(2, pd.getProduct_name());
			ps.setString(3, pd.getCategory());
			ps.setFloat(4, pd.getUnit_price());
			ps.setDate(5, new Date(pd.getDate_receive().getTime()));
			ps.setInt(6, pd.getProduct_id());
			
			int i = ps.executeUpdate();
			
			if(i > 0)
			{
				System.out.println("Record successfully updated");
			}
			else
			{
				System.out.println("Error detected in updating record.");
			}
			System.out.println("Updated!");
		}
		catch(Exception ex)
		{
			System.out.println("updateProduct(): "+ex);
			ex.printStackTrace();
		}
	}
	public void deleteProductByProduct_id(int product_id)
	{
		Product prdObj = new Product();
		
		try
		{
			initJDBC();
			
			String sqlDelete = "delete from product where product_id ="+product_id;
			ps = connection.prepareStatement(sqlDelete);
			ps.executeUpdate(sqlDelete);
		} 
		catch (Exception ex) 
		{
			// TODO Auto-generated catch block
			System.out.println("deleteProductByProduct_id(): "+ex);
			ex.printStackTrace();
		}
	}
}