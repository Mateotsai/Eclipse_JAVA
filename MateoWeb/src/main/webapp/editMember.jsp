<%@page import="tw.mateo.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.mindrot.*" %>
<%@page import="java.util.Base64"%>
<%@page import="javax.servlet.jsp.jstl.sql.Result"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:if test="${empty member.account}">
    <c:redirect url="login.jsp"/>
</c:if>
<sql:setDataSource
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost/brad"
    user="root"
    password="root"
/>

<c:if test="${empty editMember}">
    <c:if test="${!empty param.editid}">
        <sql:query var="rs">
            SELECT * FROM member WHERE id = ?
            <sql:param>${param.editid}</sql:param>
        </sql:query>
        <c:if test="${rs.rowCount == 0}"><c:redirect url="main.jsp"/></c:if>

        <%
        Result rs = (Result)pageContext.getAttribute("rs");
        long id = (Long)rs.getRows()[0].get("id");
        String account = (String)rs.getRows()[0].get("account");
        String passwd = (String)rs.getRows()[0].get("passwd");
        String name = (String)rs.getRows()[0].get("name");
        byte[] icon = (byte[])rs.getRows()[0].get("icon");
        String iconBase64 = Base64.getEncoder().encodeToString(icon);

        Member editMember = new Member();
        editMember.setId((int)id);
        editMember.setAccount(account);
        editMember.setPasswd(passwd);
        editMember.setName(name);
        editMember.setIcon(iconBase64);

        session.setAttribute("editMember", editMember);
        %>
    </c:if>
</c:if>

<c:if test="${!empty editMember && pageContext.request.method=='POST'}">
    <sql:update>
        UPDATE member SET account=?, passwd=?, name=? WHERE id = ?
        <sql:param>${param.account}</sql:param>
        <sql:param>
            ${empty param.passwd ? editMember.passwd : BCrypt.hashpw(param.passwd, BCrypt.gensalt())}
        </sql:param>
        <sql:param>${param.name}</sql:param>
        <sql:param>${editMember.id}</sql:param>
    </sql:update>
    <%
    session.removeAttribute("editMember");
    %>
    <c:redirect url="main.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Member</title>
</head>
<body>
    Edit Member Page
    <hr />
    <form method="post">
        Account: <input name="account" value="${editMember.account}" readonly> <br />
        Password: <input name="passwd" type="password"> (Leave blank to keep current password) <br />
        Name: <input name="name" value="${editMember.name}"> <br />
        Icon: <img src="data:image/png;base64,${editMember.icon}" /> <br />
        <input type="submit" value="Update" />
    </form>
</body>
</html>