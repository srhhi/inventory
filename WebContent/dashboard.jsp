<!-- Import using page directive -->
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<jsp:include page="header.jsp"></jsp:include>

<!-- Initialize object -->
<jsp:useBean id="ProductModel" scope="application" class="product.ProductModel" />
<jsp:useBean id="SupplierModel" scope="application" class="supplier.SupplierModel" />

<!-- Get product and supplier data from database -->
<% 
List<product.Product> Plist = ProductModel.viewProduct();
List<supplier.Supplier> Slist = SupplierModel.viewSupplier();
%>

<br>
<center><h1>IMS Dashboard</h1></center><br><br>
<div class="card-deck">
<div class="card bg-light mb-3" style="max-width: 18rem;">
  <div class="card-header"></div>
  <div class="card-body">
    <h5 class="card-title">No. of Products</h5>
    <p class="card-text"><% try {
	Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/inventorydb" , "root", "");
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery("SELECT distinct COUNT(*) FROM product");
	
	int count=0;
	while (rs.next()) {
		count=rs.getInt(1);%>
		<center><h1><b><%=count%></b></h1></center><%
	}
}
catch(Exception e) {
	e.printStackTrace();
}%></p>
  </div>
</div>
<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
  <div class="card-header"></div>
  <div class="card-body">
    <h5 class="card-title">No. of Suppliers</h5>
    <p class="card-text"><% try {
	Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/inventorydb" , "root", "");
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery("SELECT distinct COUNT(*) FROM supplier");
	
	int count=0;
	while (rs.next()) {
		count=rs.getInt(1);%>
		<center><h1><b><%=count%></b></h1></center><%
	}
}
catch(Exception e) {
	e.printStackTrace();
}%></p>
  </div>
</div>
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header"></div>
  <div class="card-body">
    <h5 class="card-title">No. of Inventory</h5>
    <p class="card-text"><% try {
	Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost/inventorydb" , "root", "");
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery("SELECT distinct COUNT(*) FROM inventory");
	
	int count=0;
	while (rs.next()) {
		count=rs.getInt(1);%>
		<center><h1><b><%=count%></b></h1></center><%
	}
}
catch(Exception e) {
	e.printStackTrace();
}%></p>
  </div>
</div>
</div><br>
<div class="container">
  <div class="row">
    <div class="col">
      <h3>List of products</h3>
      <table class="table">
		<thead class="thead-light">
    	<tr>
	      <th scope="col">No</th>
	      <th scope="col">Product name</th>
	      <th></th>
    	</tr>
  		</thead>
  		<!-- Iterate array list -->
		  <% 
			for(product.Product i : Plist)
			{ %>
		  <tbody>
		  <tr>
		  <td><%=i.getProduct_id() %></td>
		  <td><%=i.getProduct_name() %></td>
		  </tr>
		  <%
		  } 
		  %>
  		</tbody>
		</table>
    </div>
    <div class="col">
      <h3>List of suppliers</h3>
		<table class="table">
		<thead class="thead-light">
    	<tr>
	      <th scope="col">No</th>
	      <th scope="col">Supplier name</th>
	      <th></th>
    	</tr>
  		</thead>
  		<!-- Iterate array list -->
		  <% 
			for(supplier.Supplier i : Slist)
			{ %>
		  <tbody>
		  <tr>
		  <td><%=i.getSupplier_id() %></td>
		  <td><%=i.getSupplier_name() %></td>
		  </tr>
		  <%
		  } 
		  %>
  		</tbody>
		</table>
    </div>
  </div>
</div>

<br>
<jsp:include page="footer.jsp"></jsp:include>