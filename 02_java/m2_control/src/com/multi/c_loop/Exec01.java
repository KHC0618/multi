package com.multi.c_loop;

public class Exec01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("반복문 테스트 : " + i + "회");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("★");
        }

//        while(true){
//            int i = 0;
//            System.out.println("무한 반복문" + i + "회");
//            i++;
//        }

        int start = 1;
        int end = 5;

        int add = 1;

        while (start < end) {
            System.out.println("찍어보기");
            start = start + add;
        }

        // 1 부터 10 까지 while문으로 찍어보기

        int whileTest = 0;
        end = 10;

        while (whileTest < end) {
            System.out.println(++whileTest);
        }

//        int sum = 0;
//        int num = 0;
//        while(num<10){
//            System.out.println(++num);
//            sum += num;
//        }
//        System.out.println(sum);

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.println(sum);

        // 100번 돌면서 짝수만 더한다.
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                count++;
            }
        }
        System.out.println("짝수는 총 " + count + "개");

        // continue

        for(int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.println("현재 i의 값 : " + i);
        }

        int sum1 = 0;
        count = 0;
        for(int i = 0; i < 1000; i++) {
            if(sum1 > 100) {
                break;
            }
            if(i % 5 == 0) {
                count++;
                continue;
            }
            sum1 += i;
        }
        System.out.println(count);
        System.out.println(sum1);
    }
}
