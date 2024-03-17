<jsp:include page="header.jsp"></jsp:include>
<br>

<h3>Index</h3>
<p>
	Welcome to Mini Mart Inventory Management System. <br>
	<h2><b><%= (new java.util.Date()).toLocaleString()%></b></h2> <br>
	Your role is 
	<% if(session.getAttribute("role") != null) {
			if(session.getAttribute("role").equals("staff")) {
	%>
				staff.
	<% 
			}
			else if(session.getAttribute("role").equals("manager")){ %>
				manager.
	<%		}
		} %>
</p>

<br>
<jsp:include page="footer.jsp"></jsp:include>