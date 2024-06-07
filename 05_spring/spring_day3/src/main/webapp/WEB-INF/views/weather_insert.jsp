<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather Insert</title>
</head>
<body>
    <h1>Insert Weather Data</h1>
    <form action="${pageContext.request.contextPath}/weather/insert" method="post">
        <button type="submit">Insert Weather Data</button>
    </form>
</body>
</html>