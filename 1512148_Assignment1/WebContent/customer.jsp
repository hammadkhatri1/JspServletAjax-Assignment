<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
<%@ include file="shop.css" %>
</style>
<title>Customer Page</title>
</head>
<body>
<div class="boxstart">
<h1>Assign 1512148 shop </h1>
<h2>Buy Items Here</h2>
</div>

<br>
<h3>Item List</h3>
<table class="table table-hover table-bordered">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Operation</th>
	</tr>

	<c:forEach var="item" items="${item}">
		<tr>
			<td>${item.itemId}</td>
			<td>${item.item_name}</td>
			<td><a href="buy.jsp?itemId=${item.itemId}">Buy Me! </a>	
			</td>
		</tr>
	</c:forEach>
</table>	

</body>
</html>
