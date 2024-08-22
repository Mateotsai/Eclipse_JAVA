<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Hello,World <br />
	<hr />
	<jsp:include page="brad19.jsp"></jsp:include>
		<jsp:param value="10" name="x"/>
	<hr />
	<jsp:include page="brad20.jsp"></jsp:include>
	<hr />
	</body>
</html>