<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>

<!-- TODO: Fix the navbar -->
<nav class="navbar navbar-light bg-faded">
<ul class="nav navbad-nav">
	<li class= "nav-item">
	<a class="nav-link" href="#"></a>
	</li>
	<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle" href="http://example.com" id="supportedContentDropdown"> </a>
		<div class="dropdown-menu" aria-labelledby="supportedContentDropdown">
			<a class="dropdown-item" href="#">Create List</a>
			<a class="dropdown-item" href="#">My Lists</a>
			<a class="dropdown-item" href="#">Preferences</a>
		</div>
	
	</li>
</ul>
</nav>

<body>
<div class="container">
	<h1 class="home-page-title">Expense Tracker</h1>
	<p class="home-page-description text-primary">Track your expenses easily, quickly and painlessly </p>
	<form>
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" class="form-control" placeholder="Username">
		</div>
		<div class="form-group">
			<label for="username">Password</label>
			<input type="password" class="form-control" placeholder="Password">
		</div>
		
		<div class="form-group">
			<label for="username">Confirm Password</label>
			<input type="password" class="form-control" placeholder="Password">
		</div>
		
		<div class="form-group">
			<label for="username">Email</label>
			<input type="email" class="form-control" placeholder="Email">
		</div>
		
		<div class="form-group">
			<input type="submit" value="Register" class="btn btn-primary">
			<br>
		</div>
		<a href="welcome">Continue as Guest</a>
	</form>
</div>
</body>
</html>