<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: yellow;
}
</style>
</head>
<body>

   <jsp:include page="../common/menubar.jsp"/>
    
    <div class="content">
        <br><br>
        <div class="innerOuter">

	<hr>
	<a href="bbs">
		<button id="b1">첫페이지로</button>
	</a>
		<a href="bbs_list">게시물 전체 목록페이지</a>
		<br>
		게시물검색 처리 요청이 완료되었습니다.
		<br>
		${bag.no}, ${bag.title}, 
		${bag.content}, ${bag.writer}

	        </div>
        <br><br>
    </div>
    
    
    <!-- 이쪽에 푸터바 포함할꺼임 -->
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>