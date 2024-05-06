package com.multi.homework;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class View {
	private static ArrayList list;
	
	public void view() {
		
		list = new ArrayList();
		Scanner sc = new Scanner(System.in);
		
		
		while (true){
			System.out.println("########메모장########");
			System.out.println("##### 1. 메모 입력  ###");
			System.out.println("##### 2. 메모 조회  ###");
			System.out.println("##### 3. 메모 삭제  ###");
			System.out.println("##### 4. 메모장 종료 ###" + "\n");
			
			System.out.println("숫자를 입력하세요!!");
			String num = sc.nextLine();
			
			CountDownLatch latch = new CountDownLatch(1);
			Thread2 t2= new Thread2(latch);
			t2.start();
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				System.out.println("로딩을 강제 종료합니다.");
			}
			
			t2.setStop(true);
			
			try {
				latch.await();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			
			System.out.println("로딩 성공!!");
			
			
			switch (num) {
				case "1":
					System.out.println("메모를 입력하세요");
					String str = sc.nextLine();
					list.add(str);
					System.out.println(list.size() + ": " + str);
					break;
				
				case "2":
					System.out.println("전체 메모를 조회합니다.");
					System.out.println();
					for (int i = 0; i < list.size(); i++) {
						System.out.println(i + 1 + " : " + list.get(i));
					}
					System.out.println();
					
					CountDownLatch latch2 = new CountDownLatch(1);
					Thread1 t1=new Thread1(latch2);
					t1.start();
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						System.out.println("4초를 전부 쉬지 못했습니다.");
					}
					t1.interrupt();
					
					try {
						latch2.await();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					
					break;
				
				case "3":
					System.out.println("삭제할 메모 번호를 입력하세요");
					int num2 = sc.nextInt();
					sc.nextLine();
					System.out.println(num2 + "번째 메모 '" + list.get(num2 - 1) + "' 삭제되었습니다.");
					list.remove(num2 - 1);
					break;
				
				case "4":
					System.out.println("메모장 프로그램을 종료합니다.");
					return;
				
				default:
					System.out.println("다시 입력해주세요.");
				
			}
			
		}
		
		
		
	}
	
	
}
