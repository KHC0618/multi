package com.multi.homework;

import java.util.concurrent.CountDownLatch;

public class Thread2 extends Thread {
	
	private boolean stop = false;
	private CountDownLatch latch;
	
	public void loading() throws InterruptedException {
		
		while (!stop) {
			System.out.println("로딩 실패로 다시 시도합니다.");
			for (int i = 0; i < 5; i++) {
				System.out.println((5 - i) + "초.. 로딩중...");
				Thread.sleep(1000);
			}
			
		}
		latch.countDown();
	}
	
	public Thread2(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			loading();
		} catch (InterruptedException e) {
			System.out.println("로딩 방해받음");
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
