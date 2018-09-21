<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
<%@ include file="shop.css" %>
</style>
<title>Insert title here</title>
</head>
<body>

<div class="boxstart">
<h2>Customer basket</h2>
<h3>Item Selected</h3>
</div>
<br>
Item selected: <input type="text" name="itemId" value="<%= request.getParameter("itemId") %>">
First Name: <input type="text" name="customerFirstName">
Last Name: <input type="text" name="customerLastName">

<input type="button" value="Buy Now!" onclick="Insert()">

</body>
</html>

<script>

function Insert(){
   			var customerFirstName = document.getElementsByName("customerFirstName").item(0).value;
   			var customerLastName = document.getElementsByName("customerLastName").item(0).value;
   			var itemId = document.getElementsByName("itemId").item(0).value;
   			
   		            $.ajax
			        ({
			            type: "POST",         
			            data: '&customerFirstName='+customerFirstName+'&customerLastName='+customerLastName+'&itemId='+itemId,
			            url: "CustomerController?action=Order",
			            success:function(content)
			        {          

		                    window.location = "/1512148_Assignment1/customer";
			        }           
			        });
        }
        </script>
        