// 브루트-포스법에 의한 문자열 검색

//Brute : 무식한
//
//Force : 힘
//
//
//
//직역하면, 무식한 힘을 갖는 알고리즘이란 뜻으로, 완전 탐색 알고리즘의 한 종류이지만 완전 탐색의 또 다른 이름으로 쓰이기도 한다.
// 브루트 포스 알고리즘은 완전탐색으로 답을 도출하는 알고리즘이며, 대부분은 반복문과 조건문을 통하여 답을 도출한다.
//
//
//
//모든 경우의 수를 전부 탐색하기 때문에, 100%의 정확성을 보장하지만,
//
//모든 경우의 수를 전부 탐색하기 때문에, 높은 시간 복잡도를 갖는다.




//i am a student
//student  첫 인덱스 비교  같지않다
//
//
//i am a student
// student 두번째 인덱스 비교  같지않다
//        ...  이렇게 쭉 비교 하다가
//
//i am a student
//       student 7번째 인덱스 비교  같다
//
// 그럼 이때 부터는
//i am a student
//       |||||||
//       student 이렇게 비교한다




package com.multi.algo.c_stringsearch;
class A_BFmatch {
    //--- 브루트-포스법에 의한 문자열 검색 ---//
    static int bfMatch(String txt, String pat) {
        int pt = 0;        // txt 커서
        int pp = 0;        // pat 커서

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) { // 인덱스 위치의 문자 비교해서 일치하면 커서 값 둘다 올려주고 그다음 문자 비교
                pt++;
                pp++;
            } else {// 일치하지않으면 txt 는 그다음 커서로 가야되고 , 패턴은 첫글자부터 확인해야하니까 0
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length())        // 검색 성공
            return pt - pp; // 위치 인덱스 리턴  // 비교한 최종 pt(텍스트 인덱스) 에서 // 패턴길이 만큼 빼면 찾을 위치
        return -1;                     // 검색 실패
    }

    public static void main(String[] args) {
        String s1 = "i am a student.";// 텍스트용 문자열
        String s2 = "student";       // 패턴용 문자열

        int idx = bfMatch(s1, s2);    
        // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 문자 개수를 반각 문자로 환산하여 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패  턴: %%%ds\n", len), s2);
        }
    }
}
