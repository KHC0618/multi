<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="java.util.Date" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	   <jsp:include page="../common/menubar.jsp" />
	<div class="container mt-4">
    <!-- 검색 폼 -->
	    <form method="get" action="${pageContext.servletContext.contextPath}/product/list">
	        <div class="form-group row">
	            <label for="search" class="col-sm-2 col-form-label">제품명 검색:</label>
	            <div class="col-sm-8">
	                <input type="text" class="form-control" id="search" name="search" value="${param.search}">
	            </div>
	            <div class="col-sm-2">
	                <button type="submit" class="btn btn-primary">검색</button>
	            </div>
	        </div>
	    </form>
	</div>
    <!-- 제품 리스트 -->
    <div class="container mt-4">
        <table class="table table-hover table-bordered">
            <thead class="thead-light" style="text-align: center;" >
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col">제품명</th>
                    <th scope="col">제품가격</th>
                    <th scope="col">회사명</th>
                    <th scope="col">등록일</th>
                 <th scope="col" id="cartContents">
				    장바구니 count: <c:out value="${not empty sessionScope.basket ? fn:length(sessionScope.basket) : '0'}"/>개
				</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${empty list}">
                    <tr>
                        <td colspan="6" class="text-center">조회된 내용이 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="p" items="${list}">
                    <tr>
                        <td class="tdc"> ${p.id} </td>
                        <td class="tdc" onclick="location.href='${pageContext.servletContext.contextPath}/product/selectone?no=${p.id}'">${p.name}</td>
                        <td class="tdc"> ${p.price} </td>
                        <td class="tdc"> ${p.company.name} </td>
                        <td class="tdc"> ${p.createDate} </td>
                        <td>
                            <button type="button" class="btn btn-primary" onclick="addToCart(${p.id})">장바구니 추가</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		<div align="center">
        <c:if test="${(!empty sessionScope.loginMember) && sessionScope.loginMember.id eq 'admin'}">
            <button class="btn btn-success" onclick="location.href='${pageContext.servletContext.contextPath}/product/insert'">등록하기</button>
        </c:if>
        </div>
    </div>

	<script>
		
	if(document.getElementsByClassName("tdc")) {
	    const $tds = document.getElementsByClassName("tdc");
	    for(let i = 0; i < $tds.length; i++) {
	        $tds[i].onmouseenter = function() {
	            this.parentNode.style.backgroundColor = "skyblue";
	            this.parentNode.style.cursor = "pointer";
	        }
	        
	        $tds[i].onmouseout = function() {
	            this.parentNode.style.backgroundColor = "white";
	        }
	        $tds[i].onclick = function() {
	            var no = this.parentNode.children[0].innerText;

	            // '/selectone' 서블릿으로 리디렉션하면서 쿼리 스트링에 게시물 번호를 포함시킴
	            location.href = '${pageContext.servletContext.contextPath}/product/selectone?no=' + no;
	        }
	    }
	}
		
	function addToCart(productId) {
	    $.ajax({
	        type: "POST",
	        url: "${pageContext.servletContext.contextPath}/cart/add",
	        data: {productId: productId},
	        success: function(response) {
	            $("#cartContents").html("장바구니 count: " + response + "개");

	            alert(productId + "번 제품이 장바구니에 추가되었습니다.")
				choice = confirm('장바구니 페이지로 이동하시겠습니까') 
				if(choice){
					location.href = '${pageContext.servletContext.contextPath}/product/basket'
				}
	        },
	        error: function(xhr) { 
	         	alert('장바구니 추가에 실패했습니다.');
	          
	        }
	    });
	}
	</script>
	
	
</body>
</html>