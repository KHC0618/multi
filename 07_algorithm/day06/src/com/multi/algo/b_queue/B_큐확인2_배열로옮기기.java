package com.uni.data.b_programmers.b_queue;

import java.util.Arrays;
import java.util.LinkedList;

public class B_큐확인2_배열로옮기기 {

	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<>();
		queue.add("추가1"); //front
		queue.add("추가2");
		queue.add("추가3"); //back(rear)
		//뒤 ["추가3", "추가2","추가1"]앞 
		//       2        1       0
//		System.out.println(queue.remove());
//		System.out.println("front>>" + queue.peek());
//		System.out.println("======");
//		System.out.println(queue.remove());
//		System.out.println("front>>" + queue.peek());
		
		String[] arr = new String[queue.size()];
		//{"추가1", "추가2", "추가3"} ==> 0, 1, 2
		//옮겨보실래요.!
		for (int i = 0; i < arr.length; i++) {
			arr[i] = queue.remove();
		}
		System.out.println(Arrays.toString(arr));
	}

}
