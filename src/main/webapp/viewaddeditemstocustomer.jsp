<%@page import="com.java.foodmanagmentsystem.entity.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f8f8;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        margin-top: 50px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 15px;
        text-align: left;
    }
    th {
        background-color: #f4f4f4;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    .remove-link {
        color: #ff0000;
        text-decoration: none;
    }
    .remove-link:hover {
        text-decoration: underline;
    }
    .btn {
        display: inline-block;
        padding: 10px 20px;
        margin: 20px 0;
        font-size: 16px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-align: center;
        text-decoration: none;
    }
    .btn:hover {
        background-color: #0056b3;
    }
</style>
<body>
<div>
<h1>Order Summary</h1>
<%List<Item> items=(List)session.getAttribute("itemlist"); %>

<table cellpadding="20px" border="1px">
<tr>
	<th>name</th>
	<th>cost</th>
	<th>type</th>
	<th>quantity</th>
	<th>remove</th>
</tr>
<%for(Item i:items){ %>
<tr>
<td><%=i.getName() %></td>
<td><%=i.getCost() %></td>
<td><%=i.getType() %></td>
<td><%=i.getQuantity() %></td>
<td><a href="removeitem?=<%=i.getName()%>">Remove</a></td>
</tr>
<%} %>


</table>
<a href="addfoodorder" class="btn">Confirm</a>
</div>
</body>
</html>