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
        margin: 4px;
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
    margin-top: 2px;
    color:white;
    }
     h1{
    	font-weight: bold;
    	margin-bottom:66px;
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
  ${message}
  <h1>Hotel Login</h1>
	<form action="hotelloginvalidate" method="post">
	<input type="email" name="email" placeholder="Enter Email"><br>
    <input type="text" name="password" placeholder="Enter Password"><br>
	<input type="submit" value="Login"  id="btn">
	
	</form>
  </div>
</body>
</html>