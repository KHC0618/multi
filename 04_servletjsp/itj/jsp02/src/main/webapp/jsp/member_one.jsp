<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.multi.jsp.member.MemberDTO"%>
<%@page import="com.multi.jsp.member.MemberDAO"%>


<%

    String id = request.getParameter("id"); // input 안에 있는 name = "값"을 받아온다.

    MemberDAO dao = new MemberDAO();

    MemberDTO dto = dao.one(id);

    String resultText = dto.toString();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= resultText %>

</body>
</html>