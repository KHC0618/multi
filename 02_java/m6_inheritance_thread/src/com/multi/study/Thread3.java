package com.multi.study;

import java.util.concurrent.CountDownLatch;

public class Thread3 extends Thread {

    private CountDownLatch latch;

    public Thread3(CountDownLatch latch) {
        this.latch = latch;
    }

    public void loading() {
        System.out.println("로딩 중...");
    }


    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            loading();
        }

        System.out.println("로딩이 완료되었습니다.");
        latch.countDown();

    }
}
