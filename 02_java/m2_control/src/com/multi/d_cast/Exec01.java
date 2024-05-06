package com.multi.d_cast;

public class Exec01 {
    public static void main(String[] args) {
        int a = 100;
        byte b = 50;
        a = b;  // int <-- byte
        // 큰 공간 <-- 작은 공간 데이터 (자동 형변환)

        int c = 1000;
        b = (byte) c;
        // 작은 공간 < -- 큰 공간 데이터 (강제 형변환, 명시적 형변환)
        // (작은 타입 이름) 변수; 의 형태

        byte x = 100;
		int y = x; // 자동형변환

//		int x1 = 300;
//		byte y1 = x1; //형변환불가

		double x2 = 400; //8바이트
		int y2 = (int)x2; //강제형변환

		int x3 = 400;
		double y3 = x3; //자동형변환
    }
}
