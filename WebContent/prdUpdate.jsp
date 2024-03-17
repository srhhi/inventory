<!-- Import using page directive -->
<%@ page import="product.Product"%>
<%@ page import="product.ProductUpdate"%>
<jsp:include page="header.jsp"></jsp:include>

<!-- Initialize object -->
<jsp:useBean id="ProductModel" scope="application" class="product.ProductModel" />
<jsp:useBean id="Product" scope="application" class="product.Product" />

<%  
int product_id = Integer.parseInt(request.getParameter("product_id"));
Product product = ProductModel.getProductByProduct_id(product_id);
%>

<br>
<h2>Update Product</h2>

<form method="post" action="ProductUpdate">
  <div class="form-group">
    <label for="serial_number">Serial number</label>
    <input type="text" class="form-control" id="serial_number" placeholder="<%=product.getSerial_number()%>" name="serial_number">
  </div>
  <div class="form-group">
    <label for="product_name">Product name</label>
    <input type="text" class="form-control" id="product_name" placeholder="<%=product.getProduct_name()%>" name="product_name">
  </div>
  <div class="form-group">
    <label for="category">Category</label><br>
    <select name="category">
    <option><%=product.getCategory()%></option>
    <option value="Sweets">Sweets</option>
    <option value="Cereals">Cereals</option>
    <option value="Groceries">Groceries</option>
	<option value="Beverages">Beverages</option>
	<option value="Health&Beauty">Health&Beauty</option>
	</select>
    <%-- <input type="text" class="form-control" id="category" placeholder="<%=product.getCategory()%>" name="category"> --%>
  </div>
  <div class="form-group">
    <label for="unit_price">Unit price (RM)</label>
    <input type="number" class="form-control" id="unit_price" placeholder="<%=product.getUnit_price()%>" name="unit_price" step="any">
  </div>
  <div class="form-group">
    <label for="date_receive">Date received</label>
    <input type="date" class="form-control" id="date_receive" placeholder="<%=product.getDate_receive()%>" name="date_receive">
  </div>
  <input type="hidden" name="product_id" value="<%=product.getProduct_id() %>">
  <input type="submit" class="btn btn-primary" value="Update"> 
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>