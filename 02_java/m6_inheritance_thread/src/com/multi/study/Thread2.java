package com.multi.study;

public class Thread2 extends Thread {


    public void out() {
        System.out.println("종료 중..");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            out();
        }

    }
}
