<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
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
        p {
            color: #666;
        }
    </style>
</head>
<body>
    <jsp:include page="common/menubar.jsp"/>

    <div class="container">
        <h1>과제용 웹사이트에 오신 것을 환영합니다</h1>
        <p>이곳은 웹사이트의 메인 페이지입니다.</p>
        <p>현재 날짜와 시간: <%= new java.util.Date() %></p>
    </div>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
