<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>

<form:form action="saveitemorder" modelAttribute="itemobj">
 Name: <form:input path="name"  readonly="true"/><br>
Type: <form:input path="type"   readonly="true"/><br>
Cost: <form:input path="cost"   readonly="true"/><br>
Enter Quantity: <form:input path="quantity"  type="number"/><br>

<input type="submit" id="btn">
</div>
</form:form>

</body>
</html>