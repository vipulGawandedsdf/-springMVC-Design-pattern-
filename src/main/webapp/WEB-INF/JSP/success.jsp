<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Successful login..!!</h1>
	 
<table border="1" style="align-items: center;">
	<tbody  style="align-items: center;">
	  <tr>
	 <th>ID</th>
	  <th>NAME</th>
	   <th>UNAME</th>
	    <th>PASSWORD</th>
	 </tr>
 <%-- 	<c:forEach items="${userList}"  var="user">  --%>
 	<c:forEach items="${userList}" var="user" >
		    <tr>
		     <td>${user.uid}</td>
		     <td>${user.name}</td>
		     <td>${user.uname}</td>
		     <td>${user.password}</td>
		     <td><a href="${pageContext.request.contextPath}/delete/${user.uid}">DELETE</a></td>
		     <td><a href="${pageContext.request.contextPath}/edit/${user.uid}">EDIT</a>
		    </tr>
		</c:forEach>
		</tbody>
 </table>
 <a href="logout">Logout</a>
	
</body>
</html>