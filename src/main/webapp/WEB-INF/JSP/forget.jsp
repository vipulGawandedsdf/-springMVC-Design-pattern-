<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div align="center">${msg}</div>
<form action="change">
      uname: <input type="text" name="uname" placeholder="Enter username"><br>
     password:<input type="text" name="password" placeholder="enter Current password"><br>
     newpassword: <input type="text" name="newpw" placeholder="enter new password"><br>
      reEnterpass: <input type="text" name="reEnterpw" placeholder=" re-enter new password"><br>
      <input type="submit" value="SUBMIT">

 

</form>
</body>
</html>