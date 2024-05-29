<%@page import="com.java.foodmanagmentsystem.entity.Hotel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unapproved Hotels</title>
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
    .container {
        text-align: center;
        margin-top: 20px;
    }
    .container a {
        margin: 0 10px;
        padding: 10px 20px;
        background-color: #007BFF;
        color: #fff;
        border-radius: 5px;
        text-decoration: none;
    }
    .container a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <%
    List<Hotel> hotels = (List<Hotel>) request.getAttribute("unapprovedhotels");
    %>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Mobile Number</th>
                <th>Status</th>
                <th>Approve</th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Hotel h : hotels) {
            %>
            <tr>
                <td><%=h.getId()%></td>
                <td><%=h.getName()%></td>
                <td><%=h.getEmail()%></td>
                <td><%=h.getAddress()%></td>
                <td><%=h.getM_number()%></td>
                <td><%=h.getStatus()%></td>
                <td><a href="approvehotel?id=<%=h.getId()%>">Approve</a></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <div class="container">
        <a href="adminoptions.jsp">Back to Menu</a>
        <a href="adminlogout">Logout</a>
    </div>
</body>
</html>
