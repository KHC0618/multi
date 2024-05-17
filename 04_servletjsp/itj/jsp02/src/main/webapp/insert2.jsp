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

    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String tel = request.getParameter("tel");



%>

    당신의 회원가입 정보입니다.
    <hr>
    당신의 id는 <%= id %>입니다.<br>
    당신의 pw는 <%= pw %>입니다.<br>
    당신의 name은 <%= name %>입니다.<br>
    당신의 tel은 <%= tel %>입니다.<br>

</body>
</html>