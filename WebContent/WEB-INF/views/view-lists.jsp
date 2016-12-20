<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<script src="js/jquery.js"></script>
<script src="js/edit-list.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> ${user.username }'s Lists</title>
</head>
<body>
<h1>Your Lists</h1>
<!-- TODO show users lists here -->
<ul>
<c:forEach var="currentlist" items="${usersLists}">
<li>${currentlist.title}&nbsp; 
<form action="view-lists" method="POST">
<input type="hidden" value="${currentlist.id}" name="listID">
<input type="submit" value="Remove">
</form>

<form id="edittor" action="edit-list" method="POST">
<input type="hidden" value="${currentlist.id}" name="listID">
<input type="hidden" value="${currentlist.title}" name="listTitle">
<input type="submit" value="Edit">
</form>
</li>
</c:forEach>
</ul>

<a href="home">Home</a>

</body>
</html>