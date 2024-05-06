package com.multi.a_variable;   // 패키지명 - 소문자

public class Exec01 {           // 클래스명 - 첫 글자는 대문자
    public static void main(String[] args) {    // 메소드 - 소문자
        // args - 지연변수, 변수는 소문자 그리고 낙타표기법 (연결되는 단어가 있으면 첫 글자를 대문자로)
        int myAge = 100;
        String myTel = "011";
        String ssn = "880101";

        myAge = Integer.parseInt("20");

        System.out.println(myAge);

        // 상수 변수 - 무조건 대문자로 작성, 앞에 final을 붙여준다.
        final String COMPANY = "멀티";
        // COMPANY = "H";   상수는 재할당(수정) 불가.
        // ctrl + z : 뒤로 롤백
        // ctrl + shift + z : 복원
        // ctrl + alt + l : 포맷 정렬
    }
}
