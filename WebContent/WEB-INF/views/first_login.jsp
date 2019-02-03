<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Login</title>

<link href="${crunchifyCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
    
<spring:url value="/resources/bootstrap.min.css" var="crunchifyCSS" />
<spring:url value="/resources/bootstrap.bundle.min.js" var="crunchifyJS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<style>

body {
 background-color: #f4511e;/* fallback for old browsers */
  background: -webkit-linear-gradient(right, #f4511e, #f4511e);
  background: -moz-linear-gradient(right, #f4511e, #f4511e);
  background: -o-linear-gradient(right, #f4511e, #f4511e);
  background: linear-gradient(to left, #f4511e,  #f4511e);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
  

 .login-page {
  width: 360px;
  padding: 10% 0 0;
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
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
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
.form button:hover,.form button:active,.form button:focus {
  background: #0062CD;
}
</style>

<script>
	function check() {
		var passwordField = document.getElementById("password");
		if(passwordField.value === "password") {
			document.getElementById("status").innerHTML = "This is the default password. Please change it to a new one";
			passwordField.select();
			return false;
		}
		return true;
	}
</script>

</head>
<body>


<!--Login-->
    <div class="login-page" >
        <div class="form">
       
          <form onsubmit="return check();" method="post" action="<spring:url value='/authenticate/update_password' /> ">
                <label for="password">Enter new password</label>
				<input type="password" name="password" id="password" class="form-control" placeholder="Enter new password" required="required" autofocus="autofocus" />
				<input name="username" value="${requestScope.uname}" hidden="true" />
				<input name="role" value="${sessionScope.role}" hidden="true" />
          		<br>
            	<button type="submit" value="Submit">Submit</button>
          </form>
          <br>
          <font color="red" id="status"></font>
        </div>
      </div>
      
</body>
</html>