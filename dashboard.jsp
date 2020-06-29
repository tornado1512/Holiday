<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.*"%>
<%@page import="java.util.*"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css"  href="css/my_rest_home.css" />
  <link rel="stylesheet" type="text/css"  href="css/dashboard.css" />
 <link href="http://fonts.googleapis.com/css?family=Flamenco" rel="stylesheet">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <title>Restaurant_Owner_Welcome</title>
 </head>
 <body>
		<div class="whole">
			<header>
			<nav>
				<div class="row clearfix">
						<img src="images/pic.png" alt="logo" class="logo1">
						
						<ul class="main-nav animated slideInDown "  id="check-class">
							<li><a href="#"><b>HOME</b></a></li>
							<li><a href="#"><b>ABOUT</b></a></li>
							<li><a href="#"><b>EXPLORE</b></a></li>
							<li><a href="#"><b>RESTAURANT</b></a></li>
							<li><a href="logout.do"><b>LOGOUT</b></a></li>
						</ul>
						<a href="#" class="mobile-icon" onclick="slideshow()"><i class="fa fa-bars"></i></a>
				</div>
			</nav>
			
			<div class="main-content-header">
			<h1 id="data"><span id="data2" class="color-change">Welcome To  DashBoard Page</span></br></br>
			<% ArrayList<RestRegister> rest=(ArrayList)session.getAttribute("restRegister");%>
			<%for(RestRegister rs:rest ){%>
			<div class="gallery">
				  <a  href="<%=rs.getDispImg()%>">
					<img src="<%=rs.getDispImg()%>" alt="display_image" width="600" height="400">
				  </a>
				  <div class="desc"><a href="add_menu.jsp"><%=rs.getRestName() %></a></div> 
				  <%session.setAttribute("restName",rs.getRestName());%>
			</div>
			<%}%>
			

			</div>

		</header>

		<script type="text/javascript">
				function slideshow(){
					var x=document.getElementById('check-class');
					if(x.style.display === "none"){
							x.style.display= "block";
					}
					else{
							x.style.display= "none";
					}
				}
 </script>


			<c:import url="footer.jsp" />

		</div>
 </body>
</html>