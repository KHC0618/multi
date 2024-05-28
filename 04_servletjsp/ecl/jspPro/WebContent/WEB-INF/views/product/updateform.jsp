<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정하기</title>
</head>
<body>
    <jsp:include page="../common/menubar.jsp"/>
    
    <div class="container my-4">
        <form action="${pageContext.servletContext.contextPath}/product/update" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${product.id}">
            <div class="form-group">
                <label for="name">상품 제목</label>
                <input type="text" class="form-control" id="name" name="name" value="${product.name}">
            </div>
            <div class="form-group">
                <label for="content">상품 설명</label>
                <textarea class="form-control" id="content" name="content">${product.content}</textarea>
            </div>
            <div class="form-group">
                <label for="price">상품 가격</label>
                <input type="number" class="form-control" id="price" name="price" value="${product.price}">
            </div>
            <div class="form-group">
                <label for="image">상품 이미지</label>
                <input type="file" class="form-control-file" id="image" name="image">
            </div>
            <button type="submit" class="btn btn-primary">수정하기</button>
        </form>
    </div>
</body>
</html>