<!-- Import using page directive -->
<%@ page import="java.util.*" %>
<jsp:include page="header.jsp"></jsp:include>

<!-- Initialize object -->
<jsp:useBean id="ProductModel" scope="application" class="product.ProductModel" />

<!-- Get product data from database -->
<% 
List<product.Product> list = ProductModel.viewProduct();
%>

<br>
<h2>View Product</h2>
<table class="table">
<thead class="thead-light">
    <tr>
      <th scope="col">No</th>
      <th scope="col">Serial number</th>
      <th scope="col">Product name</th>
      <th scope="col">Category</th>
      <th scope="col">Unit price (RM)</th>
      <th scope="col">Date received</th>
      <th scope="col">Actions</th>
      <th></th>
    </tr>
  </thead>
  <!-- Iterate array list -->
  <% 
	for(product.Product i : list)
	{ %>
  <tbody>
  <tr>
  <td><%=i.getProduct_id() %></td>
  <td><%=i.getSerial_number() %></td>
  <td><%=i.getProduct_name() %></td>
  <td><%=i.getCategory() %></td>
  <td><%=i.getUnit_price() %></td>
  <td><%=i.getDate_receive() %></td>
  <td>
  	<form method="post" action="prdUpdate.jsp">
  		<input type="submit" class="btn btn-warning" value="Update">
  		<input type="hidden" name="product_id" value="<%=i.getProduct_id() %>">
  	</form>
  </td>
  <td>
  	<form method="post" action="ProductDelete">
  		<input type="submit" class="btn btn-danger" value="Delete" onclick="return confirm('Are you sure to delete this record?')">
  		<input type="hidden" name="product_id" value="<%=i.getProduct_id() %>">
  	</form>
  </td>
  </tr>
  <%
  } 
  %>
  </tbody>
</table>

<br>
<jsp:include page="footer.jsp"></jsp:include>