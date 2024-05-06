package com.multi.a_variable;   // 패키지명 - 소문자

public class Exec02 {           // 클래스명 - 첫 글자는 대문자
    public static void main(String[] args) {    // 메소드 - 소문자
        // args - 지연변수, 변수는 소문자 그리고 낙타표기법 (연결되는 단어가 있으면 첫 글자를 대문자로)

        // 자바는 변수를 만들 때, 어떤 타입의 데이터를 넣을지 미리 결정
        //선언 : 타입 변수명 ==> 변수가 생성됨!
        //기본 데이터 4가지: 정수, 실수, 문자, 논리
        //기호 => 연산자
        int age = 100;
        double height = 122.2;
        char gender = '남';
        boolean food = true;

        System.out.println("내 나이는 " + age);

        int a;  //일단 저장 공간을 먼저 확보해두고, 나중에 값을 넣는 경우
        a = 100;

        int a1 = 100;   //저장 공간을 만드는 처음부터 들어갈 값이 정해진 경우 // 선언과 동시에 초기화

        /*----------------------------------------------------------------*/
        //자료형에 대한 개념

		/*
		//1. 논리형
		boolean isTrue;  // true, false, 0, 1  // 1byte

		//2. 숫자형
		//2_1 정수형

		byte bNum;		// 1byte -128~127
		short sNum;     // 2byte  -3만 ~3만
		int iNum;		// 4byte -> 정수형 중에 가장 대표적인 자료형 (기본형 ) -21억 ~ 21억xxx 까지의 값이 담기는 자료형
		long lNum;		// 8byte 21억 이상

		//2_2 실수형
		float fNum;		// 4byte
		double dNum;	// 8byte -> 실수형 중에 가장 대표적인 자료형(기본형 )

		//float은 소수점 아래 7짜리까지 표현이 가능하고
		//double은 소수점 아래 15자리까지 표현이 가능해서 double이 좀 더 정확하다  그래서 실수형 중에서 기본형이 double이다.


		//3. 문자형
		char ch;		//2byte
        */
        byte age1 = 100;
        short wallet = 2000;
        int money = 5000000;
        long space = 100000000000000L;
        // 뒤에 L을 붙이지 않고 그냥 쓰는 경우 int로 인식, 21억보다 큰 수를 쓰면 int의 범위를 벗어나므로 Long으로 명시해줘야 함
        System.out.println("내 은행에 든 돈 : " + money + "원");

        double height2 = 185.23;
        float weight2 = 185.23f;
        System.out.println("내 키는 : " + height2);

        char gender2 = '남';
        System.out.println("내 성별은 " + gender2);

        String name = "제니";
        // 참조자료형 //기본 데이터 X ==> 너무 많이 쓰기 때문에 기본형처럼 기본형데이터처럼 사용 가능!!
        System.out.println("내 이름은 " + name);

        // 사용하지 않을 변수는 애초에 선언하지 않는게 좋다.
        // int age3;
        // System.out.println(age3);

        // String day;
        // System.out.println(day);

        /*
         * int형 리터럴로 초기화가 가능한 자료형
         * byte, short, char, int
         * -> 1) 초기화 시 입력 값을 int형 리터럴로 인식하지 않고 그냥 정수로 인식
         *    2) 컴파일러가 저장하려는 자료형의 값의 범위와 일치하는지 검사하여
         *       일치하면 입력값을 저장하려는 자료형으로 변환하여 저장
         *    3) 값의 범위가 일치하지 않으면 에러 발생
         *
         * -> 초기화 된 이후 위 자료형들의 연산 시 무조건 int형으로 처리
         */

        // 자동 형변환 : 작은 크기의 자료형이 자동으로 큰 크기의 자료형으로 바뀌는 것 (형변환 생략 가능)
        // 다른 자료형들끼리의 연산 시 작은자료형 -> 큰 자료형으로 자동 형변환 후 연산처리됨.


        // ctrl + z : 뒤로 롤백
        // ctrl + shift + z : 복원
        // ctrl + alt + l : 포맷 정렬
    }
}
