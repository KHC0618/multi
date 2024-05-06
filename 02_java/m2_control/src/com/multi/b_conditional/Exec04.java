package com.multi.b_conditional;

public class Exec04 {
    /* [switch문 표현식]    // 대소비교는 할 수 없음.
     * switch(비교할변수) {  // 비교할 변수는 정수, 문자, 문자열이 들어간다. 실수형, 논리형은 들어갈 수 없다.
     *     case 비교값1 : 비교값1과 일치하는 경우 실행할 구문; break;
     *     case 비교값2 : 비교값2와 일치하는 경우 실행할 구문; break;
     *     default : case에 모두 해당하지 않는 경우 실행할 구문; break;
     * }
     * */
    public static void main(String[] args) {
        String name = "Java";
        switch (name) {
            case "Java":
                System.out.println("Java");
                break;
            case "Python":
                System.out.println("Python");
                break;
            case "Linux":
                System.out.println("Linux");
                break;
            default:
                System.out.println("카운터로 가세요.");
                break;
        }
    }
}
