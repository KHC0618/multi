<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Callback</title>
</head>
<body>
<script>
    window.opener.location.href = "/naverLogin"; // Servlet으로 리다이렉트
    window.close();
</script>
</body>
</html>