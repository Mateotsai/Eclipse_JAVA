<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.mindrot.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:if test= "${empty param.account }">
	<c:redirect url="login.jsp"></c:redirect>   
</c:if>

<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/brad" 
	user="root" 
	password="root" 
/>

<sql:query var ="rs">
	SELECT * FROM member WHERE account = ?
	<sql:param> ${param.account }</sql:param>
</sql:query>
<c:if test="${rs.rowCount == 0 }"><c:redirect url="login.jsp"></c:redirect> </c:if>
${rs.rows[0].account } : ${rs.rows[0].passwd } : ${rs.rows[0].name }
<!-- 取得的帳號會是陣列，僅有一筆，故用[0]取到的便是唯一內容 -->

<c:choose>
	<c:when test="${BCrypt.checkpw(param.passwd, rs.rows[0].passwd) }">
		<c:set var="member" value="${rs.rows[0] }" scope="session"></c:set>
		<c:redirect url="main.jsp"></c:redirect>
	</c:when>
	<c:otherwise>
		<c:redirect url="login.jsp"></c:redirect>
	</c:otherwise>
</c:choose>