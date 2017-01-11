<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html >
<html>
<head>
<script src="js/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit List</title>
</head>
<body>
<h1> ${list.title}</h1>

<form action="add-item" method="POST" id="edit-list-form">
<label>Name: </label><input type="text" placeholder="Item Name" name="item-name" id="item-name" />
<label>Cost: </label><input type="number" step=".01" name="item-cost" style="width: 50px" id="item-cost"/>
<label>Note: </label><input type="text" name="item-note" id="item-note" />
<label>Priority: </label>
<select id="item-priority">
<option value="HIGH">HIGH</option>
<option value="MEDIUM">MEDIUM</option>
<option value="LOW">LOW</option>
</select>
<input type="Submit" value="Add Item">
</form>


<div class="list-items-container">
<c:forEach var="item" items="${list.items }">
<p>" ${item.itemName } "</p>
<p>$${item.cost }</p>
<p>Priority: ${item.priority } </p>
<form action="remove-item" method="POST">
<input type="hidden" value="${item.id}" name="itemId">
<input type="hidden" value="${item.list.id }" name="currentListID">
<input type="submit" value="Remove">
</form>
<hr>
</c:forEach>

<div id="user-list-items"></div>

<p>Total: $${list.total }</p>
</div>


<script src="js/manage-items.js"></script>
<script src="js/items-ajax.js"></script>

</body>
</html>