<%@ page import="com.java.foodmanagmentsystem.entity.Product"%>
<%@ page import="java.util.List" isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    table {
        border-collapse: collapse;
        width: 80%;
        margin: 20px auto;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        background-color: white;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    a {
        color: #4CAF50;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
    .links {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }
    .links a {
        margin: 0 10px;
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border-radius: 5px;
    }
    .links a:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div align="center">
    <h1>Product Management</h1>
    ${message}
    <% List<Product> products = (List<Product>) request.getAttribute("products"); %>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Type</th>
            <th>Cost</th>
            <th>Discount</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <% if (products != null) { 
               for (Product product : products) { %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getType() %></td>
                <td><%= product.getCost() %></td>
                <td><%= product.getDiscount() %></td>
                <td><a href="updateproduct?id=<%= product.getId() %>">Update</a></td>
                <td><a href="delete?id=<%= product.getId() %>">Delete</a></td>
            </tr>
        <%   } 
           } %>
    </table>
    <div class="links">
        <a href="HotelOptions.jsp">Back to main menu</a>
        <a href="hotellogout">Log Out</a>
    </div>
</div>
</body>
</html>
