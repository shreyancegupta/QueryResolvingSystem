<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

.container-fluid {
	padding: 30px 50px;
}

.bg-grey {
	background-color: #f6f6f6;
}

footer {
	font-size: 20px;
	margin-bottom: 20px;
	color: #648726;

}
#contact{
	border-radius: 25px;
	}
.form-control{
font-size: 18px;
}

.btn{
    border: 1px solid #555555;
    font-size: 1.7rem;
}


</style>
</head>
<body>

<footer id="end" class="container-fluid text-center">
	<div id="contact" class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-5">
				<h4>CONTACT</h4>
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> Pune,IN
				</p>
				<p>
					<span class="glyphicon glyphicon-phone"></span> +91 0088776655
				</p>
				<p>
					<span class="glyphicon glyphicon-envelope"></span>
					contact@22company.com
				</p>
			</div>	
			
			<div id="feedback" class="col-sm-7">
				<form action="feedback/addFeedBack">
					<h4>SEND FEEDBACK</h4>
					<div class="form-row">
						<div class="col-sm-6 form-group">
							<input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
						</div>
						
						<div class="col-sm-6 form-group">
							<input class="form-control" id="email" name="email"	placeholder="Email" type="email" required>
						</div>
					</div>
			
					<textarea class="form-control" id="comments" name="feedBack" placeholder="Feedback" rows="5"></textarea>
					<br>
			
					<div class="row " align="right">
						<div class="col-sm-12 form-group">
							<button class="btn btn-default pull-right" type="submit">Send</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</footer>
</body>
</html>