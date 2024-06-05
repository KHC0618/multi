<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//alert('게시판글쓰기 페이지입니다. 반갑습니다.!')
</script>
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin: 5px 0 10px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="file"] {
            margin: 5px 0 10px 0;
        }
        button {
            width: 100px;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    
    <div class="container">
        <h1>글쓰기</h1>
        <form action="${pageContext.servletContext.contextPath}/bbs/write" method="post" enctype="multipart/form-data">
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" required>
            
            <label for="content">내용:</label>
            <textarea id="content" name="content" rows="10" required></textarea>
            
            <label for="file">사진 첨부:</label>
            <input type="file" id="file" name="singleFile">
            
            <input type="hidden" name="writer" value="${sessionScope.member.username}">
            
            <button type="submit">작성</button>
        </form>
    </div>
</body>
</html>