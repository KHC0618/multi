package com.multi.b_polymorphism;

import java.util.Scanner;

public class Order {

    public Order() {

        Scanner sc = new Scanner(System.in);
        Controller ctr = new Controller();

        while(true) {
            System.out.println("== 음식점 주문 화면 ==");
            System.out.println("===== 1. 짬 뽕 ======");
            System.out.println("===== 2. 우 동 ======");
            System.out.println("===== 3. 짜 장 ======");
            System.out.println("==== 4. 결제하기 ====");
            System.out.println("== 8. 프로그램 종료 ==");

            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    ctr.setFood1(num);
                    System.out.println("현재 짬뽕의 주문 수 : " + ctr.getFood1());
                    break;
                case 2:
                    ctr.setFood2(num);
                    System.out.println("현재 우동의 주문 수 : " + ctr.getFood2());
                    break;
                case 3:
                    ctr.setFood3(num);
                    System.out.println("현재 짜장의 주문 수 : " + ctr.getFood3());
                    break;
                case 4:
                    ctr.setTotalCount();
                    System.out.println("짬뽕 " + ctr.getFood1() + "그릇, 금액 : " + ctr.totalFood1Sum());
                    System.out.println("우동 " + ctr.getFood2() + "그릇, 금액 : " + ctr.totalFood2Sum());
                    System.out.println("짜장 " + ctr.getFood3() + "그릇, 금액 : " + ctr.totalFood3Sum());
                    System.out.println("총 " + ctr.getTotalCount() + "그릇이며, 결제 금액은 " + ctr.totalSum() + "원 입니다.");
                    ctr.setFood1(num);
                    ctr.setFood2(num);
                    ctr.setFood3(num);
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    break;
            }
        }
    }
}
