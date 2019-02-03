<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html> 
<html>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teacher Home</title>

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
    

    <a href="<spring:url value='/teacher/update?toUpdate=profile' />"><i class="fas fa-user-edit"></i>UPDATE PROFILE</a> &nbsp;
    <a href="<spring:url value='/teacher/update?toUpdate=password' />"><i class="fas fa-pen-alt"></i>UPDATE PASSWORD</a>
    </div> 
      <div class="nav navbar-nav navbar-right">
            <a href="<spring:url value='/teacher/logout' />"><i class="fas fa-sign-out-alt"></i>LOGOUT</a>
      </div>
    </div>

</nav>
<div class="jumbotron text-center">
	<h2>Welcome ${user.name}</h2>
	<p>You are logged in as ${sessionScope.role}</p>
</div>
<a class="btn btn-secondary" href="<spring:url value='/teacher/my_replied_questions?filterSubject=${sessionScope.user.subject}&dateTimeOrder=desc' />">Show my replied questions</a>
<br>
<br>
<form>
Showing open questions of 
<select name="filterSubject">
	<option value="none" <c:if test="${param.filterSubject.equals('none')}">selected="selected"</c:if> >All subjects</option>
	<c:forEach var="s" items="${sessionScope.subjects}">
		<option value="${s}" <c:if test="${param.filterSubject.equals(s)}">selected="selected"</c:if>>${s}</option>
	</c:forEach>
</select>
 sorted as 
<select name="dateTimeOrder">
	<option value="desc" <c:if test="${param.dateTimeOrder.equals('desc')}">selected="selected"</c:if> >Newest</option>
	<option value="asc" <c:if test="${param.dateTimeOrder.equals('asc')}">selected="selected"</c:if>>Oldest</option>
</select>
 first
<button class="btn btn-success" formaction="<spring:url value='/teacher/home' />">Go</button>
</form>
<table class="table table-sm">
	<tr>
		<th>Questions Feed</th>
		<th></th>
	</tr>
	<c:forEach var="q" items="${sessionScope.teacherFeed}">
		<tr>
			<td>${q.heading}</td>
			<td><a class="btn btn-info" href="<spring:url value='/teacher/discussion?qid=${q.id}' />">select</a></td>
		</tr>
	</c:forEach>
</table>
<br>
<br>
<font color="red">${requestScope.status}</font>
</div>
</body>
</html>