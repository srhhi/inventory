<!-- Import using page directive -->
<%@ page import="supplier.Supplier"%>
<%@ page import="supplier.SupplierUpdate"%>
<jsp:include page="header.jsp"></jsp:include>

<!-- Initialize object -->
<jsp:useBean id="SupplierModel" scope="application" class="supplier.SupplierModel" />
<jsp:useBean id="Supplier" scope="application" class="supplier.Supplier" />

<%  
int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
Supplier supplier = SupplierModel.getSupplierBySupplier_id(supplier_id);
%>

<br>
<h2>Update Supplier</h2>

<form method="post" action="SupplierUpdate">
  <div class="form-group">
    <label for="supplier_name">Name</label>
    <input type="text" class="form-control" id="supplier_name" placeholder="<%=supplier.getSupplier_name()%>" name="supplier_name">
  </div>
  <div class="form-group">
    <label for="supplier_city">City</label>
    <input type="text" class="form-control" id="supplier_city" placeholder="<%=supplier.getSupplier_city()%>" name="supplier_city">
  </div>
  <div class="form-group">
    <label for="supplier_phone">Phone number</label>
    <input type="text" class="form-control" id="supplier_phone" placeholder="<%=supplier.getSupplier_phone()%>" name="supplier_phone">
  </div>
  <input type="hidden" name="supplier_id" value="<%=supplier.getSupplier_id() %>">
  <input type="submit" class="btn btn-primary" value="Update"> 
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>