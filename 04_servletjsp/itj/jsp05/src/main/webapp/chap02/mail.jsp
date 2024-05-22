<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%

        if(session.getAttribute("id") == null){
           //id라는 이름으로 저장된 세션이 없다.
           out.print("로그인되지 않았습니다. 먼저 로그인을 해주세요.<br>");
           //out.print("로그인 아이디: <input name=id>");
        }else{
           //id라는 이름으로 저장된 세션이 있다.
           out.print(session.getAttribute("id") +"님이 로그인되었습니다.");
        }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
메일페이지 - 로그인 되었을 때 댓글을 작성할 수 있습니다.
<br>
<% if(session.getAttribute("id") != null){%>
<a href="logout.jsp">로그아웃</a>
<%} %>
</body>
</html>