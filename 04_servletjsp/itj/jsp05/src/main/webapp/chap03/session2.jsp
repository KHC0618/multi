<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
        int tennis = (int) session.getAttribute("tennis");
        int swim = (int) session.getAttribute("swim");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    tennis와 swim을 둘 다 수강하는 경우 <%= tennis + swim %>원이 수강료임.
</body>
</html>