<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] name1 = {"Brad","Mark" ,"Kevin" ,"John" };
	pageContext.setAttribute("names1", name1);
	
	LinkedList<String> list = new LinkedList<>();
	list.add("Brad1");
	list.add("Marl1");
	list.add("Kevin1");
	list.add("John1");
	
	HashMap<String, Object> map = new HashMap<>();
	pageContext.setAttribute("map", map);
	map.put("name","Brad1");
	map.put("gender","Male");
	map.put("age","18");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	names1[2] = ${name1[2] } <br />
	list[1] = ${list[1] } <br />
	${map.name} : {map.gender} : {map.age} <br />
	${map["name"]}  <br />	
	</body>
</html>