<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="hello" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<hello:hello name="Brad"/> <br />
		<hello:hello name="Kevin"/> <br />
		<hello:hello /> 
		<br />MyTest <br />
		${param.x } <br />
	</body>
</html>