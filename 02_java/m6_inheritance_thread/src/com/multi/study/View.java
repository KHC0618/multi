package com.multi.study;

import java.util.Scanner;

public class View {


    public void view() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("***********************");
            System.out.println("*******Todo˙ꈊ˙List*****");
            System.out.println("1. 오늘의 할 일 입력하기");
            System.out.println("2. 오늘의 할 일 조회하기");
            System.out.println("3. 오늘의 일 삭제하기");
            System.out.println("4. 시스템 종료");
            System.out.println("*******Todo˙ꈊ˙List*****");
            System.out.println("***********************");

            System.out.println("1-4의 선택지 중 하나의 숫자를 입력하세요.");

            int num = 0;

            try {
                num = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());

                System.out.println("1-4의 선택지 중 하나의 숫자를 입력하세요!!! 처음으로 돌아갑니다.");
                continue;
            }

            if (!(num >= 1 && num <= 4)) {
                System.out.println("1-4의 선택지 중 하나의 숫자를 입력하세요!!! 처إ음으로 돌아갑니다.");
                continue;
            }

            ArrayList1 arr = new ArrayList1();


            switch (num) {
                case 1:
                    arr.insertList();
                    break;
                case 2:
                    arr.getTodoList();
                    break;
                case 3:
                    arr.deleteList();
                    break;
                case 4:
                    System.out.println("프로그램 종료를 시작합니다.");
                    Thread2 t2 = new Thread2();
                    t2.setDaemon(true); // 메인 스레드가 종료되면 데몬 스레드는 강제로 같이 종료된다
                    t2.start();

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("종료 완료");
                    return;
            }


        }


    }


}
