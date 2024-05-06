package com.multi.study;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Thread4 extends TimerTask {

    private CountDownLatch latch;
    private boolean stop=false;

    public Thread4(CountDownLatch latch) {
        this.latch = latch;
    }


    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void runnig() {
        System.out.println("이제서야 불러오고 있어요..");
    }


    @Override
    public void run() {
        while (!stop){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            runnig();
        }
        System.out.println("접속 성공!!");
        latch.countDown();

    }
}
