package com.multi.homework;

import java.awt.*;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Thread1 extends Thread {
	private CountDownLatch latch;
	
	
	public Thread1(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void time() {
		Date date = new Date();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.beep();
		System.out.println("현재 시각은 " + date);
	}
	
	
	@Override
	public void run() {
		while (true) {
			time();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("시간 스레드 강제 종료합니다.");
				latch.countDown();
				break;
			}
			
		}
		
	}
}
