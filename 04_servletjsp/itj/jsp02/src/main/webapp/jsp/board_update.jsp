<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.multi.jsp.board.BoardDAO"%>

<!--
    jsp에서 해야하는 작업 3가지
    1) form안에 입력한 데이터 받아서 저장해두자. ==> java
    2) 받은 데이터를 DAO에게 주자.  ==> java
    3) 결과를 html로 만들자. ==> html
-->

<%

    String no = request.getParameter("no"); // input 안에 있는 name = "값"을 받아온다.
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    BoardDAO dao = new BoardDAO();

    int result = dao.update(no, title, content);

    String resultText = "게시글 수정 실패함";

    if(result == 1) {
        resultText = "게시글 수정 성공함";
    }

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= resultText %>

게시글 수정 요청 내용 확인
<hr color="red">
게시글 no : <%= no %> <br>
수정한 title : <%= title %> <br>
수정한 content : <%= content %> <br>

</body>
</html>