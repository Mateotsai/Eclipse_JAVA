<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
	//先清掉前面的人有可能登入的帳號
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Login Page
	<hr />
	<form action="checkAccount2.jsp" method="post">
		Account: <input name="account"> <br />
		Password: <input name="passwd" type="password"> <br />
		<input type="checkbox" name="rememberMe" value="1"> Remember me <br />
		<input type ="submit" value ="Login" />
	
	</form>
	</body>
</html>