<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous"> -->


<!-- let's add tag spring:url CANT DO THIS IN INDEX PAGE SO GIVE CONTEXT ROOT AND USE DIRECT URL OR USE JSP CORE TAG LIB C:URL-->
<c:url value="/resources/bootstrap.min.css" var="crunchifyCSS" />
<c:url value="/resources/bootstrap.bundle.min.js" var="crunchifyJS" />
<c:url value="/resources/images/student.png" var="student" />
<c:url value="/resources/images/teacher.png" var="teacher" />
<c:url value="/resources/images/admin.png" var="admin" />
<c:url value="/resources/images/m3.png" var="line" />
<c:url value="/resources/images/company.png" var="company" />
<c:url value="/resources/images/service.png" var="service" />
<link href="${crunchifyCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>

<!-- <link href="/Prototype7.0/resources/bootstrap.min.css" rel="stylesheet" />
<script src="/Prototype7.0/resources/bootstrap.bundle.min.js"></script> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!-- Finish adding tags -->
 
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">

<style>

.jumbotron { 
  background-color: #f4511e; /* Orange */
  color: #ffffff;
  margin-top: 1rem;
}

body {
	font: 400 15px Lato, sans-serif;
	line-height: 1.8;
	color: #818181;
}

h2 {
	font-size: 24px;
	text-transform: uppercase;
	color: #303030;
	font-weight: 600;
	margin-bottom: 30px;
}

h4 {
	font-size: 19px;
	line-height: 1.375em;
	color: #303030;
	font-weight: 400;
	margin-bottom: 30px;
}

.logo-small {
	color: #76ff03;
	font-size: 50px;
}

.logo {
	color: #76ff03;
	font-size: 200px;
}

.container-fluid {
	padding: 30px 50px;
}


.bg-grey {
	background-color: #f6f6f6;
}

.slideanim {
	visibility: hidden;
}

.carousel-control.right, .carousel-control.left {
	background-image: none;
	color: #76ff03;
}

.panel {
	border: 1px solid #76ff03;
	border-radius: 0 !important;
	transition: box-shadow 0.5s;
}

.panel:hover {
	box-shadow: 5px 0px 40px rgba(0, 0, 0, .2);
}

.panel-footer .btn:hover {
	border: 1px solid #76ff03;
	background-color: #fff !important;
	color: #76ff03;
}

.panel-heading {
	color: #fff !important;
	background-color: #f4511e !important;
	padding: 25px;
	border-bottom: 1px solid transparent;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

.slide {
	animation-name: slide;
	-webkit-animation-name: slide;
	animation-duration: 1s;
	-webkit-animation-duration: 1s;
	visibility: visible;
}

@
keyframes slide{
	 0%{
	opacity: 0;
	transform: translateY(70%);
	}

	100%{
opacity:1;
transform:translateY(0%);
	 }
}
@
-webkit-keyframes slide { 0% {
	opacity: 0;
	-webkit-transform: translateY(70%);
}

100%
{opacity:1;
-webkit-transform:translateY(0%);
}
}
@media screen and (max-width: 768px) {
	.col-sm-4 {
		text-align: center;
		margin: 25px 0;
	}
	.btn-lg {
		width: 100%;
		margin-bottom: 35px;
	}
}

@media screen and (max-width: 480px) {
	.logo {
		font-size: 150px;
	}
}
/* FOR NAVIHGATION BAR --STRAT */
.navbar {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

/* Navbar links */
.navbar a {
 
  text-align: center;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 17px;
}

/* Navbar links on mouse-over */
.navbar a:hover {
  background-color: #000;
}

/* Current/active navbar link */
.active {
  background-color: #4CAF50;
}

/* Add responsiveness - will automatically display the navbar vertically instead of horizontally on screens less than 500 pixels */
@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
  }
}


/* FOR NAVIHGATION BAR --END */
body {
  font: 400 15px/1.8 Lato, sans-serif;
  color: #777;
}

.navbar {
  font-family: Montserrat, sans-serif;
      align-items: auto;
}

/* Add a dark background color to the footer */
footer {
  background-color: #2d2d30;
  color: #f5f5f5;
  padding: 32px;
}

footer a {
  color: #f5f5f5;
}

#uparrow{
font-size:30px;
}
.navleft{
float:left;
}
.navright{
float:right;
}

a [href="#about"]{
float: left;
}

</style>



<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
})
</script>


</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<div class="navbar">

  <div class="navleft">
  <a href="#about"><i class="fa fa-question-circle" aria-hidden="true"></i>ABOUT</a> 
  <a href="#ourvalue"><i class="fa fa-handshake-o" aria-hidden="true"></i>OUR VALUE</a>
  <a href="#contact"><i class="fa fa-fw fa-envelope" aria-hidden="true"></i>CONTACT</a> 
  <a href="#feedback"><i class="fa fa-comments" aria-hidden="true"></i>FEEDBACK</a>
  </div>
  <div class="navright">
  <a href="#logins"><i class="fa fa-fw fa-user" aria-hidden="true"></i>LOGIN</a>
  </div>

</div>

	<div class="jumbotron text-center">
		<h1><b>Welcome to Query-Resolving System<b></h1>
		<h4>We are here to help you ! <br>Be With Us Your Problem Will Get Resolved</h4>
	</div>







	<div id="about" class="container-fluid">
		<div class="row">
		
			<div class="col-sm-8">
				<h2>About WBQRS</h2>
				<br>
				<h4>How We Work</h4>
				<p>We are constantly building and improving our business
					processes with one main goal – to deliver technological solutions
					for our customers in time and on budget. To achieve this we have
					adapted a number of well-known and proven project management
					methods. We complement your own in-house IT team and protect your
					intellectual property without the burden of setting up a remote
					office helping you to reach your deliverable software and web
					development goals.</p>
				
			</div>
			<div class="col-sm-4"> <img src="${company}" width="400" height="400"/></div>
		</div>
	</div>

	<div id="ourvalue"class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-4">
			<img src="${service}" width="400" height="400"/></div>
			<div class="col-sm-8">
				<h2>Our Values</h2>
				<br>
				<h4>
					<strong>MISSION:</strong>
					
				</h4>
				<p>Our mission is to share and grow the world's knowledge.

Our core values as an organization are:

Mission First. We place long-term, collective impact ahead of personal achievement.
Drive. We aim high and do whatever it takes to get things done.
Agility. We are nimble in our processes and systems, ready to adapt to a changing world.
Awareness. We are rigorous in our decisions and candid in our communication.
Pragmatism. We stay grounded in the outcomes that truly matter for our mission.</p>
				<br>
				<p>
					<strong>VISION:</strong> 
					<p>Welcome to WBQRS Vision, a software development company
					that provides high-end application development and design as well
					as product engineering based on technical expertise staff.</p>
				</p>
			</div>
		</div>
	</div>



	<div id="logins" class="container-fluid">

		<div class="row">
			<div class="col-sm-4 col-xs-12">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h1>Student</h1>
						<a href="authenticate/user?role1=student"><img src="${student}" width="250" height="250" /></a>
					</div>
					

				</div>
			</div>
			<div class="col-sm-4 col-xs-12">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h1>Professor</h1>
						<a href="authenticate/user?role1=teacher"><img src="${teacher}" width="250" height="250" /></a>
					</div>
				
				</div>
			</div>
			<div class="col-sm-4 col-xs-12">
				<div class="panel panel-default text-center">
					<div class="panel-heading">
						<h1>Admin</h1>
						<a href="authenticate/user?role1=admin"><img src="${admin}" width="250" height="250" /></a>
					</div>
				
				</div>
			
			</div>
			</div>
				
			
	</div>


</div>

<div class="contactus">
<jsp:include page="/resources/static/contactus.jsp"/>  
</div>



<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
<i id="uparrow" class="fas fa-arrow-circle-up"></i></a><br>
  <p>To The Top</p> 
</footer>












	</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>


</body>
</html>