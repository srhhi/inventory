<!-- Import using page directive -->
<%@ page import="java.util.*" %>
<jsp:include page="header.jsp"></jsp:include>

<!-- Initialize object -->
<jsp:useBean id="SupplierModel" scope="application" class="supplier.SupplierModel" />

<!-- Get supplier data from database -->
<% 
List<supplier.Supplier> list = SupplierModel.viewSupplier();
%>

<br>
<h2>View Supplier</h2>
<table class="table">
<thead class="thead-light">
    <tr>
      <th scope="col">No</th>
      <th scope="col">Name</th>
      <th scope="col">City</th>
      <th scope="col">Phone number</th>
      <th scope="col">Actions</th>
      <th></th>
    </tr>
  </thead>
  <!-- Iterate array list -->
  <% 
	for(supplier.Supplier i : list)
	{ %>
  <tbody>
  <tr>
  <td><%=i.getSupplier_id() %></td>
  <td><%=i.getSupplier_name() %></td>
  <td><%=i.getSupplier_city() %></td>
  <td><%=i.getSupplier_phone() %></td>
  <td>
  	<form method="post" action="splUpdate.jsp">
  		<input type="submit" class="btn btn-warning" value="Update">
  		<input type="hidden" name="supplier_id" value="<%=i.getSupplier_id() %>">
  	</form>
  </td>
  <td>
  	<form method="post" action="SupplierDelete">
  		<input type="submit" class="btn btn-danger" value="Delete" onclick="return confirm('Are you sure to delete this record?')">
  		<input type="hidden" name="supplier_id" value="<%=i.getSupplier_id() %>">
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