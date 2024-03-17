package supplier;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SupplierModel {
	// Data members of SupplierModel
	private Statement statement;
	private PreparedStatement ps;
	private Connection connection;
	
	// default constructor
	public SupplierModel() 
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
			System.out.println("viewSupplier(): "+ex);
			ex.printStackTrace();
		}
	}
	public ArrayList<Supplier> viewSupplier()
	{
		// initialize array list object with null value
		ArrayList<Supplier> spList=null;
		
		// create try-catch block
		try
		{
			initJDBC();
			// initialize ivList object
			spList = new ArrayList<Supplier>();
			
			// Create a statement
			statement = (Statement) connection.createStatement();

			// Execute a statement
			ResultSet rs = statement.executeQuery("SELECT * FROM supplier");

			// Iterate through the result and print the supplier names
			while (rs.next())
			{
				Supplier sp=new Supplier();
				sp.setSupplier_id(rs.getInt("supplier_id"));
				sp.setSupplier_name(rs.getString("supplier_name"));
				sp.setSupplier_city(rs.getString("supplier_city"));
				sp.setSupplier_phone(rs.getString("supplier_phone"));
				//either way you also may use normal constructor to set values
				
				spList.add(sp);
			}
			// Close the connection
			connection.close();
		}
		catch(Exception ex)
		{
			//catch-block
			System.out.println("viewSupplier(): "+ex);
			ex.printStackTrace();
		}
		return spList;
	}
	public void addSupplier(Supplier sp) throws SQLException
	{
		// invoke
		initJDBC();
		
		//try-catch block
		try
		{
			String sql="INSERT INTO supplier (supplier_id, supplier_name, supplier_city, supplier_phone) VALUES (?,?,?,?)";
			
			ps=connection.prepareStatement(sql);
			ps.setInt(1, sp.getSupplier_id());
			ps.setString(2, sp.getSupplier_name());
			ps.setString(3, sp.getSupplier_city());
			ps.setString(4, sp.getSupplier_phone());
			
			int countinsert=ps.executeUpdate();
			
			if(countinsert>0)
			{
				System.out.println("Successfully inserted new data!");
			}
		}
		// catch block
		catch(Exception ex)
		{
			System.out.println("addSupplier(): "+ex);
			ex.printStackTrace();
		}
	}
	public Supplier getSupplierBySupplier_id(int supplier_id)
	{
		Supplier splObj = new Supplier();
		
		try
		{
			initJDBC();
			
			String sqlReturn = "SELECT * FROM supplier WHERE supplier_id ="+supplier_id;
			ps = connection.prepareStatement(sqlReturn);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				splObj.setSupplier_id(rs.getInt(1));
				splObj.setSupplier_name(rs.getString(2));
				splObj.setSupplier_city(rs.getString(3));
				splObj.setSupplier_phone(rs.getString(4));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return splObj;
	}
	public void updateSupplier(Supplier sp) throws SQLException
	{
		initJDBC();
		try
		{
			String sqlUpdate = "UPDATE supplier SET supplier_name = ?, supplier_city = ?, supplier_phone = ? WHERE supplier_id = ?";
			ps = connection.prepareStatement(sqlUpdate);
			
			ps.setString(1, sp.getSupplier_name());
			ps.setString(2, sp.getSupplier_city());
			ps.setString(3, sp.getSupplier_phone());
			ps.setInt(4, sp.getSupplier_id());
			
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
			System.out.println("updateSupplier(): "+ex);
			ex.printStackTrace();
		}
	}
	public void deleteSupplierBySupplier_id(int supplier_id)
	{
		Supplier splObj = new Supplier();
		
		try
		{
			initJDBC();
			
			String sqlDelete = "delete from supplier where supplier_id ="+supplier_id;
			ps = connection.prepareStatement(sqlDelete);
			ps.executeUpdate(sqlDelete);
		} 
		catch (Exception ex) 
		{
			// TODO Auto-generated catch block
			System.out.println("deleteSupplierBySupplier_id(): "+ex);
			ex.printStackTrace();
		}
	}
}