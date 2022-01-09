<%@page import="com.company.jws.JWS.*" isELIgnored="false" %>

<html>
	
	<body>
		
		<jsp:include page="header-html.html"></jsp:include>

    	<main>
	        <div class="container py-4">
	        
			    <div class="p-5 mb-4 bg-light rounded-3">
			    	<div class="container-fluid py-5">
			    		<div style="float:right;"><i style="color:#B23CFD;font-size:150px;" class="bi bi-cursor"></i></div>
			        	<h1 class="display-5 fw-bold">JWS</h1>
			        	<p class="col-md-8 fs-4">This web page is created using java web framework.</p>
			        	<button class="btn btn-outline-secondary btn-lg" type="button" onclick="window.location.href = 'basic-jsp.jsp';">Quick Start</button>
			    	</div>
			    </div>
		
			    <div class="row align-items-md-stretch">
			    	<div class="col-md-6">
			        	<div class="h-100 p-5 text-white bg-dark rounded-3">
			        		<h2>Java Web Stack</h2>
			          		<p>Java Web Stack is a open source project built on Java Full Stack. This project is built using Maven, Java, JSP, JUnit 4, HTML5, BootStrap 5.</p>
			          		<button class="btn btn-outline-light" type="button" onclick="window.open('https://www.javatpoint.com/java-full-stack','_blank' );">Know More</button>
			        	</div>
			    	</div>
				    <div class="col-md-6">
						<div class="h-100 p-5 bg-light border rounded-3">
				        	<h2>Bootstrap 5</h2>
				          	<p>Quickly design and customize responsive mobile-first sites with Bootstrap, the world's most popular front-end open source toolkit, featuring SASS variables and mixins, responsive grid system, extensive prebuilt components, and powerful JavaScript plugins.</p>
				          	<button class="btn btn-outline-secondary" type="button" onclick="window.open('https://getbootstrap.com/','_blank' );">Know More</button>
				        </div>
		      		</div>
		    	</div>
		    </div>
        </main>
		<br><br>
		<jsp:include page="footer-html.html"></jsp:include>

	</body>
</html>
