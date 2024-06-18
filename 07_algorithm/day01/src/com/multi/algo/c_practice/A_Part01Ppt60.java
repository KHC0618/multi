package com.multi.algo.c_practice;

import java.util.Random;
import java.util.Scanner;

public class A_Part01Ppt60 {
    public static void main(String[] args) {
//        1.int값 5개 55, 66, 77, 22, 33 입력받아서, 최소값을 구해 프린트해보세요.
//        1)배열 사용해야함.
//        2)Scanner사용해야함.
//        1.랜덤한 값 20개를 발생시켜 , 값의 범위 0~899를 빈 배열에 넣은 후,
//                최대값을 구해 프린트해보세요. r.nextInt(900)
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[5];

        for (int i = 0; i < num.length; i++) {
            System.out.print((i + 1) + "번째 숫자 입력 : ");
            num[i] = scanner.nextInt();
            scanner.nextLine();
        }
        int min = num[0];
        for(int i = 1; i < num.length; i++) {
            if(num[i] < min) {
                min = num[i];
            }
        }
        System.out.println("최소값 : " + min);

        Random random = new Random();
        int[] ranInt = new int[20];

        for(int i = 0; i < ranInt.length; i++) {
            ranInt[i] = random.nextInt(900);
        }
        int max = ranInt[0];
        for(int i = 1; i < ranInt.length; i++) {
            if(ranInt[i] > max) {
                max = ranInt[i];
            }
        }
        System.out.println("최대값 : " + max);
    }
}
