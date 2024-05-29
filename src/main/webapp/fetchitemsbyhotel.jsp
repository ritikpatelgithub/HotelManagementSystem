<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch Products by Hotel</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f0f0f0;
    }
    form {
        background-color: #17b193;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        padding: 30px;
        border-radius: 10px;
        width: 300px;
        box-sizing: border-box;
    }
    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #fff;
    }
    select, input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background: linear-gradient(to right, #11998e, #38ef7d);
        color: white;
        cursor: pointer;
        font-size: 16px;
        display: block;
        margin: 0 auto;
    }
    input[type="submit"]:hover {
        background: linear-gradient(to right, #09f544, #b5b759);
        color: #f52a07;
    }
</style>
</head>
<body>
    <% List<String> list = (List<String>) request.getAttribute("allhotellist"); %>
    <form action="fetchproductsbyhotel">
        <label for="hotel">Hotel Options Available</label> 
        <select name="hotel" id="hotel">
        <option>Hotel Name</option>
            <% for (String item : list) { %>
                <option><%= item %></option>
            <% } %>
        </select>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
