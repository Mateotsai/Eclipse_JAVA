<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="brad14.jsp" %>
    <%
    String name = request.getParameter("name");
    if (name == null) name = "world";
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Hello, World<br />
	Hello, <% out.print(name); %> <br />
	Hello, <%= (int)(Math.random()*49 + 1) %> <br />
	(隱含物件)jsp本身內建的物件
	<hr />
	<%
		HashSet<Integer> set = new HashSet<>();
		while(set.size()< 6 ) set.add((int)(Math.random()*49 + 1));
		out.print(set);
	%>
	</body>
</html>