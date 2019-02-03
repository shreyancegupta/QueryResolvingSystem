<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>

<!-- let's add tag spring:url -->

<spring:url value="/resources/bootstrap.min.css" var="crunchifyCSS" />
<spring:url value="/resources/bootstrap.bundle.min.js" var="crunchifyJS" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
	width: 360px;
	padding: 5% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
	border-radius: 18px;
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4F93F1;
	width: 50%;
	border: 0;
	padding: 10px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
	border-radius: 20px;
}

.form button:hover, .form button:active, .form button:focus {
	background: #0062CD;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

body {
	background-color: #f4511e; /* fallback for old browsers */
	background: -webkit-linear-gradient(right, #f4511e, #f4511e);
	background: -moz-linear-gradient(right, #f4511e, #f4511e);
	background: -o-linear-gradient(right, #f4511e, #f4511e);
	background: linear-gradient(to left, #f4511e, #f4511e);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

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
		display: block;
	}
}

.navbar {
	font-family: 'Roboto', sans-serif;
}

footer {
	color: #FFFFFF;
}

.nav-left {
	float: left;
}
</style>
<script>
	function validate() {
		var password = document.getElementById("password");
		var passLen = password.value.length;
		if(passLen<8) {
			document.getElementById("status").innerHTML="Password must be of minimum 8 characters";
			password.select();
			return false;
		}
		enteredCap = parseInt(document.getElementById("enteredCap").value);
		//alert("enteredCap: " + typeof enteredCap);
		if(enteredCap!=capSum) {
			document.getElementById("status").innerHTML="Entered Captcha is incorrect";
			document.getElementById("enteredCap").select();
			return false;	
		}
		return true;
	}
</script>

</head>

<body>

	<!--Navbar -->
	<div class="navbar">

		<div class="nav-left">
			<a href="#"><i class="fa fa-home" aria-hidden="true"></i></i>Home</a> 
			<a href="#contact"><i class="fa fa-fw fa-envelope"></i> Contact</a>
		</div>

	</div>


	<!--Login-->
	<div class="login-page">
		<div class="form">

			<form method="post" onsubmit="return validate();">
				<label for="username">User Name</label> 
				<input name="username" id="username" class="form-control" required="required" placeholder="Enter user name or email" /> 
				<label for="password">Password</label> 
				<input type="password" name="password" id="password" class="form-control" placeholder="Enter password" required="required" /> 
				<label for="role">Select role </label> 
				<select	name="role" id="role" class="form-control">
				
					<option value="admin" <c:if test="${param.role1.equals('admin')}">selected="selected"</c:if>>Admin</option>
					<option value="teacher" <c:if test="${param.role1.equals('teacher')}">selected="selected"</c:if>>Teacher</option>
					<option value="student" <c:if test="${param.role1.equals('student')}">selected="selected"</c:if>>Student</option>
				</select>
				 <br> 
				 <strong>Solve Captcha</strong> 
				 <span style="background-color: aqua"><h2><s><i><font color="red" face="casteller"><span id="captcha1"></span> + <span id="captcha2"></span></font></i></s></h2> </span>
				<button type="button" onclick="getCaptcha()">refresh</button>
				<!-- <input class="btn" type="button" value="Refresh" onclick="getCaptcha()"> -->
				<br>
				<br> 
				<input class="form-control" type="number" id="enteredCap" required="required" /> <br>
	


				<button type="submit" value="Login">login</button>

			</form>
			<br>
			<font color="red">Forgot Password? <a href="mailto:queryresolversystem@gmail.com?Subject=Reset my password">Send email</a> with your registered email ID</font>
			<br><br><br>
			<font id="status" color="red"></font>
		</div>
	</div>

	<footer>
		<div id="contact" class="col-sm-5">
			<h3>CONTACT</h3>

			<p>
				<span class="glyphicon glyphicon-map-marker"> </span> <strong>Pune,IN</strong>
			</p>
			<p>
				<span class="glyphicon glyphicon-phone"></span> <strong>
					+91 0088776655</strong>
			</p>
			<p>
				<span class="glyphicon glyphicon-envelope"></span> <strong>contact@22company.com</strong>
			</p>
		</div>
	</footer>
				<script>
					function getCaptcha() {
						var capVal1 = Math.floor(Math.random() * 10);
						document.getElementById("captcha1").innerHTML = capVal1;
						var capVal2 = Math.floor(Math.random() * 10);
						document.getElementById("captcha2").innerHTML = capVal2;
						capSum = capVal1 + capVal2;
						document.getElementById("status").innerHTML = "";
					}
					getCaptcha();
				</script>

</body>
</html>






