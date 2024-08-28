<%@page import="tw.mateo.apis.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member member2 = new Member();
	member2.setId(2); member2.setAccount("amy"); member2.setName("Amy");
%>
<jsp:useBean id="member1" class="tw.mateo.apis.Member"></jsp:useBean>
<jsp:setProperty property="id" value="1" name="member1" />
<jsp:setProperty property="account" value="brad" name="member1" />
<jsp:setProperty property="name" value="Brad" name="member1" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member1: (使用標籤bean語法創建)
			<jsp:getProperty property="id" name="member1" />
			<jsp:getProperty property="account" name="member1" />
			<jsp:getProperty property="name" name="member1" />
			<hr />
		Member2: (使用java語法創建)
			<%= member2.getId() %> : <%= member2.getAccount() %> : <%= member2.getName() %>
			<hr />
		Member1:  (使用Bean可以再用java語法創建相容，使用java語法創建的沒辦法用Bean讀取>)
			<%= member1.getId() %> : <%= member1.getAccount() %> : <%= member1.getName() %> : 
			<%= member1 %>
			<hr />
	</body>
</html>