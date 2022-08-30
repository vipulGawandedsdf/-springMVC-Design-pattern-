<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center"> 
    ${msg}
    </div>
    <div align="center"> 
	<form action="login">
		USERNAME: <input type="text" name ="uname"><br>
		PASSWORD: <input type="text" name="password"><br>
		<input type="submit" value="SUBMIT"> &nbsp; &nbsp;<!-- <br>  -->
		<div  >
		<a href="registrationPage">Register USER</a>
		</div> 
		 
		<a href="forget">forget password</a>
	 
	</form>
	</div>
</body>
</html>