package com.multi.practice;

import java.util.Scanner;

public class View {

    ToDoList tdl = new ToDoList();
    Scanner sc = new Scanner(System.in);

    public View() {

        while (true) {
            System.out.println("========================");
            System.out.println("======= 메인 화면 =======");
            System.out.println("== 1. 오늘의 할 일 조회 ==");
            System.out.println("== 2. 오늘의 할 일 추가 ==");
            System.out.println("== 3. 오늘의 할 일 수정 ==");
            System.out.println("== 4. 오늘의 할 일 삭제 ==");
            System.out.println("== 5. 프로그램 종료 ======");
            System.out.println("========================");

            int select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                case 1:
                    listCheck();
                    System.out.println("메인 화면으로 가려면");
                    System.out.println("아무 키나 입력하세요.");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("할 일을 입력하세요.");
                    tdl.insertSelectNumber(select);
                    break;
                case 3:
                    listCheck();
                    System.out.println("몇 번을 수정하시겠습니까?");
                    tdl.insertSelectNumber(select);
                    break;
                case 4:
                    listCheck();
                    System.out.println("몇 번을 지우시겠습니까?");
                    tdl.insertSelectNumber(select);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("번호를 다시 입력하세요.");
                    break;
            }
        }
    }

    public void listCheck() {
        for(int i = 0; i < (tdl.getTodoList().size() + 2); i++) {
            if (i == 0 || i == (tdl.getTodoList().size() + 1)) {
                System.out.println("========================");
            } else {
                System.out.println(i + ". " + tdl.getTodoList().get(i - 1));
            }
        }
    }
}
