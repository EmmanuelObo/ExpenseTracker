<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<title>Welcome</title>
</head>
<body>
<div class="container">
	<h1 class="home-page-title">Expense Tracker</h1>
	<p class="home-page-description text-primary">Track your expenses easily, quickly and painlessly </p>
	<form action="home" method="GET">
	<input type="submit" value="Start Tracking" class="btn btn-primary">
	</form>
</div>

</body>
</html>