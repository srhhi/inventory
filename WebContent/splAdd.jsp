<!-- Import using page directive -->
<%@ page import="login.*" %>
<jsp:include page="header.jsp"></jsp:include>
<br>

<h2>Add Supplier</h2>

<form method="post" action="SupplierAdd">
  <div class="form-group">
    <label for="supplier_name">Name</label>
    <input type="text" class="form-control" id="supplier_name" placeholder="Enter supplier name" name="supplier_name">
  </div>
  <div class="form-group">
    <label for="supplier_city">City</label>
    <input type="text" class="form-control" id="supplier_city" placeholder="Enter supplier city" name="supplier_city">
  </div>
  <div class="form-group">
    <label for="supplier_phone">Phone number</label>
    <input type="text" class="form-control" id="supplier_phone" placeholder="Enter 60XXXXXXXXX" name="supplier_phone">
  </div>
  <input type="submit" class="btn btn-primary" value="Add"> 
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>