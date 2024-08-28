<%@page import="tw.mateo.apis.MyTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Object obj = session.getAttribute("obj2");
	if(obj == null){
		response.sendRedirect("brad42.jsp");
		response.sendError(HttpServletResponse.SC_FORBIDDEN ,"XXX");
	}
	MyTest lottery = (MyTest)obj;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Lottery: ${obj2.lottery} <br />
		Lottery: <%= lottery.getLottery() %> <br />
		<a href="brad44.jsp">Logout</a>
	</body>
</html>