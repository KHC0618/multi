package com.multi.b_polymorphism;

import java.util.Scanner;

public class FoodOrder2 {
    static Food[] menu = new Food[10];

    public static int totalCount;
    public static int totalPrice;

    public static void order(int num) {
        int count = menu[num - 1].getCount();
        menu[num - 1].setCount(count + 1);
        totalCount++;
        totalPrice += menu[num - 1].getPrice();
    }

    public static void main(String[] args) {

        menu[0] = new Food("짜장면", 7000);
        menu[1] = new Food("짬뽕", 8000);
        menu[2] = new Food("우동", 6000);

        while (true) {
            Scanner s = new Scanner(System.in);

            System.out.println("========== 메뉴를 선택하세요. ==========");
            System.out.println("1. 짜장면");
            System.out.println("2. 짬뽕");
            System.out.println("3. 우동");
            System.out.println("4. 주문 메뉴 확인");
            System.out.println("5. 계산하기");
            System.out.println("6. 나가기");
            System.out.println("====================================");

            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    order(choice);
                    break;

                case 4:
                    System.out.println("============ 주문한 메뉴 ============");
                    if (totalCount == 0) {
                        System.out.println("주문하신 메뉴가 없습니다.");
                    } else {
                        for (int i = 0; i < menu.length; i++) {
                            if (menu[i] != null && menu[i].getCount() != 0 ) {
                                if (menu[i].getCount() != 0) {
                                    System.out.println(menu[i].getName() + ": " + menu[i].getCount());
                                }
                            }
                        }
                        System.out.println("결제하실 금액은 " + totalPrice + "원입니다.");
                    }
                    System.out.println("====================================");
                    break;

                case 5:
                    System.out.println("====================================");
                    System.out.println("주문하신 메뉴는 총 "+totalCount+"개입니다.");
                    System.out.println("결제하실 금액은 " + totalPrice + "원입니다. 감사합니다.");
                    System.out.println("====================================");
                    return;

                case 6:
                    System.out.println("주문이 취소되었습니다.");
                    return;

                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

            }
        }
    }
}
