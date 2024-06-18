package com.multi.algo.c_practice;

public class B_Part01Ppt60 {
    public static void main(String[] args) {
        String s1 = "참좋다";
        String s2 = "진짜좋다";
        System.out.println(s1.equals(s2));

        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length > s2Length) {
            System.out.println("더 글자 수가 많은 문자열은 : " + s1);
        } else if (s1Length < s2Length) {
            System.out.println("더 글자 수가 많은 문자열은 : " + s2);
        } else {
            System.out.println("두 문자열의 글자 수는 같다.");
        }

        String s3 = "나는 진짜 java programmer가 되었어";
        String s3Sub = s3.substring(6, 21);
        System.out.println(s3Sub.toUpperCase());

        String s4 = "2056521";
        char s4Char = s4.charAt(0);
        if (s4Char == '1') {
            System.out.println("남자임.");
        } else if (s4Char == '2') {
            System.out.println("여자임.");
        } else {
            System.out.println("잘못 된 주민번호입니다.");
        }
    }
}
