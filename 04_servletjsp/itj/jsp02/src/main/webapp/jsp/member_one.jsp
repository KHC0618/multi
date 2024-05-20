<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.multi.jsp.member.MemberDTO"%>
<%@page import="com.multi.jsp.member.MemberDAO"%>

<!--
    1. 데이터를 받아서 저장해두자.
        HttpServletRequest request = new HttpServletRequest(); 내장객체
    2. dao를 이용해서 데이터를 주면서 db처리해달라고 요청
    3. 요청에 대한 결과를 html을 만든다.
-->

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
<body bgcolor="skyblue">

    검색해 온 id: <%= dto.getId() %> <br>
    검색해 온 pw: <%= dto.getPw()%> <br>
    검색해 온 name: <%= dto.getName() %> <br>
    검색해 온 tel: <%= dto.getTel() %>

</body>
</html>