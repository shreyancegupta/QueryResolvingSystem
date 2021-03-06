<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>update Teacher Form</title>

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
      <a href="<spring:url value='/teacher/home?filterSubject=${sessionScope.user.subject}&dateTimeOrder=desc' />"><i class="fa fa-home" aria-hidden="true"></i></i>HOME</a> 
   
    </div> 
      <div class="nav navbar-nav navbar-right">
            <a href="<spring:url value='/teacher/logout' />"><i class="fas fa-sign-out-alt"></i>LOGOUT</a>
      </div>
    </div>
 
</nav>
	<form:form method="post" modelAttribute="teacher">
	<table class="table table-sm">
			<%-- <tr>
				<td>Enter Teacher ID</td>
				<td><form:input path="id" /></td>
			</tr> --%>
		<div class="form-group">
			<tr>
				<td></td>
				<td><form:hidden path="id" id="identity" class="form-control" disabled="false" readonly="true" /></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td><label for="name">Teacher Name</label></td>
				<td><c:if test="${sessionScope.toUpdate.equals('password')}"><form:input path="name" id="name" class="form-control" required="required" disabled="false" readonly="true" /></c:if>
					<c:if test="${sessionScope.toUpdate.equals('profile')}"><form:input path="name" id="name" class="form-control" required="required" disabled="false" readonly="false" /></c:if></td>
			</tr>
		</div>
		<div class="form-group">
			<tr>
				<td><label for="email">Teacher Email</label></td>
				<td><c:if test="${sessionScope.toUpdate.equals('password')}"><form:input type="email" path="email" id="email" class="form-control" required="required" disabled="false" readonly="true"  /></c:if>
					<c:if test="${sessionScope.toUpdate.equals('profile')}"><form:input type="email" path="email" id="email" class="form-control" required="required" disabled="false" readonly="false"  /></c:if></td>
			</tr>
		</div>
		<c:if test="${sessionScope.toUpdate.equals('password')}">
		<div class="form-group">
			<tr>
				<td><label for="password">Enter Teacher Password</label></td>
				<td><form:password path="password" id="password" class="form-control" required="required" /></td>
			</tr>
		</div>
		</c:if>
		<c:if test="${sessionScope.toUpdate.equals('password')}">
		<div class="form-group">
			<tr>
				<td><label for="subject">Teacher Subject</label></td>
				<td>
					<form:select path="subject" id="subject" class="form-control" disabled="false" readonly="true" >
					<form:option value="${sessionScope.user.subject}">${sessionScope.user.subject}</form:option>
					</form:select>
				</td>
			</tr>
		</div>
		</c:if>
		<c:if test="${sessionScope.toUpdate.equals('profile')}">
		<div class="form-group">
			<tr>
				<td><label for="subject">Teacher Subject</label></td>
				<td>
				<form:select path="subject" id="subject" class="form-control" >
					<c:forEach var="s" items="${sessionScope.subjects}">
						<option value="${s}" <c:if test="${sessionScope.user.subject.equals(s)}">selected="selected"</c:if>>${s}</option>
					</c:forEach>
				</form:select>	
				</td>
			</tr>
		</div>
		</c:if>
			<tr>
				<td></td>
				<td><input class="btn btn-primary" type="submit" value="Update Teacher" /></td>
			</tr>
		</table> 
	</form:form>
	<a class="btn btn-dark" href="<spring:url value='/teacher/home?filterSubject=${sessionScope.user.subject}&dateTimeOrder=desc' />">Go To Home</a>
</div>
</body>
</html>