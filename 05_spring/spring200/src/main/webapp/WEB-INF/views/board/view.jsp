<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>게시글 보기</title>
</head>
<body>
    <h1>${board.title}</h1>
    <p>${board.content}</p>
    <p>작성자: ${board.writer}</p>
    <c:if test="${not empty board.fileName}">
        <img src="/upload/${board.fileName}" alt="첨부 이미지">
    </c:if>
    <a href="/board/list">목록으로</a>
</body>
</html>