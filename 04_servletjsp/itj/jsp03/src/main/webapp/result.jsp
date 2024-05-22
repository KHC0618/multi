<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>아이디 : <%= id %></h3>
	<h3>비번 : <%= pwd %></h3>
</body>
</html>