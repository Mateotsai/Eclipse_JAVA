<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int max = Integer.parseInt(request.getRealPath("max"));
    	request.setAttribute("name","Brad");
    	request.setAttribute("max",max);
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	I am Brad22 <br>
	<jsp:forward page="brad22.jsp"></jsp:forward>
	</body>
</html>