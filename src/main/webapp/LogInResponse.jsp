<%@ page language="java" import="com.company.jws.JWS.web.*,com.company.jws.JWS.entity.*" isELIgnored="false" %>

<!DOCTYPE html>
<html>
	<body>
		<jsp:include page="session-header.html"></jsp:include>
		<br>
		<h1 class="font-monospace" align="center">Hello ${param.signinInputEmail} </h1>
		<jsp:include page="footer-html.html"></jsp:include>	
	</body>
</html>