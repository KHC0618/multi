<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.multi.jsp.board.BoardDTO"%>
<%@page import="com.multi.jsp.board.BoardDAO"%>

<!--
    jsp에서 해야하는 작업 3가지
    1) form안에 입력한 데이터 받아서 저장해두자. ==> java
    2) 받은 데이터를 DAO에게 주자.  ==> java
    3) 결과를 html로 만들자. ==> html
-->

<%

    String category = request.getParameter("category"); // input 안에 있는 name = "값"을 받아온다.
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String writer = request.getParameter("writer");

    BoardDAO dao = new BoardDAO();
    BoardDTO dto = new BoardDTO();

    dto.setCategory(category);
    dto.setTitle(title);
    dto.setContent(content);
    dto.setWriter(writer);

    int result = dao.insert(dto);

    String resultText = "게시글 쓰기 실패함";

    if(result == 1) {
        resultText = "게시글 쓰기 성공함";
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

<h5>당신이 입력한 게시글 정보를 확인해주세요.</h5>
<hr color="green">
카테고리 코드는 <%= category %> <br>
제목은 <%= title %> <br>
내용은 <%= content %> <br>
작성자는 <%= writer %> <br>

</body>
</html>