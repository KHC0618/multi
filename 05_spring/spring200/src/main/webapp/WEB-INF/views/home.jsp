<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
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
</html> --%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e6f2f2;
            margin: 0;
            padding: 0;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: black;
            padding: 10px;
            color: white;
        }
        .header .logo {
            display: flex;
            align-items: center;
        }
        .header .logo img {
            height: 40px;
            margin-right: 10px;
        }
        .header .admin-btn {
            background-color: white;
            color: black;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
        }
        .nav {
            display: flex;
            justify-content: space-around;
            background-color: #dce7e7;
            padding: 10px 0;
        }
        .nav a {
            color: black;
            text-decoration: none;
            font-weight: bold;
            padding: 10px;
        }
        .nav .user-info {
            display: flex;
            align-items: center;
        }
        .nav .user-info img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            padding: 20px;
        }
        .section {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 10px;
            padding: 20px;
            width: calc(50% - 40px);
        }
        .section h3 {
            background-color: #dce7e7;
            padding: 10px;
            margin: -20px -20px 20px -20px;
            border-radius: 10px 10px 0 0;
        }
        .section .search {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .section .search input {
            width: calc(100% - 60px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .section ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .section ul li {
            display: flex;
            justify-content: space-between;
            padding: 10px;
            background-color: #f9f9f9;
            margin-bottom: 10px;
            border-radius: 5px;
        }
        .footer {
            text-align: center;
            padding: 20px;
            background-color: #dce7e7;
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="logo">
            <img src="path_to_logo_image" alt="SOUL Logo">
            <div>SOUL</div>
        </div>
        <button class="admin-btn">Admin</button>
    </div>
    <div class="nav">
        <a href="#">소울로그</a>
        <a href="#">추천</a>
        <a href="#">이벤트</a>
        <a href="#">고객센터</a>
        <div class="user-info">
            <img src="path_to_user_image" alt="User">
            관리자님 | <a href="#">로그아웃</a>
        </div>
    </div>
    <div class="container">
        <div class="section">
            <h3>전체 회원 리스트</h3>
            <div class="search">
                <input type="text" placeholder="검색">
                <button>검색</button>
            </div>
            <ul>
                <li>홍길동 | 소울레벨 | 마지막 소울로그 작성일 | 강등 | 블랙 | 탈퇴</li>
                <li>홍길동 | 소울레벨 | 마지막 소울로그 작성일 | 강등 | 블랙 | 탈퇴</li>
                <li>홍길동 | 소울레벨 | 마지막 소울로그 작성일 | 강등 | 블랙 | 탈퇴</li>
                <li>홍길동 | 소울레벨 | 마지막 소울로그 작성일 | 강등 | 블랙 | 탈퇴</li>
            </ul>
            <div>1 | 2 | 3 | 4 | 5</div>
        </div>
        <div class="section">
            <h3>신고 현황</h3>
            <ul>
                <li>신고 번호 | 게시글 번호 | 신고 내용</li>
                <li>신고 번호 | 게시글 번호 | 신고 내용</li>
                <li>신고 번호 | 게시글 번호 | 신고 내용</li>
                <li>신고 번호 | 게시글 번호 | 신고 내용</li>
            </ul>
            <div>1 | 2 | 3 | 4 | 5</div>
        </div>
        <div class="section">
            <h3>업적 관리</h3>
            <ul>
                <li>업적 조건 | 필요 횟수 | 타이틀 | 수정 | 삭제</li>
                <li>업적 조건 | 필요 횟수 | 타이틀 | 수정 | 삭제</li>
                <li>업적 조건 | 필요 횟수 | 타이틀 | 수정 | 삭제</li>
                <li>업적 조건 | 필요 횟수 | 타이틀 | 수정 | 삭제</li>
            </ul>
            <button>업적 생성</button>
        </div>
        <div class="section">
            <h3>블랙리스트</h3>
            <ul>
                <li>홍길동 | 블랙리스트에 등록된 날짜 | 해제</li>
                <li>홍길동 | 블랙리스트에 등록된 날짜 | 해제</li>
                <li>홍길동 | 블랙리스트에 등록된 날짜 | 해제</li>
            </ul>
            <div>1 | 2 | 3 | 4 | 5</div>
        </div>
    </div>
    <div class="footer">
        <a href="#">문의 페이지로 이동</a>
    </div>
</body>
</html>

