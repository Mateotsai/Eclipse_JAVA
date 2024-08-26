<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%> 
<c:if test="${empty member.account }">
	<c:redirect url="login.jsp"></c:redirect>   
</c:if>

<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/brad"
	user="root"
	password="root"
/>

<c:if test="${!param.delid }">
	<sql:update>
	DELETE FROM member WHERE id = ?
	<sql:param>${param.delid }</sql:param>
	</sql:update>
</c:if>

<script>
    function isDel(id) {
        if (confirm("是否要刪除?" )) {
            window.location.href = "?delid=" + id;
        }
    }
</script>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Welcome, ${member.account } <br />
	<a href="logout.jsp">log out</a> <br />
	<a href="addMember.jsp">Add Member</a> <br />
	<a href="editMember.jsp">Edit Member</a> <br />
	<hr />
	<table border="1" width=100%>
		<tr>
			<th>ID</th>
			<th>Account</th>
			<th>Name</th>
			<th>Delete</th>
		</tr>
		<sql:query var="rs">
		SELECT * FROM member
		</sql:query>
		<c:forEach var="row" items="${rs.rows}">
			<tr>
				<td>${row.id}</td>
				<td>${row.account}</td>
				<td>${row.name}</td>
				<td> <a href="#" onclick="return isDel(${row.id});">Delete</a></td>
			</tr>
		</c:forEach>
		
		
	</table>
	
	
	</body>
</html>