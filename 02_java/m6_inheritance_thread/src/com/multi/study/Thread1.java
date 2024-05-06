package com.multi.study;

import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Thread1 extends Thread {

    private boolean stop;
    private CountDownLatch latch;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Thread1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        while (!stop) {
            Scanner sc=new Scanner(System.in);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.beep();
            toolkit.beep();
            toolkit.beep();
            System.out.println("당신의 부주의로 인하여 투두리스트가 해킹당하고 있습니다... 」(￣▽￣」)");

        }
        System.out.println("*******복구완료*******");
        latch.countDown();


    }
}