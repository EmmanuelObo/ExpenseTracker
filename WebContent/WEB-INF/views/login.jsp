<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<!-- TODO: Fix the navbar -->
<nav class="navbar navbar-light bg-faded">
<ul class="nav navbad-nav">

</ul>
</nav>

<div class="container">
	<h1 class="home-page-title">Expense Tracker</h1>
	<p class="home-page-description text-primary">Track your expenses easily, quickly and painlessly </p>
	
	<sf:form action="login" method="POST" modelAttribute="user">
	
		<div class="form-group">
			<label for="username">Username</label>
			<sf:input type="text" class="form-control" path="Username" placeholder="Enter Username" />
		</div>
		
		<div class="form-group">
			<label for="password">Password</label>
			<sf:input type="password" class="form-control" path="Password" placeholder="Enter Password" /><br>
			<input type="submit" value="Login" class="btn btn-default">
			<br>
		</div>
	</sf:form>
	
	<form action="register" method="GET">
		<input type="submit" value="Sign Up" class="btn btn-primary">
	</form>
	
	<a href="login-guest">Continue as Guest</a>
	<p class="error-message"><strong> ${errorMsg} </strong></p>
</div>
</body>
</html>