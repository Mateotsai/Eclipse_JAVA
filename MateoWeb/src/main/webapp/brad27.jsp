<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String account = request.getParameter("account");
	String[] habits = request.getParameterValues("habit");
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Method: ${pageContext.request.method } <br />
		1. ${paramValues.habit[0]} <br />
		2. ${paramValues.habit[1]} <br />
		3. ${paramValues.habit[2]} <br />
		4. ${paramValues.habit[3]} <br />
		5. ${paramValues.habit[4]} <br />
		6. ${paramValues.habit[5]} <br />
		7. ${paramValues.habit[6]} <br />
		<hr />
		${pageContext.request.remoteAddr} <br />
		${pageContext.request.locale} <br />
		${pageContext.request.localName} <br />
		${pageContext.request.locale.displayLanguage} <br />
		
	
	</body>
</html>