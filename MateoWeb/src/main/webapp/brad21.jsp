<%@page import="tw.mateo.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	    String name = request.getParameter("name");
		Bike bike = new Bike();
		bike.upSpeed().upSpeed().upSpeed().upSpeed().upSpeed().upSpeed();
		request.setAttribute("name", name);
		request.setAttribute("bike", bike);
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		I am Brad21<br />
		<jsp:forward page="brad22.jsp"></jsp:forward>
	</body>
</html>