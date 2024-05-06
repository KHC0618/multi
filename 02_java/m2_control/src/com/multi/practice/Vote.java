package com.multi.practice;

import java.util.Scanner;

public class Vote {
    public static void main(String[] args) {
        int iu = 0;
        int you = 0;
        int bts = 0;

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("입력 1)아이유 2)유재석 3)방탄 4)종료 >> ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    System.out.println("아이유 득표 수 : " + iu + "표");
                    System.out.println("유재석 득표 수 : " + you + "표");
                    System.out.println("방탄 득표 수 : " + bts + "표");
                    return;
                case 1:
                    iu++;
                    break;
                case 2:
                    you++;
                    break;
                case 3:
                    bts++;
                    break;
                default:
                    System.out.println("없는 번호입니다.");
                    break;
            }
        }
    }
}
