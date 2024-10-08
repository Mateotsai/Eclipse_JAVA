<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.mindrot.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
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
		<sql:param>${param.account } </sql:param>
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
		<script>src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script type="text/javascript">
			function isAccountExit(){
				$.get("isAccountExit.jsp?account="$('#account').val(),function(data,status)){
					if(status == 'success'){
						$('mesg').html(data.count>0? "Account Exist": "");
					}
				});
			}
		</script>
		
	</head>
	<body>
	Add Member Page
	<form action="Brad22" method="post" enctype="multipart/form-data">
		Account: <input name="account" id="account" onblur='isAccountExist()'><span id='mesg'></span> <br />
		Password: <input name="passwd" type="password"> <br />
		Name: <input name="name"> <br />
		Icon: <Input type="file" name="icon"> <br />
		<input type ="submit" value ="Add Member" />
	
	</form>
	</body>
</html>