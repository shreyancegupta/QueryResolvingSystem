<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html> 
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student Form</title>

<!-- let's add tag spring:url -->
<spring:url value="/resources/bootstrap.min.css" var="crunchifyCSS" />
<spring:url value="/resources/bootstrap.bundle.min.js" var="crunchifyJS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="${crunchifyCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>
<!-- Finish adding tags -->


<style>
.jumbotron { 
  background-color: #f4511e; /* Orange */
  color: #ffffff;
   margin-top: 1rem;
}

.navbar {
  margin-bottom: 0;
   background-color: #555555;
  z-index: 9999;
  border: 0;
  font-size: 12px !important;
  line-height: 1.42857143 !important;
  letter-spacing: 4px;
  border-radius: 0;
}

.navbar a, .navbar .navbar-brand {
  color: #fff !important;
}

.navbar-nav a:hover, .navbar-nav li.active a {
  color: #f4511e !important;
  background-color: #fff !important;
}

.navbar-default .navbar-toggle {
  border-color: transparent;
  color: #fff !important;
}
a{
color:#FFFFFF;
}


</style>


</head>
<body>

<div class="container">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        &#11117;
      </button><nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Query-Resolving System</a>
      <a href="<spring:url value='/admin/home' />"><i class="fa fa-home" aria-hidden="true"></i></i>Home</a> 
    </div>
    <div id="myNavbar">
      <div class="nav navbar-nav navbar-right">
       
        <a href="<spring:url value='/admin/logout' />"><i class="fas fa-sign-out-alt"></i>LOGOUT</a>
      </div>
    </div>
  </div>
</nav>
      <a class="navbar-brand" href="#">Query-Resolving System</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#about">ABOUT</a></li>
        <li><a href="#contact">CONTACT</a></li>
        <li><a href="<spring:url value='/admin/logout' />">LOGOUT</a></li>
      </ul>
    </div>
  </div>
</nav>
	<form:form method="post" modelAttribute="student">
	<table class="table table-sm">
			<%-- <tr>
				<td>Enter Student ID</td>
				<td><form:input path="id" /></td>
			</tr> --%>
		<div class="form-group">
			<tr>
				<td><label for="identity">Student ID:</label></td>
				<td><form:input path="id" id="identity" class="form-control" disabled="true" readonly="true" /></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td><label for="name">Student Name</label></td>
				<td><form:input path="name" id="name" class="form-control" required="required" disabled="false" readonly="true" /></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td><label for="email">Student Email</label></td>
				<td><form:input type="email" path="email" id="email" class="form-control" required="required" disabled="false" readonly="true" /></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td><label for="password">Enter Student Password</label></td>
				<td><form:password path="password" id="password" class="form-control" required="required" /></td>
			</tr>
		</div>
			<tr>
				<td></td>
				<td><input class="btn btn-primary" type="submit" value="Update Student" /></td>
			</tr>
		</table> 
	</form:form>
	<a class="btn btn-dark" href="<spring:url value='/admin/home' />">Go To Home</a>
</div>
</body>
</html>