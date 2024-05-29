<%@page import="com.java.foodmanagmentsystem.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
    body {
        display: flex;
        background-color: #f0f8ff; 
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    div {
        border: 2px solid black;
        width: 320px;
        height: 370px;
          background-color: rgb(23 177 147);
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        border-radius: 8px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        transition: background-color 0.6s; 
    }
    a {
       border: 2px solid #1a815f;
    text-decoration: none;
    text-align: center;
    display: block;
    font-size: 24px;
    margin: 2px;
    margin-top: -4px;
    padding: 12px;
    width: 180px;
    border-radius: 8px;
    background-color: rgb(235 243 235);
    background: linear-gradient(to right, #11998e, #38ef7d);
    color: white;
    transition: background-color 0.3s, color 0.3s;
    }
     a:hover {
           color: #f52a07;
    background: linear-gradient(to right, #09f544, #b5b759);
    border:2px solid white;
}
h1:hover{
	 color: #f52a07;
}
    #abc {
        margin-top: 17px;
    }
    h1{
    font-weight: bold;
    margin-bottom: 34px;
    color: white;
    margin-top: -22px;
    }
</style>
<body>
<%Integer customer_id=(Integer)session.getAttribute("customerinfo"); %>

<%if(customer_id!=null) {

%>
<div>
<h1>${message}</h1>
<h1>Choose an Options</h1>
<!--<a href="fetchitemsbyhotel.jsp">View Products by Hotel</a><br>-->
<a href="fetchproductbyhotelname">View Products by Hotel</a><br>
<a href="fetchallproducts">Buy Food</a><br>
<a href="repricerange.jsp">Display Product By Range</a><br>


<%} else{%>


<a href="CustomerLogin">Login First</a>

<%} %>
</div>

</body>
</html>