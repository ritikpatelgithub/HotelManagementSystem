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
        display: flex;
        background-color: #f0f8ff; /* Changed to an attractive background color */
        justify-content: center;
         background-image: url('/backgroundhotel.jpg');
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
    border: 2px solid black;
    text-decoration: none;
    text-align: center;
    display: block;
    font-size: 20px;
    margin: 6px;
    padding: 8px;
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
}
    
    #abc {
        margin-top: 17px;
    }
    h1{
    	font-weight: bold;
    	margin-bottom:85px;
    	color:white;
    }
    h1:hover{
	 color: #f52a07;
}
</style>
<body>
 <div>
    <h1>Customer Home</h1>
        <a href="addcustomer" id="abc">Register</a><br>
        <a href="CustomerLogin.jsp">Login</a>
    </div>

</body>
</html>