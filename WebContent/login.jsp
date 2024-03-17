<%@ page import="login.*" %>

<jsp:include page="header.jsp"></jsp:include>
<br>

<h3>Login Page</h3>
<h3>Mini Mart Inventory Management System</h3>

<form method="post" action="LoginController">
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Enter password">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>

<br>
<jsp:include page="footer.jsp"></jsp:include>