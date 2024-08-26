<%@page import="tw.apis.MyTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	MyTest obj = new MyTest();
	int lottery = obj.getLottery();
	session.setAttribute("obj2", obj);
	
	
	session.setMaxInactiveInterval(10);
	//10秒後會取消session，可在設定強制登出
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Lottery: <%= lottery %> <br />
	Lottery: ${obj2.lottery} <br />
	<a href="brad43.jsp">Next: brad43.jsp</a>
	</body>
</html>

<%
	obj.setLottery(1000);

%>
	<!-- 經由42跳轉到43的時候，會變成1000 -->