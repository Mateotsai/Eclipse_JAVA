<%@ tag import="java.util.HashMap" %>
<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag dynamic-attributes="product01" %>
<%
	HashMap<String,String> itemTR = (HashMap<String,String>)jspContext.getAttribute("product01");
	out.append("<tr>")
   .append("<td>").append(itemTR.get("name")).append("</td>")
   .append("<td>").append(itemTR.get("price")).append("</td>")
   .append("</tr>");
%>