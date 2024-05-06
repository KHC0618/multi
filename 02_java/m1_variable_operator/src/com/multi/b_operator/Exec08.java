package com.multi.b_operator;

public class Exec08 {
    public static void main(String[] args) {
        int coffee = 5;
        int price = 5000;

        int result = coffee * price;
        if (result > 20000) {
            System.out.println("할인해드릴게요.");
        } else {
            System.out.println("총 커피값을 내세요.");
        }

        int age = 100;
        int nextAge = ++age;

        if (nextAge > 100) {
            System.out.println("이제부터 시작.");
        } else {
            System.out.println("아직 젊어요.");
        }

        int water = 1000;
        int num1 = 2;

        int mask = 2000;
        int num2 = 3;

        int sumWater = water * num1;
        int sumMask = mask * num2;

        System.out.println("1)생수값 금액은 얼마? " + sumWater);
        System.out.println("2)마스크값 금액은 얼마? " + sumMask);
        System.out.println("3)총 지불금액은 얼마? " + (sumWater + sumMask));

        for (int i = 0; i < 1000; i++) {
            System.out.println("나는 짱");
        }

        int korean = 75;
        int math = 50;

        int sum = korean + math;

        System.out.println("국어 점수와 수학 점수의 합은 : " + sum);
        System.out.println("평균 점수는 : " + ((double) sum / 2));
    }
}
