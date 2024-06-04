package com.multi.b_thread;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Working: " + i);
                    Thread.sleep(1000); // 작업을 시뮬레이션
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }

            System.out.println("이건 실행 되나?");
        });

        thread.interrupt();

        thread.start();

        try {
            Thread.sleep(3000); // 메인 스레드가 3초간 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // 작업 스레드를 인터럽트
    }
}
