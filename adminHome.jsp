<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css"  href="css/my_rest_home.css" />
 <link href="http://fonts.googleapis.com/css?family=Flamenco" rel="stylesheet">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <title>Welcome_Admin</title>
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
			<h1 id="data"><span id="data2" class="color-change">Welcome To Admin DashBoard</span></br></br>
			<% String ownerName=(String)session.getAttribute("ownername");%>
			 ADMIN - <%=ownerName%> <h1>
			<a href="admin_views.do?id=1" class="btn btn-full">View All Restaurants</a>
			<a href="admin_views.do?id=2" class="btn btn-full">View All Packages</a>
			<a href="admin_views.do?id=3" class="btn btn-full">View All Hotels</a>
			<a href="admin_views.do?id=4" class="btn btn-full">View All Users</a>
			<a href="add_accomodation.jsp" class="btn btn-nav">Add Hotels</a>
			<a href="add_package.jsp" class="btn btn-nav">Add Hotels</a>
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
