<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New List</title>
</head>
<body>
<sf:form modelAttribute="newList" method="POST" action="home">
<label>List Name: </label> <sf:input type="text" path="Title" />
<input type="submit" value="Create">
</sf:form>

<a href="home">Home</a>
</body>
</html>