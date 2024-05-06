package com.multi.study;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

public class ArrayList1 {

    private static int count = 0;
    private static ArrayList todoList = new ArrayList();
    Scanner sc = new Scanner(System.in);


    public ArrayList1() {
    }


    public void insertList() {

        while (true) {
            System.out.println("오늘의 할 일을 입력하세요.");
            String todo = sc.nextLine();

            if (!(todo.trim().equals(""))) {

                CountDownLatch latch = new CountDownLatch(1);
                Thread3 t3 = new Thread3(latch);
                t3.start();

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                t3.interrupt();

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                todoList.add(todo);
                count++;
            } else {
                System.out.println("입력을 안하신 것 같아요. 오류 발생합니다...");

                CountDownLatch latch = new CountDownLatch(1);
                Thread1 t1 = new Thread1(latch);
                t1.start();


                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                t1.setStop(true);

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                continue;
            }

            System.out.print("오늘의 할 일를 더 입력합니까? (yes/no)");
            String answer = sc.next();
            sc.nextLine();
            if (answer.equals("no")) {
                System.out.println("입력을 종료합니다.");
                break;
            }
        }
    }


    public int getCount() {
        System.out.println("오늘의 할 일은 총 " + count + "개 입니다.");
        return count;
    }

    public ArrayList getTodoList() {

        if (count == 0) {
            System.out.println("조회할 항목이 없습니다!!");
            return todoList;
        } else if (count == 1) {
            for (int i = 0; i < count; i++) {
                System.out.println(i + ". " + todoList.get(i) + " ◖⚆ᴥ⚆◗");

                return todoList;
            }
        }


        System.out.println("전체 목록을 조회하시겠습니까? (yes/no)");
        String answer = sc.next();
        sc.nextLine();
        if (answer.equals("no")) {
            while (true) {
                System.out.println("1-" + count + "의 선택지 중 하나의 숫자를 입력하세요.");

                int num = 0;

                try {
                    num = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());

                    System.out.println("1-" + count + "의 선택지 중 하나의 숫자를 입력하세요!!! 처음으로 돌아갑니다.");
                    continue;
                }

                if (!(num >= 1 && num <= count)) {
                    System.out.println("1-" + count + "의 선택지 중 하나의 숫자를 입력하세요!!! 처음으로 돌아갑니다.");
                    continue;
                }

                System.out.println(num + ". " + todoList.get(num - 1) + "◖⚆ᴥ⚆◗");


                System.out.print("오늘의 할 일를 더 조회합니까? (yes/no)");
                String answer2 = sc.next();
                sc.nextLine();
                if (answer2.equals("no")) {
                    System.out.println("조회을 종료합니다.");
                    break;
                }

            }


        } else {
            System.out.println("모든 목록 불러오는 중입니다.");

            Timer timer = new Timer();
            CountDownLatch latch = new CountDownLatch(1);
            Thread4 t4= new Thread4(latch);
            timer.schedule(t4, 3000);
            System.out.println("3초만 기다려주세요. 접속자가 많습니다.");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            t4.setStop(true);


            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            timer.cancel();

            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(i + 1 + ". " + todoList.get(i) + " ◖⚆ᴥ⚆◗");
            }
            return todoList;
        }

        return todoList;

    }


    public void deleteList() {
        while (true) {
            if (count == 0) {
                System.out.println("조회할 항목이 없습니다!!");
                return;
            }


            System.out.println("1-" + count + "의 선택지 중 삭제할 하나의 숫자를 입력하세요.");

            int num = 0;

            try {
                num = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
                System.out.println("1-" + count + "의 선택지 중 하나의 숫자를 입력하세요!!! 처음으로 돌아갑니다.");
                continue;
            }

            if (!(num >= 1 && num <= count)) {
                System.out.println("1-" + count + "의 선택지 중 하나의 숫자를 입력하세요!!!  처음으로 돌아갑니다.");
                continue;
            }

            System.out.println(num + ". " + todoList.get(num - 1) + "을 삭제했습니다. ◖⚆ᴥ⚆◗");
            count--;
            todoList.remove(num - 1);


            System.out.print("오늘의 할 일를 더 삭제합니까? (yes/no)");
            String answer2 = sc.next();
            sc.nextLine();
            if (answer2.equals("no")) {

                System.out.println("삭제를 종료합니다.");

                break;
            }

        }

    }


}
