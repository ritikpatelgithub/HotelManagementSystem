<%@ page import="com.java.foodmanagmentsystem.entity.Hotel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Management</title>
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
</style>
</head>
<body>
<div align="center">
    <h1>Hotel Management</h1>
    <% List<Hotel> hotels = (List<Hotel>) request.getAttribute("unblockhotels"); %>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Mobile Number</th>
            <th>Status</th>
            <th>Block</th>
        </tr>
        <% if (hotels != null) { 
               for (Hotel hotel : hotels) { %>
            <tr>
                <td><%= hotel.getId() %></td>
                <td><%= hotel.getName() %></td>
                <td><%= hotel.getEmail() %></td>
                <td><%= hotel.getPassword() %></td>
                <td><%= hotel.getM_number() %></td>
                <td><%= hotel.getStatus() %></td>
                <td><a href="blockhotel?id=<%= hotel.getId() %>">Block</a></td>
            </tr>
        <%   } 
           } %>
    </table>
</div>
</body>
</html>
