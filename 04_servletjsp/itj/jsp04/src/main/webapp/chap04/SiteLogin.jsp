<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"></script>

<a class="btn btnkakao" id="kakao-login-btn" style="text-align:center;" href="javascript:kakaoLogin()">카카오 1초 로그인/회원가입</a><br>
<a class="btn btnnaver" id="naver-login-btn" style="text-align:center;" href="javascript:naverLogin()">네이버 1초 로그인/회원가입</a>

<script>
// 카카오 초기화
Kakao.init('70797760257800161976c750323d9935');

function kakaoLogin() {
	
    Kakao.Auth.login({
        success: function(response) {
            Kakao.API.request({ // 사용자 정보 가져오기 
                url: '/v2/user/me',
                success: (response) => {
                	var kakaoid = response.id+"K";
                    $.ajax({
    					type : "post",
    					url : '/member/idDuplicateCheck.go', // ID중복체크를 통해 회원가입 유무를 결정한다.
    					data : {"userid":kakaoid},
    					dataType:"json",
    					success : function(json){   				
    						if(json.idExists){
    							// 존재하는 경우 로그인 처리
    							createHiddenLoginForm(kakaoid);
    							
    						} else{
    							// 회원가입
    							$.ajax({
    								type : "post",
    		    					url : '/member/kakaoSignUp.go',
    		    					data : {"userid":kakaoid,
    		    						    "name":response.properties.nickname,
    		    						    "email":response.kakao_account.email},
    		    					dataType :"json",
    		    					success : function(json){
    		    						if(json.success){
    		    							// 로그인
    		    							createHiddenLoginForm(kakaoid);		    							
    		    						} else {
    		    							alert('카카오 회원가입 실패. 일반계정으로 로그인하시기 바랍니다.');
    		    						}
    		    					},
    		    					error: function(request, status, error){
    		    		                   alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
    		    		                }
    							});
    						}						
    					},
    					error: function(request, status, error){
    		                   alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
    		                }
    				});
                }
            });
            // window.location.href='/ex/kakao_login.html' //리다이렉트 되는 코드
        },
        fail: function(error) {
            alert(error);
        }
    });
}

function createHiddenLoginForm(kakaoId){
	
	var frm = document.createElement('form');
	frm.setAttribute('method', 'post');
	frm.setAttribute('action', '/member/kakaoLogin.go');
	var hiddenInput = document.createElement('input');
	hiddenInput.setAttribute('type','hidden');
	hiddenInput.setAttribute('name','userid');
	hiddenInput.setAttribute('value',kakaoId);
	frm.appendChild(hiddenInput);
	document.body.appendChild(frm);
	frm.submit();
	
}








// 네이버 초기화 (절반은 GPT입니다)
var naverLogin = new naver.LoginWithNaverId({
    clientId: "rkpq5mXRA1mVhNhnre8T",
    callbackUrl: "http://localhost:8090/naverLogin",
    isPopup: true
});

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('naver-login-btn').addEventListener('click', function() {
        naverLogin.init();
        naverLogin.authorize();
    });
});

window.addEventListener('load', function() {
    naverLogin.getLoginStatus(function(status) {
        if (status) {
            var email = naverLogin.user.getEmail();
            var nickname = naverLogin.user.getNickName();
            var id = naverLogin.user.getId();
            var naverId = id + "N";
            $.ajax({
                type: "post",
                url: '/member/idDuplicateCheck.go',
                data: {"userid": naverId},
                dataType: "json",
                success: function(json) {
                    if (json.idExists) {
                        createHiddenLoginForm(naverId);
                    } else {
                        $.ajax({
                            type: "post",
                            url: '/member/naverSignUp.go',
                            data: {
                                "userid": naverId,
                                "name": nickname,
                                "email": email
                            },
                            dataType: "json",
                            success: function(json) {
                                if (json.success) {
                                    createHiddenLoginForm(naverId);
                                } else {
                                    alert('네이버 회원가입 실패. 일반계정으로 로그인하시기 바랍니다.');
                                }
                            },
                            error: function(request, status, error) {
                                alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
                            }
                        });
                    }
                },
                error: function(request, status, error) {
                    alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
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
}
</script>


</head>
<body>

</body>
</html>