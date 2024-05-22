<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"></script>
</head>
<body>

<!-- 네이버 로그인 버튼 -->
<div id="naverIdLogin"></div>

<script>
// 네이버 초기화
var naverLogin = new naver.LoginWithNaverId({
    clientId: "08XZSxSFNzPxBo6X4VFS",
    callbackUrl: "http://localhost:8090/naverLogin",
    isPopup: false,
    loginButton: {color: "green", type: 3, height: 45}
});
naverLogin.init();

// 네이버 로그인 콜백 처리
window.addEventListener('load', function () {
    naverLogin.getLoginStatus(function (status) {
        if (status) {
            var token = naverLogin.accessToken.accessToken;

            // 사용자 정보 가져오기
            $.ajax({
                url: "https://openapi.naver.com/v1/nid/me",
                type: "GET",
                headers: {
                    "Authorization": "Bearer " + token
                },
                success: function(response) {
                    var naverid = response.response.id + "N";
                    var name = response.response.name;
                    var email = response.response.email;

                    $.ajax({
                        type: "post",
                        url: '/member/idDuplicateCheck.go', // ID 중복 체크를 통해 회원가입 여부를 결정한다.
                        data: { "userid": naverid },
                        dataType: "json",
                        success: function (json) {
                            if (json.idExists) {
                                // 존재하는 경우 로그인 처리
                                createHiddenLoginForm(naverid);
                            } else {
                                // 회원가입
                                $.ajax({
                                    type: "post",
                                    url: '/member/naverSignUp.go',
                                    data: {
                                        "userid": naverid,
                                        "name": name,
                                        "email": email
                                    },
                                    dataType: "json",
                                    success: function (json) {
                                        if (json.success) {
                                            // 로그인
                                            createHiddenLoginForm(naverid);
                                        } else {
                                            alert('네이버 회원가입 실패. 일반계정으로 로그인하시기 바랍니다.');
                                        }
                                    },
                                    error: function (request, status, error) {
                                        alert("code: " + request.status + "\n" +
                                              "message: " + request.responseText + "\n" +
                                              "error: " + error);
                                    }
                                });
                            }
                        },
                        error: function (request, status, error) {
                            alert("code: " + request.status + "\n" +
                                  "message: " + request.responseText + "\n" +
                                  "error: " + error);
                        }
                    });
                },
                error: function (request, status, error) {
                    alert("code: " + request.status + "\n" +
                          "message: " + request.responseText + "\n" +
                          "error: " + error);
                }
            });
        }
    });
});

function createHiddenLoginForm(naverId) {
    var frm = document.createElement('form');
    frm.setAttribute('method', 'post');
    frm.setAttribute('action', '/member/naverLogin.go');
    var hiddenInput = document.createElement('input');
    hiddenInput.setAttribute('type', 'hidden');
    hiddenInput.setAttribute('name', 'userid');
    hiddenInput.setAttribute('value', naverId);
    frm.appendChild(hiddenInput);
    document.body.appendChild(frm);
    frm.submit();

    // 네이버 메인 페이지로 리다이렉트
    window.location.href = "http://localhost:8090/jsp04/openWeather.jsp";
}
</script>
</body>
</html>