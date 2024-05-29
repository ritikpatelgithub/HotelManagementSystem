<%@page import="com.java.foodmanagmentsystem.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
    }
    th, td {
        padding: 15px;
        text-align: left;
    }
    th {
        background-color: #333;
        color: #fff;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    a {
        text-decoration: none;
        color: #007BFF;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<%List<Product> products = (List<Product>) request.getAttribute("productsList"); %>
<table cellpadding="20px" border="1px">
    <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Cost</th>
            <th>Add</th>
        </tr>
    </thead>
    <tbody>
    <% for(Product product : products) { %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getType() %></td>
            <td><%= product.getCost() %></td>
            <td><a href="additem?id=<%=product.getId()%>">Add</a></td>
        </tr>
    <% } %>
    </tbody>
</table>
<button><a href="viewaddeditemstocustomer.jsp">Proceed to buy</a></button>
</body>
</html>
