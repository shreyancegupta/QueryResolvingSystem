<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%-- <%@ page import="com.app.pojos.Student" %> --%>
<!DOCTYPE html> 
<html>
<head>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Discussion</title>

<!-- let's add tag spring:url -->
<spring:url value="/resources/bootstrap.min.css" var="crunchifyCSS" />
<spring:url value="/resources/bootstrap.bundle.min.js" var="crunchifyJS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="${crunchifyCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>
<!-- Finish adding tags -->


<style>
.jumbotron { 
  background-color: #; /* Orange */
  color: #ffffff;
  margin-top: 1rem;
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
	background-color: #ffffff; /* fallback for old browsers */
	background: -webkit-linear-gradient(right, #ffffff, #ffffff);
	background: -moz-linear-gradient(right, #ffffff, #ffffff);
	background: -o-linear-gradient(right, #ffffff, #ffffff);
	background: linear-gradient(to left, #ffffff, #ffffff);
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
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
})
</script>

</head>
<body>
<div class="container">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Query-Resolving System</a>
    </div>
    <div id="myNavbar">
      <div class="nav navbar-nav navbar-right">
       
        <a href="<spring:url value='/admin/logout' />"><i class="fas fa-sign-out-alt">LOGOUT</i></a>
      </div>
    </div>
  </div>
</nav>
	<form:form method="post" modelAttribute="reply">
		<table class="table table-sm">
			<tr>
				<th colspan="3"><center>${sessionScope.question.heading}</center></th>
			</tr>
			<tr>
				<td>Explanation:</td>
				<td colspan="2" align="left">${sessionScope.question.data}</td>
			</tr>
			<c:forEach var="r" items="${sessionScope.replies}">
				<tr>
					<c:choose>
						<c:when test="${r.student!=null}">
						<td>Reply by 
							${r.student.name} (<a href="mailto:${r.student.email}?Subject=${sessionScope.question.heading}">send mail</a>) :
						</td>
						<td>${r.data}</td>
						<td></td>
						</c:when>
						<c:otherwise>
							<td></td>
							<td>${r.data}</td>
							<td> : Reply by
							${r.teacher.name} (<a href="mailto:${r.teacher.email}?Subject=${sessionScope.question.heading}">send mail</a>)
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
			<c:if test="${!sessionScope.question.closed}">
				<tr>
					<td colspan="3">
						<form:input class="form-control" path="data" required="required" />
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<center><input class="btn btn-primary" type="submit" value="Add Reply" /></center>
					</td>
				</tr>
			</c:if>
			<tr>
			<td>
				<%-- <a class="btn btn-dark" href="<spring:url value='/${sessionScope.role}/home?filterSubject=none&dateTimeOrder=desc' />">Go To Home</a> --%>
			<c:choose>
				<c:when test="${sessionScope.role.equals(\"student\")}">
					<a class="btn btn-dark" href="<spring:url value='/student/home?filterSubject=none&dateTimeOrder=desc' />">Go To Home</a>
				</c:when>
				<c:otherwise>
					<a class="btn btn-dark" href="<spring:url value='/teacher/home?filterSubject=${sessionScope.user.subject}&dateTimeOrder=desc' />">Go To Home</a>
				</c:otherwise>
			</c:choose>
			</td>
			<td></td>
			<td>
			<c:if test="${sessionScope.role.equals(\"student\")}">
			<c:if test="${sessionScope.question.studentId.equals(sessionScope.user.id)}">
			<c:if test="${!sessionScope.question.closed}">
			<div align="right"><a class="btn btn-danger" href="<spring:url value='/student/close_question?qid=${sessionScope.question.id}' />">Close this question</a></div>
			</c:if>
			</c:if>
			</c:if>
			</td>
			</tr>
		</table>
	</form:form>
</div>


</body>
</html>