<%@ page language="java" import="com.company.jws.JWS.web.*,com.company.jws.JWS.entity.*" isELIgnored="false" %>

<!DOCTYPE html>
<html>
	<body>
		<%@ include file="session-header.html" %>
		<br>
		<h1 class="font-monospace" align="center">Hello ${param.signinInputEmail} </h1>
		<%@ include file="footer-html.html" %>
	</body>
</html>