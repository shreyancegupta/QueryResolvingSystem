<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html> 
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post Your Question</title>

<!-- let's add tag spring:url -->
<spring:url value="/resources/bootstrap.min.css" var="crunchifyCSS" />
<spring:url value="/resources/bootstrap.bundle.min.js" var="crunchifyJS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="${crunchifyCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>
<!-- Finish adding tags -->


<style>
.jumbotron { 
margin-top:2rem;
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
      <a class="navbar-brand" href="#">Query-Resolving System</a>
      <a href="<spring:url value='/student/home?filterSubject=none&dateTimeOrder=desc' />"><i class="fa fa-home" aria-hidden="true"></i></i>HOME</a> 
   
    </div> 
      <div class="nav navbar-nav navbar-right">
            <a href="<spring:url value='/student/logout' />"><i class="fas fa-sign-out-alt"></i>LOGOUT</a>
      </div>
    </div>
</nav>
	<form:form method="post" modelAttribute="question">
		<table class="table table-sm">
		<div class="form-group">
			<tr>
				<td><label for="heading">Enter Question Title:</label></td>
				<td><form:input path="heading" id="heading" class="form-control" required="required" /></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td><label for="data">Enter Question Data:</label></td>
				<td><form:textarea path="data" id="data" class="form-control" required="required"/></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td><label for="subject">Select Subject:</label></td>
				<td><form:select path="subject" id="subject" class="form-control" items="${sessionScope.subjects}"/></td>
			</tr>
		</div>
			<tr>
				<td></td>
				<td><input type="submit" value="Post Question" class="btn btn-primary" /></td>
			</tr>
		</table> 
	</form:form>
	<a class="btn btn-dark" href="<spring:url value='/student/home?filterSubject=none&dateTimeOrder=desc' />">Go To Home</a>
</div>
</body>
</html>