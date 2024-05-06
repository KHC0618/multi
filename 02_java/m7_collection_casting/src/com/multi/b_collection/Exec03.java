package com.multi.b_collection;

import java.util.ArrayList;

public class Exec03 {
    public static void main(String[] args) {
        /* 제네릭(generic) */
        /* 제네릭의 사전적인 의미는 일반적인 이라는 의미이다.
         * 자바에서 제네릭이란 데이터의 타입을 일반화한다는 의미를 가진다.
         *
         * 제네릭은 클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 지정하는 방법을 말한다.
         * 컴파일 시에 미리 타입 검사를 시행하게 되면 클래스나 메소드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있으며,
         * (잘못된 타입인 경우 컴파일 에러를 발생시킴)
         * 반환값에 대한 타입 변환 및 타입 검사에 들어가는 코드 생략이 가능해진다.
         * (instanceof 비교 및 다운캐스팅 작성 불필요)
         *
         * JDK 1.5 버전부터 추가된 문법이다.
         *
         * 제네릭 프로그래밍
         * 데이터의 형식에 의존하지 않고 하나의 값이 여러 다른 데이터 타입들을 가질 수 있는 기술에 중점을 두어
         * 재사용성을 높일 수 있는 프로그래밍 방식이다.
         * */

        // ArrayList에 String 타입 지정해서 4개 담기.
        ArrayList<String> arrStr = new ArrayList<>();
        arrStr.add("asdf1");
        arrStr.add("asdf2");
        arrStr.add("asdf3");
        arrStr.add("asdf4");
        System.out.println(arrStr);

        // ArrayList에 int 타입 지정해서 4개 담기.
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(100);
        arrInt.add(200);
        arrInt.add(300);
        arrInt.add(400);
        System.out.println(arrInt);
    }
}
