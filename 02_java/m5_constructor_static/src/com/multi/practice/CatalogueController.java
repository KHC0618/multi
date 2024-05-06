package com.multi.practice;

import java.util.Scanner;

public class CatalogueController {
    Scanner sc = new Scanner(System.in);
    public static Product[] pr_list = new Product[10];

    public void insertProduct() {

        if (Product.count >= 10) {
            System.out.println("입력 갯수 초과입니다.");
            return;
        }

        System.out.print("숫자 아이디를 입력: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("제품명을 입력: ");
        String name = sc.nextLine();


        System.out.print("가격을 입력: ");
        int price = sc.nextInt();
        sc.nextLine();


        Product pr = new Product(id, name, price);

        pr_list[Product.count - 1] = pr;

    }


    public void printProduct(String choice) {

        if (choice.equals("yes")) {
            for (int i = 0; i < Product.count; i++) {
                System.out.println(pr_list[i]);
            }
        } else {
            System.out.println("몇번째 제품을 조회하고 싶으십니까?");
            int item_num = sc.nextInt();
            sc.nextLine();
            System.out.println(pr_list[item_num - 1]);


        }


    }


    public void updateProduct1() {
        System.out.println("몇번째 제품을 수정하고 싶으십니까?");

        int item_num = sc.nextInt();

        Product product = pr_list[item_num - 1];


        System.out.print("숫자 아이디를 입력: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("제품명을 입력: ");
        String name = sc.nextLine();

        System.out.print("가격을 입력: ");
        int price = sc.nextInt();
        sc.nextLine();


        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        System.out.println("제품의 정보가 변경되었습니다.");
        System.out.println(product.toString());


    }

    public void updateProduct2() {

        System.out.println("몇번째 제품을 수정하고 싶으십니까?");
        int item_num = sc.nextInt();

        Product product = pr_list[item_num - 1];

        System.out.print("제품명을 입력: ");
        String name = sc.next();
        sc.nextLine();

        System.out.print("가격을 입력: ");
        int price = sc.nextInt();
        sc.nextLine();

        product.setName(name);
        product.setPrice(price);
        System.out.println("제품의 정보가 변경되었습니다.");
        System.out.println(product.toString());

    }

    public void updateProduct3() {

        System.out.println("몇번째 제품을 수정하고 싶으십니까?");
        int item_num = sc.nextInt();

        Product product = pr_list[item_num - 1];

        System.out.print("가격을 입력: ");
        int price = sc.nextInt();
        sc.nextLine();

        product.setPrice(price);
        System.out.println("제품의 정보가 변경되었습니다.");
        System.out.println(product.toString());


    }
}
