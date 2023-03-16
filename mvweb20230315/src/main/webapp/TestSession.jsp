<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%session.setAttribute("password", "1234"); %>
	<br>
	<%session.setAttribute("password", "5678"); %>
	<br>
	<%session.removeAttribute("password");%>
	
	session.setAttribute("userName","John")
	<br>
	<%
	session.setAttribute("userName", "John"); //attribute userName 新增
	%>
	session.setAttribute("userName","Mary")
	<br>
	<%
	session.setAttribute("userName", "Mary"); //attribute userName 修改
	%>
	session.removeAttribute("userName","Mary")
	<br>
	<%
	session.removeAttribute("userName"); //attribute userName 刪除
	%>

	<br> after session.invalidate()
	<br>
	<%
	session.invalidate(); //刪除整個session
	%>
</body>
</html>