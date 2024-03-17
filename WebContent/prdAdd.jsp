<!-- Import using page directive -->
<%@ page import="login.*" %>
<jsp:include page="header.jsp"></jsp:include>
<br>

<h2>Add Product</h2>

<form method="post" action="ProductAdd">
  <div class="form-group">
    <label for="serial_number">Serial number</label>
    <input type="text" class="form-control" id="serial_number" placeholder="Enter serial number" name="serial_number">
  </div>
  <div class="form-group">
    <label for="product_name">Product name</label>
    <input type="text" class="form-control" id="product_name" placeholder="Enter product name" name="product_name">
  </div>
  <div class="form-group">
    <label for="category">Category</label><br>
    <select name="category">
    <option>Select category</option>
    <option value="Sweets">Sweets</option>
    <option value="Cereals">Cereals</option>
    <option value="Groceries">Groceries</option>
	<option value="Beverages">Beverages</option>
	<option value="Health&Beauty">Health&Beauty</option>
	</select>
    <!-- <input type="text" class="form-control" id="category" placeholder="Choose category" name="category"> -->
  </div>
  <div class="form-group">
    <label for="unit_price">Unit price (RM)</label>
    <input type="number" class="form-control" id="unit_price" placeholder="Enter unit price 0.00" name="unit_price" step="any">
  </div>
  <div class="form-group">
    <label for="date_receive">Date received</label>
    <input type="date" class="form-control" id="date_receive" placeholder="dd/mm/yyyy" name="date_receive">
  </div>
  <input type="submit" class="btn btn-primary" value="Add"> 
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>