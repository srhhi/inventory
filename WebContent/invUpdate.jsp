<!-- Import using page directive -->
<%@ page import="java.sql.*" %>
<%@ page import="inventory.Inventory"%>
<%@ page import="inventory.InventoryUpdate"%>
<jsp:include page="header.jsp"></jsp:include>

<!-- Initialize object -->
<jsp:useBean id="InventoryModel" scope="application" class="inventory.InventoryModel" />
<jsp:useBean id="Inventory" scope="application" class="inventory.Inventory" />

<%  
int inv_id = Integer.parseInt(request.getParameter("inv_id"));
Inventory inventory = InventoryModel.getInventoryByInv_id(inv_id);
%>

<br>
<h2>Update Inventory</h2>

<form method="post" action="InventoryUpdate">
  <div class="form-group">
    <label for="product_name">Product name</label><br>
    <select name="product_name">
	<option><%=inventory.getProduct_name()%></option>
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
    <%-- <input type="text" class="form-control" id="product_name" placeholder="<%=inventory.getProduct_name()%>" name="product_name"> --%>
  </div>
  <div class="form-group">
    <label for="supplier_name">Supplier name</label><br>
    <select name="supplier_name">
	<option><%=inventory.getSupplier_name()%></option>
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
    <%-- <input type="text" class="form-control" id="supplier_name" placeholder="<%=inventory.getSupplier_name()%>" name="supplier_name"> --%>
  </div>
  <div class="form-group">
    <label for="stock_in">Stock in</label>
    <input type="number" class="form-control" id="stock_in" placeholder="<%=inventory.getStock_in()%>" name="stock_in">
  </div>
  <div class="form-group">
    <label for="stock_out">Stock out</label>
    <input type="number" class="form-control" id="stock_out" placeholder="<%=inventory.getStock_out()%>" name="stock_out">
  </div>
  <div class="form-group">
    <label for="stock_balance">Stock balance</label>
    <input type="number" class="form-control" id="stock_balance" placeholder="<%=inventory.getStock_balance()%>" name="stock_balance">
  </div>
  <div class="form-group">
    <label for="stock_date">Stock date</label>
    <input type="date" class="form-control" id="stock_date" placeholder="<%=inventory.getStock_date()%>" name="stock_date">
  </div>
  <div class="form-group">
    <label for="status">Status</label>
    <input type="text" class="form-control" id="status" placeholder="<%=inventory.getStatus()%>" name="status">
  </div>
  <input type="hidden" name="inv_id" value="<%=inventory.getInv_id() %>">
  <input type="submit" class="btn btn-primary" value="Update"> 
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>