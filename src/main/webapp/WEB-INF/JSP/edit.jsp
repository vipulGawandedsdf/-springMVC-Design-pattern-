<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update">
		ID:<input   name="uid" value="${data.uid}"> <br>
		NAME: <input type="text" name="name" value="${data.name}"><br>
		USERNAME: <input type="text" name="uname" value="${data.uname}"><br>
		PASSWORD: <input type="text" name="password" value="${data.password}"><br>
		<input type="submit" value="UPDATE">
	</form>
</body>
</html>