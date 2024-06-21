package com.multi.algo.c_arraytocollection;

import java.util.Arrays;

public class H_String에서Char배열에옮기기3 {

	public static void main(String[] args) {
		String s = "s205621"; //String도 index를 이용해서 추출가능 
		//          01234
		
		char c1 = s.charAt(3);
		char c2 = s.charAt(4);
		
		String s2 = c1 + String.valueOf(c2);
		System.out.println(s2);
		
		System.out.println(s.substring(3, 5)); //3~4
		
		char[] result = new char[2];
		s.getChars(3, 5, result, 0);
		System.out.println(Arrays.toString(result));
		
		//모든 글자를 String[]로 옮겨보세요.
		//첫번째 글자와 마지막 글자를 결합시켜 프린트(s1)
		
		String[] all = s.split("");
		System.out.println(all[0] + all[all.length - 1]);
	}
}
