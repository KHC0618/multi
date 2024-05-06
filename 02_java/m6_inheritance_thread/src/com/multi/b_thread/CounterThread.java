package com.multi.b_thread;

public class CounterThread extends Thread {
    @Override   // 어노테이션
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("===> 카운트 " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                i = -1;
            }
        }


    }
}
