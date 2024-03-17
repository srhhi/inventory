 <!-- Import using page directive -->
<%@ page import="login.*" %>
<%@ page import="java.sql.*" %>
<jsp:include page="header.jsp"></jsp:include>
<br>

<h2>Add Inventory</h2>

<form method="post" action="InventoryAdd">
  <div class="form-group">
    <label for="product_name">Product name</label><br>
    <select name="product_name">
	<option>Choose product name</option>
	<%
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/inventorydb" , "root", "");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT distinct product_name FROM product");

		while (rs.next())
		{%>
			<option><%=rs.getString("product_name")%></option>
			<%
		}
	}
	catch(ClassNotFoundException ex) 
	{
		//catchblock
		ex.printStackTrace();
	}%>
	</select>
    <!-- <input type="text" class="form-control" id="product_name" placeholder="Choose product name" name="product_name"> -->
  </div>
  <div class="form-group">
    <label for="supplier_name">Supplier name</label><br>
    <select name="supplier_name">
	<option>Choose supplier name</option>
	<%
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/inventorydb" , "root", "");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT distinct supplier_name FROM supplier");

		while (rs.next())
		{%>
			<option><%=rs.getString("supplier_name")%></option>
			<%
		}
	}
	catch(ClassNotFoundException ex) 
	{
		//catchblock
		ex.printStackTrace();
	}%>
	</select>
    <!-- <input type="text" class="form-control" id="supplier_name" placeholder="Choose supplier name" name="supplier_name"> -->
  </div>
  <div class="form-group">
    <label for="stock_in">Stock in</label>
    <input type="number" class="form-control" id="stock_in" placeholder="Enter stock in" name="stock_in">
  </div>
  <div class="form-group">
    <label for="stock_out">Stock out</label>
    <input type="number" class="form-control" id="stock_out" placeholder="0" name="stock_out">
  </div>
  <div class="form-group">
    <label for="stock_balance">Stock balance</label>
    <input type="number" class="form-control" id="stock_balance" placeholder="0" name="stock_balance">
  </div>
  <div class="form-group">
    <label for="stock_date">Stock date</label>
    <input type="date" class="form-control" id="stock_date" placeholder="dd/mm/yyyy" name="stock_date">
  </div>
  <div class="form-group">
    <label for="status">Status</label><br>
    <select name="status">
    <option>Select status</option>
	<option value="In stock">In stock</option>
	<option value="Low stock">Low stock</option>
	</select>
    <!-- <input type="text" class="form-control" id="status" placeholder="In stock/Out of stock" name="status"> -->
  </div>
  <input type="submit" class="btn btn-primary" value="Add"> 
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>