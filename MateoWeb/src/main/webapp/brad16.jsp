<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mesg = "";
	String errType = request.getParameter("errType");
	if (errType != null){
		switch (errType){
			case "1": mesg = "Account EXIST!"; break;
			case "2": mesg = "資料庫讀取失敗"; break;
			case "3": mesg = "資料庫新增失敗"; break;
		}
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
	<div><%= mesg %></div>

	<script>
		function checkForm(){
			return true;
		}
	</script>
		
	<form action="Register" method="post" onsubmit="return checkForm();"> 
		Account : <input name="account" /><br />
		Password : <input name="passwd" type="password" /><br />
		Name : <input name="name" /><br />
		<input type="submit" value="register"/><br />
	</form>
	
	
	</body>
</html>