<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit List</title>
</head>
<body>
<h1> ${list.title}</h1>

<sf:form action="add-item" method="POST" modelAttribute="item">
<label>Name: </label><sf:input type="text" placeholder="Item Name" name="item-name" path="ItemName" />
<label>Cost: </label><sf:input type="number" step=".01" name="item-cost" style="width: 50px" path="Cost"/>
<label>Note: </label><sf:input type="note" name="item-note" path="note" />
<label>Priority: </label>
<sf:select path="Priority">
<option value="HIGH">HIGH</option>
<option value="MEDIUM">MEDIUM</option>
<option value="LOW">LOW</option>
</sf:select>
<input type="Submit" value="Add Item">
</sf:form>


<div class="list-items-container">
<c:forEach var="item" items="${list.items }">
<p>" ${item.itemName } "</p>
<p>$${item.cost }</p>
<p>Priority: ${item.priority } </p>
<hr>
</c:forEach>

<p>Total: $${list.total }</p>
</div>

</body>
</html>