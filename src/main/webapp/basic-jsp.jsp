<%@ page language="java" import="com.company.jws.JWS.*" %>

<!DOCTYPE html>

<html>
	<body>
	
		<%@ include file="session-header.html" %>	
		
		<h1 class="text-center fw-light">JSP Basic</h1><br>
		
		<div class="font-monospace" style="margin-left:10px;margin-right:10px;">
		
			Hello time on the server is <%= new java.util.Date() %><br><br>
			
			Hi there iam <%= new String("Manoj").toUpperCase() %><br><br>
			
			25 Divided by 4 is <%= 25/4 %><br><br>
			
			Is 75 greater than 69 <%= 75>69 %><br><br>
			
			Multiplication table of 2<br><br>
			
			<% 
				for(int i=1;i<=10;i++){
					out.println(2+" x "+i+" = "+(2*i)+"<br>");
				}
			%>
			
			<%!
				String toLower(String w){
					return w.toLowerCase();
				}
			%>
			
			<br> Lower case of "Hello" : <%= toLower("Hello") %>
			
		</div>
		
		<%@ include file="footer-html.html" %>
		
	</body>
</html>