package com.multi.a_array;

public class Exec02 {
    public static void main(String[] args) {
        int[] jumsu = new int[1000];

        jumsu[0] = 100;
        jumsu[12] = 200;
        jumsu[999] = 1000;
        System.out.println("첫 번째 값 : " + jumsu[0]);
        System.out.println("열세 번째 값 : " + jumsu[12]);
        System.out.println("마지막 값 : " + jumsu[999]);
        //int변수 1000개가 모두 이름이 jumsu
        //jumsu를 인덱스(위치값)로 구분
        //첫 번째 jumsu의 index는 0! => jumsu[0]
        //두 번째 jumsu의 index는 1! => jumsu[1]
        //마지막 jumsu의 index는 전체개수-1! => jumsu[전체개수-1]

        //foreach //향상된 for문     for (들어있는 데이터의 타입    변수  :   보고자하는 객체의 주소 (변수) )
        //foreach: 배열의 첫위치값부터 하나씩 오른쪽가면서 자동으로
        //꺼내주는 반복문, length보다 작을 때까지!

        for (int i = 0; i < jumsu.length; i++) {
            jumsu[i] = i + 1;
        }
        int j = 0;
        for (int i : jumsu) {
            System.out.println(j + "번째 index의 값 : " + i);
            j++;
        }

        //배열은 일반적으로 같은 타입을 묶을 때 사용!
        //다양한 타입을 묶을 때는 배열을 쓰지 않음.!
        //배열은 고정된 크기를 가진다.(크기 조절 불가능)
        int[] temp = new int[7];
        temp[0] = 10;
        temp[1] = 11;
        temp[2] = 12;
        temp[3] = 13;
        temp[4] = 14;
        temp[5] = 15;
        temp[6] = 16;
        for (int i = 0; i < temp.length; i++) {
//            temp[i] = 10 + i;
            System.out.println(i + 1 + "일차: " + temp[i]);
        }
        /* 기본적으로 배열을 선언하고 할당하게 되면
         * 배열의 각 인덱스에는 자바에서 지정한 기본값으로 초기화가 된 상태가 된다.
         * heap영역은 값이 없는 빈 공간이 존재할 수 없다.
         * */

        /* 값의 형태 별 기본값
         * 정수 : 0
         * 실수 : 0.0
         * 논리 : false
         * 문자 : \u0000
         * 참조 : null
         * */

        char[] c = new char[100];
        System.out.println(c);
        c[0] = 'A';
        c[1] = 'B';
        System.out.println(c[1]);
        System.out.println(c);
    }
}
