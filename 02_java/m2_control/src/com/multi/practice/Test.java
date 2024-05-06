package com.multi.practice;

import java.util.Arrays;

public class Test {
    public Test(int num1, int num2) {
        int[] arrayInt = new int[num1];
        int arrayCount = 0; // 배열에 삽입된 값의 개수를 추적하기 위한 변수

        while (arrayCount < arrayInt.length) {
            int rMNum = (int) (Math.random() * num1) + num2;
            boolean duplicate = false; // 중복 여부를 나타내는 변수

            // 배열을 순회하면서 중복을 확인
            for (int i = 0; i < arrayCount; i++) {
                if (arrayInt[i] == rMNum) {
                    duplicate = true;
                    break; // 중복이 발견되면 반복문 종료
                }
            }

            // 중복이 아닌 경우에만 배열에 삽입
            if (!duplicate) {
                arrayInt[arrayCount] = rMNum;
                arrayCount++; // 배열에 삽입된 값의 개수 증가

            }
        }
        Arrays.sort(arrayInt); // 배열 오름차순 정렬
        for (int i = 0; i < arrayInt.length; i++) { // 배열의 구성 요소 전체 출력
            System.out.print(arrayInt[i]);
            if (i < arrayInt.length - 1) {  // 배열의 마지막에는 쉼표 출력 안함.
                System.out.print(", ");
            }
            if (i % 10 == 0 && i > 0) { // 10개마다 줄바꿈
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("설정된 랜덤 함수의 범위 : " + arrayInt[0] + " ~ " + arrayInt[arrayInt.length - 1]);
    }
}
