package com.multi.practice;

import java.util.Scanner;

public class View {
    public static void viewMethod() {

        Scanner sc = new Scanner(System.in);
        CatalogueController cc = new CatalogueController();
        System.out.println("\n");
        System.out.println("제품 관리 시스템을 시작합니다.");
        System.out.println("1. 제품 정보 입력하기");
        System.out.println("2. 제품 정보 수정하기");
        System.out.println("3. 제품 출력하기");
        System.out.println("4. 시스템 종료");
        System.out.println();
        System.out.print("1~4를 선택하고 특정번호를 입력하십시오. ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                cc.insertProduct();
                break;

            case 2:
                System.out.println("총 " + Product.count + "개의 제품이 있습니다");
                System.out.println("제품 수정방법 1~3를 선택하고 특정번호를 입력하십시오. ");
                System.out.println();
                System.out.println("1. 아이디/제품명/가격");
                System.out.println("2. 제품명/가격");
                System.out.println("3. 가격");

                int choice2 = sc.nextInt();

                if (choice2 == 1) {
                    cc.updateProduct1();
                } else if (choice2 == 2) {
                    cc.updateProduct2();
                } else if (choice2 == 3) {
                    cc.updateProduct3();
                }
                break;


            case 3:
                System.out.println("총 " + Product.count + "개의 제품이 있습니다. 전부 출력하시겠습니까? (yes/no) ");
                String choice3 = sc.nextLine();
                cc.printProduct(choice3);
                break;


            case 4:
                System.out.println("시스템을 종료합니다.");
                System.exit(0);


        }


    }
}
