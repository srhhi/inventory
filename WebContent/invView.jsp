<!-- Import using page directive -->
<%@ page import="login.*" %>
<%@ page import="java.util.*" %>
<jsp:include page="header.jsp"></jsp:include>

<!-- Initialize object -->
<jsp:useBean id="InventoryModel" scope="application" class="inventory.InventoryModel" />

<!-- Get inventory data from database -->
<% 
List<inventory.Inventory> list = InventoryModel.viewInventory();
%>

<br>
<h2>View Inventory</h2>
<table class="table">
<thead class="thead-light">
    <tr>
      <th scope="col">No</th>
      <th scope="col">Product name</th>
      <th scope="col">Supplier name</th>
      <th scope="col">Stock in</th>
      <th scope="col">Stock out</th>
      <th scope="col">Stock balance</th>
      <th scope="col">Stock date</th>
      <th scope="col">Status</th>
      <th scope="col">Actions</th>
      <th></th>
    </tr>
  </thead>
  <!-- Iterate array list -->
  <% 
	for(inventory.Inventory i : list)
	{ %>
  <tbody>
  <tr>
  <td><%=i.getInv_id()%></td>
  <td><%=i.getProduct_name() %></td>
  <td><%=i.getSupplier_name() %></td>
  <td><%=i.getStock_in() %></td>
  <td><%=i.getStock_out()%></td>
  <td><%=i.getStock_balance()%></td>
  <td><%=i.getStock_date() %></td>
  <td><%=i.getStatus() %></td>
  <td>
  	<form method="post" action="invUpdate.jsp">
  		<input type="submit" class="btn btn-warning" value="Update">
  		<input type="hidden" name="inv_id" value="<%=i.getInv_id() %>">
  	</form>
  </td>
  <td>
  	<form method="post" action="InventoryDelete">
  		<input type="submit" class="btn btn-danger" value="Delete" onclick="return confirm('Are you sure to delete this record?')">
  		<input type="hidden" name="inv_id" value="<%=i.getInv_id() %>">
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