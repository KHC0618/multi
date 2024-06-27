// KMP법에 의한 문자열 검색


//KMP 알고리즘이란, 문자열 탐색 알고리즘으로써 알고리즘을 만든 사람들(Knuth-Morris-Pratt)의 앞글자를 딴 것이다.

//
//해당 알고리즘의 시간복잡도는 O(N+M)을 가진다.
//
//KMP 알고리즘은 접두사(prefix)와 접미사(suffix)의 개념을 활용하여 실패함수 테이블을 만들고, 테이블을 활용하여 반복되는 문자열을 건너뛰면서 패턴을 찾는 알고리즘이다.
//
////
//
//우리는 각 문자의 길이에 따라 접두사와 접미사가 일치하는 최대 길이를 테이블에 저장

//i am a student  에서 student 를 찾을때  브루트-포스법 를 사용하면 o (n*m) 으로 모든 경우를 보니까 비효율적
//student


//패턴: s t u d e n t
//Pi 테이블 초기화: [0, 0, 0, 0, 0, 0, 0] //접두사와 접미사가 일치하는 최대 길이를 저장  (인덱스 s 와 비교 해서 모두0)

//kmp 방식으로
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

//i am a student stutent 라고 뒤에 더있다고 가정
//              student     14번째 인덱스와 같은지 비교  같지않다

//i am a student stutent
//               student     15번째 인덱스와 같은지 비교  같다


//i am a student stutent
//               |||/         3개는 같고 t  가 다르다
//               student     문자패턴비교

//i am a student stutent
//                  student  문자패턴비교



//이떄  젤마지막 부분에서 패턴이 있는경우의 문자열로 비교해보면

//babcabcd
//abcabb   두개를 비교해보자   인단 pi 테이블을 만듬 (000120)

//babcabcd
//abcabb

//babcabcd
// abcabb

//babcabcd
// |||||x
// abcabb (000120)- 문자열인덱스 인덱스0 a 와 비교 a 가 한번 더나오면 1 그리고 다시 패턴 확인

//이때 일치하지않은 b 의 앞 문자열 패턴 정보를 읽어 그 인덱스가 2이므로 두칸 앞 글자(c)와 비교
//babcabcd
//      |
//    abcabb     c  와 c 일치  , 앞에꺼는 비교 안함

//babcabcd
//       /
//    abcabb     그다음 d  와 a 불일치  a 의 바로 앞 c 인덱스킄 0  그래서 다음은 다시 처음 부터 비교

//babcabcd

   //    abcabb     불일치

package com.multi.algo.c_stringsearch;

class B_KMPmatch {
    //문자열 패턴테이블
    static int kmpMatch(String txt, String pat) {
        int pt = 1;                                // txt를 따라가는 커서
        int pp = 0;                                // pat를 따라가는 커서
        int[] skip = new int[pat.length()  ];    // 건너뛰기 표(skip 테이블)
        // skip 테이블 작성
        skip[0] = 0; // 첫 번째 문자의 부분 일치 길이는 항상 0
        while (pt != pat.length()) {//패턴의 길이와같을때까지 검색

            if (pat.charAt(pt) == pat.charAt(pp))  // 현재 문자들이 일치하면
                skip[pt++] = ++pp;
            else if (pp == 0)    // 일치하지 않고 pp가 0이면
                skip[pt++] = pp;
            else   // 일치하지 않고 pp가 0이 아니면
                pp = skip[pp - 1];
        }


        // 검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp - 1];   // 일치하지 않으면 skip 테이블을 참조하여 건너뜀
        }
        if (pp == pat.length())        // 패턴의 모든 문자를 대조
            return pt - pp;
        return -1;                     // 검색 실패

//
//        int pt = 1;                                // txt를 따라가는 커서
//        int pp = 0;                                // pat를 따라가는 커서
//        int[] skip = new int[pat.length() +1 ];    // 건너뛰기 표(skip 테이블)
//        // skip 테이블 작성
//        skip[pt] = 0; // 첫 번째 문자의 부분 일치 길이는 항상 0
//        while (pt != pat.length()) {//패턴의 길이와같을때까지 검색
//
//            if (pat.charAt(pt) == pat.charAt(pp))
//                skip[++pt] = ++pp;
//            else if (pp == 0)
//                skip[++pt] = pp;
//            else
//                pp = skip[pp];
//        }
//
//
//        // 검색
//        pt = pp = 0;
//        while (pt != txt.length() && pp != pat.length()) {
//            if (txt.charAt(pt) == pat.charAt(pp)) {
//                pt++;
//                pp++;
//            } else if (pp == 0)
//                pt++;
//            else
//                pp = skip[pp];   // 일치하지 않으면 skip 테이블을 참조하여 건너뜀
//        }
//        if (pp == pat.length())        // 패턴의 모든 문자를 대조
//            return pt - pp;
//        return -1;
    }


    public static void main(String[] args) {
        //babcabcd
//abcabb
//    	String s1 = "i am a student.";// 텍스트용 문자열
//		String s2 = "student"; // 패턴용 문자열 // 패턴용 문자열
        String s1 ="babcabcd";
        String s2= "abcabb";
        int idx = kmpMatch(s1, s2);
        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
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


