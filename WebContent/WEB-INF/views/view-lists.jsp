<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/view-list.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> ${user.username }'s Lists</title>
</head>
<body>
<h1>Your Lists</h1>
<ul>
<c:forEach var="currentlist" items="${usersLists}">

<c:set var="count" value="${count + 1 }" scope="page" />
<li>${currentlist.title}&nbsp; 

<form action="view-lists" method="POST">
<input type="hidden" value="${currentlist.id}" name="listID">
<input type="submit" value="Remove">
</form>

<form action="edit-list" method="POST">
<input type="hidden" value="${currentlist.id}" name="listID">
<input type="submit" value="Edit">
</form>

<form id="list-viewer${count}" class="form-view-list" action="view-list" method="POST">
<input type="hidden" id="list-id" value="${currentlist.id}" name="listID">
<input type="hidden" id="list-title" value="${currentlist.title}" name="listTitle">
<input type="hidden" id="list-total" value="${currentlist.total}" name="listTotal">
<input type="hidden" id="date-created" value="${currentlist.dateCreated }" name="dateCreated">
<input type="hidden" id="list-owner" value="${user.username}" name="listOwner">
<input type="submit" value="View">
</form>

<div class="modal fade bd-example-modal-sm" id="view-list-modal" tabindex="-1" role ="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
<div class="modal-dialog modal-sm">
<div class="modal-content" style="text-align: center">

</div>
</div>
</div>

</li>
</c:forEach>
</ul>



<a href="home">Home</a>

</body>
</html>