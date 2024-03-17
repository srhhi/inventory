package inventory;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class InventoryModel {
	// Data members of InventoryModel
	private Statement statement;
	private PreparedStatement ps;
	private Connection connection;
	
	// default constructor
	public InventoryModel() 
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
			System.out.println("viewInventory(): "+ex);
			ex.printStackTrace();
		}
	}
	public ArrayList<Inventory> viewInventory()
	{
		// initialize array list object with null value
		ArrayList<Inventory> ivList=null;
		
		// create try-catch block
		try
		{
			initJDBC();
			// initialize ivList object
			ivList = new ArrayList<Inventory>();
			
			// Create a statement
			statement = (Statement) connection.createStatement();

			// Execute a statement
			ResultSet rs = statement.executeQuery("SELECT * FROM inventory");

			// Iterate through the result and print the inventory names
			while (rs.next())
			{
				Inventory iv=new Inventory();
				iv.setInv_id(rs.getInt("inv_id"));
				iv.setProduct_name(rs.getString("product_name"));
				iv.setSupplier_name(rs.getString("supplier_name"));
				iv.setStock_in(rs.getInt("stock_in"));
				iv.setStock_out(rs.getInt("stock_out"));
				iv.setStock_balance(rs.getInt("stock_balance"));
				iv.setStock_date(rs.getDate("stock_date"));
				iv.setStatus(rs.getString("status"));
				//either way you also may use normal constructor to set values
				
				ivList.add(iv);
			}
			// Close the connection
			connection.close();
		}
		catch(Exception ex)
		{
			//catch-block
			System.out.println("viewInventory(): "+ex);
			ex.printStackTrace();
		}
		return ivList;
	}
	public void addInventory(Inventory iv) throws SQLException
	{
		// invoke
		initJDBC();
		
		//try-catch block
		try
		{
			String sql="INSERT INTO inventory (product_name, supplier_name, stock_in, stock_out, stock_balance, stock_date, status) VALUES (?,?,?,?,?,?,?)";
			
			ps=connection.prepareStatement(sql);
			ps.setString(1, iv.getProduct_name());
			ps.setString(2, iv.getSupplier_name());
			ps.setInt(3, iv.getStock_in());
			ps.setInt(4, iv.getStock_out());
			ps.setInt(5, iv.getStock_balance());
			ps.setDate(6, new Date(iv.getStock_date().getTime()));
			ps.setString(7, iv.getStatus());
			
			int countinsert=ps.executeUpdate();
			
			if(countinsert>0)
			{
				System.out.println("Successfully inserted new data!");
			}
		}
		// catch block
		catch(Exception ex)
		{
			System.out.println("addInventory(): "+ex);
			ex.printStackTrace();
		}
	}
	public Inventory getInventoryByInv_id(int inv_id)
	{
		Inventory invObj = new Inventory();
		
		try
		{
			initJDBC();
			
			String sqlReturn = "SELECT * FROM inventory WHERE inv_id ="+inv_id;
			ps = connection.prepareStatement(sqlReturn);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				invObj.setInv_id(rs.getInt(1));
				invObj.setProduct_name(rs.getString(2));
				invObj.setSupplier_name(rs.getString(3));
				invObj.setStock_in(rs.getInt(4));
				invObj.setStock_out(rs.getInt(5));
				invObj.setStock_balance(rs.getInt(6));
				invObj.setStock_date(rs.getDate(7));
				invObj.setStatus(rs.getString(8));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invObj;
	}
	public void updateInventory(Inventory iv) throws SQLException
	{
		initJDBC();
		try
		{
			String sqlUpdate = "UPDATE inventory SET product_name = ?, supplier_name = ?, stock_in = ?, stock_out = ?, stock_balance = ?, stock_date = ?, status = ? WHERE inv_id = ?";
			ps = connection.prepareStatement(sqlUpdate);
			
			ps.setString(1, iv.getProduct_name());
			ps.setString(2, iv.getSupplier_name());
			ps.setInt(3, iv.getStock_in());
			ps.setInt(4, iv.getStock_out());
			ps.setInt(5, iv.getStock_balance());
			ps.setDate(6, new Date(iv.getStock_date().getTime()));
			ps.setString(7, iv.getStatus());
			ps.setInt(8, iv.getInv_id());
			
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
			System.out.println("updateInventory(): "+ex);
			ex.printStackTrace();
		}
	}
	public void deleteInventoryByInv_id(int inv_id)
	{
		Inventory invObj = new Inventory();
		
		try
		{
			initJDBC();
			
			String sqlDelete = "delete from inventory where inv_id ="+inv_id;
			ps = connection.prepareStatement(sqlDelete);
			ps.executeUpdate(sqlDelete);
		} 
		catch (Exception ex) 
		{
			// TODO Auto-generated catch block
			System.out.println("deleteInventoryById(): "+ex);
			ex.printStackTrace();
		}
	}
}