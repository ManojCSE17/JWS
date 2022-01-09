<%@ page language="java" import="com.company.jws.JWS.*" %>

<!DOCTYPE html>
<html>
	<body>
		
		<jsp:include page="session-header.html"></jsp:include>	
			
		<h1 class="text-center fw-light">Built-In Request Object</h1><br>
		
		<div style="margin-left:10px;margin-right:10px;">
			<h3 class="font-monospace"><strong>Request User Agent : </strong><%= request.getHeader("User-Agent") %></h3><br>
		
			<h3 class="font-monospace"><strong>Request User Language : </strong><%= request.getLocale() %></h3><br>
		</div>
		
		<jsp:include page="footer-html.html"></jsp:include>
		
	</body>
</html>