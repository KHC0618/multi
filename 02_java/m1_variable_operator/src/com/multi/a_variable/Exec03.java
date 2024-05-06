package com.multi.a_variable;   // 패키지명 - 소문자

import javax.swing.*;

public class Exec03 {           // 클래스명 - 첫 글자는 대문자
    public static void main(String[] args) {    // 메소드 - 소문자
        // args - 지연변수, 변수는 소문자 그리고 낙타표기법 (연결되는 단어가 있으면 첫 글자를 대문자로)

        String name = JOptionPane.showInputDialog("이름입력");
        System.out.println("당신의 이름은 " + name + "이시군요!!");
        JOptionPane.showMessageDialog(null, "당신의 이름은 " + name + "이시군요!!");

        // ctrl + z : 뒤로 롤백
        // ctrl + shift + z : 복원
        // ctrl + alt + l : 포맷 정렬
    }
}
