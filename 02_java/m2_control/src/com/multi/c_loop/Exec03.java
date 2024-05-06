package com.multi.c_loop;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Exec03 {
    public static void main(String[] args) {
        /* java.util.Random 클래스 */
        /* java.util.Random 클래스의 nextInt() 메소드를 이용한 난수 발생
         * nextInt(int bound) : 0부터 매개변수로 전달받은 정수 범위까지의 난수를 발생시켜서 정수 형태로 반환 */

        /* 원하는 범위의 난수를 구하는 공식
         * random.nextInt(구하려는 난수의 갯수) + 구하려는 난수의 최소값
         * */

        Random random = new Random();
        int rNum1 = random.nextInt(10); // 0 부터 bound - 1 까지.
        System.out.println(rNum1);
        int rNum2 = random.nextInt(10) + 1; // 0 부터 bound - 1 까지.
        System.out.println(rNum2);

        // 20부터 45까지의 난수
        int rNum3 = random.nextInt(26) + 20;
        System.out.println(rNum3);
        // -128부터 127까지의 난수
        int rNum4 = random.nextInt(256) - 128;
        System.out.println(rNum4);

        /* 난수의 활용 */
        /* Math.random()을 이용해 발생한 난수는 0부터 1전까지의 실수 범위의 난수값을 반환한다.
         * 필요에 따라 정수 형태의 값을 원하는 범위 만큼 발생시켜야 하는 경우들이 존재하는데
         * 필요한 범위까지의 난수를 발생시켜보자.
         * */

        /* 원하는 범위의 난수를 구하는 공식
         * (int) (Math.random * 구하려는 난수의 갯수) + 구하려는 난수의 최소값 */

        int rMNum1 = (int) (Math.random() * 10);
        System.out.println(rMNum1);

        // 1 ~ 10
        int rMNum2 = (int) (Math.random() * 10) + 1;
        System.out.println(rMNum2);

        int rMNum3 = (int) (Math.random() * 6) + 10;
        System.out.println(rMNum3);

        int rMNum4 = (int) (Math.random() * 256) - 128;
        System.out.println(rMNum4);

//        int[] arrayInt = new int[1000];
//        for (int i = 0; i < 256; i++) {
//            int rMNum5 = (int) (Math.random() * 256) - 128;
//            for (int target : arrayInt) {
//                if (target == rMNum5) {
//                    arrayInt[i] = rMNum5;
//                }
//            }
//        }
//        Arrays.sort(arrayInt);
//        System.out.println("설정된 랜덤 함수의 범위 : " + arrayInt[0] + " ~ " + arrayInt[255]);
        int[] arrayInt = new int[10];
        int arrayCount = 0; // 배열에 삽입된 값의 개수를 추적하기 위한 변수

        while (arrayCount < arrayInt.length) {
            int rMNum5 = (int) (Math.random() * 10) + 1;
            boolean duplicate = false; // 중복 여부를 나타내는 변수

            // 배열을 순회하면서 중복을 확인
            for (int i = 0; i < arrayCount; i++) {
                if (arrayInt[i] == rMNum5) {
                    duplicate = true;
                    break; // 중복이 발견되면 반복문 종료
                }
            }

            // 중복이 아닌 경우에만 배열에 삽입
            if (!duplicate) {
                arrayInt[arrayCount] = rMNum5;
                arrayCount++; // 배열에 삽입된 값의 개수 증가

            }
        }
        Arrays.sort(arrayInt); // 배열 오름차순 정렬
        for (int i = 0; i < arrayInt.length; i++) { // 배열의 구성 요소 전체 출력
            System.out.print(arrayInt[i]);
            if (i < arrayInt.length - 1) {  // 배열의 마지막에는 쉼표 출력 안함.
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("설정된 랜덤 함수의 범위 : " + arrayInt[0] + " ~ " + arrayInt[arrayInt.length - 1]);

        // target 1 ~ 100
        int target = (int) (Math.random() * 100) + 1;
        int no = 0;
        int count = 0;

        while (true) {
            String data = JOptionPane.showInputDialog("숫자를 입력하세요.");
            int data2 = Integer.parseInt(data);

            count++;
            if(data2 == target) {
                System.out.println("축하합니다. 정답입니다!");
                break;
            } else {
                System.out.println("정답이 아닙니다.");
                no++;
                if (data2 > target) {
                    System.out.println("너무 큽니다.");
                } else {
                    System.out.println("너무 작습니다.");
                }
            }
        }

        System.out.println("총 시도 횟수 : " + count + "회");
        System.out.println("틀린 횟수 : " + no + "회");
    }
}
