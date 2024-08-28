<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.mindrot.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import="org.mindrot.*" %>
<c:if test="${empty member.account }">
	<c:redirect url="login.jsp"></c:redirect>   
</c:if>
<c:if test="${!empty param.account }">
	<c:if test="${pageContext.request.method !='POST'}">
		<c:redirect url="login.jsp"></c:redirect>
</c:if>
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/brad"
		user="root"
		password="root"
	/>
	<sql:update>
		INSERT INTO member (account,passwd,name) VALUES (?,?,?)
		<sql:param>${param.account }</sql:param>
		<sql:param>${BCrypt.hashpw(param.passwd, BCrypt.gensalt()) }</sql:param>
		<sql:param>${param.name }</sql:param>
	</sql:update>
	<c:redirect url="main.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Add Member Page
	<form action="Brad21" method="post" enctype="multipart/form-data">
		Account: <input name="account"> <br />
		Password: <input name="passwd" type="password"> <br />
		Name: <input name="name"> <br />
		Icon: <Input type="file" name="icon"> <br />
		<input type ="submit" value ="Add Member" />
	
	</form>
	</body>
</html>