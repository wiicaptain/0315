<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
     <%@page import="mycode.*" %>
      <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = request.getParameter("username");	
if(username==null)
	username="UnKnown";
session.setMaxInactiveInterval(120); //設定其過期的時限為 2分鐘
UserInfo user = UserInfo.getInstance();

UserSessionBinding usb = new UserSessionBinding();
usb.setUsername(username);
user.addUser(username); //加入至 list
session.setAttribute("user", usb); //此處發生 binding
%>
<h2><%=username %></h2>
</body>
</html>