<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="brad" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="iii" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<brad:tag1 />
	<hr />
	<brad:tag2 />
	<hr />
	Lottery: <brad:lottery />
	
	<table width="100%" border="1">
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<brad:item name="IPhone" price="1000" />
		<brad:item name="Mouse" price="200" />
		<brad:item name="Notebook" price="40000" />
		<brad:item name="Keyboard" price="2000" />
	</table>
	
		<hr />
		<iii:hello name="brad" />
	</body>
</html>