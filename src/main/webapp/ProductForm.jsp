<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
    body {
        display: flex;
        background-image: url('backgroundhotel.jpg');
        justify-content: center;
        align-items: center;
        height: 100vh;
        
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
    input {
        border: 2px solid black;
        text-decoration: none;
        text-align: center;
        display: block;
        font-size: 20px;
        margin: 0px;
        padding: 7px;
        width: 218px;
        border-radius: 8px;
        background-color: white; /* Added background color */
        color: rgb(43, 10, 10);
    }
    #abc {
        margin-top: 17px;
    }
    #btn{
    	  background: linear-gradient(to right, #11998e, #38ef7d);
    	width: 158px;
    margin-left: 17%;
    margin-top: 7px;
    white:white;
    }
     h1{
    	font-weight: bold;
    	margin-bottom:35px;
    	color:white;
    }
    #btn:hover{
      color: #f52a07;
    background: linear-gradient(to right, #09f544, #b5b759);
    }
    h1:hover{
      color: #f52a07;
    }
    
</style>
<body>
<div>
<h1>Add Product</h1>
<form:form action="saveproduct" modelAttribute="productobj">
 <form:input path="name"  placeholder="Enter Name"/><br>
<form:input path="type"  placeholder="Enter Type"/><br>
 <form:input path="cost"  placeholder="Enter Cost"/><br>
  <form:input path="discount"  placeholder="Discount"/>

<input type="submit" id="btn">
</form:form>
</div>
</body>
</html>