<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
            if (((String) request.getAttribute("isLogin")).equals("true")) {
                session.setAttribute("isLogin","true");
                response.sendRedirect("index.jsp");
            } 
	%>
	<h2>this page</h2>
</body>
</html>