package com.multi.algo.b_nonlinear;

import java.util.*;

public class A_Set반복자 {

	public static void main(String[] args) {
		String s = "aaabbbcdddefe";
		// 중복된거 제거한 컬렉션을 만들어보세요.

		// char에 대한 처리가 필요없고
		// 데이터양이 많지 않으면
		// 그냥 String으로 해도 괜찮다.!
		// 문자열을 String[]로 만들어보자.
		String[] sList = s.split("");

		// 문자열을 char[]로 만드는 방법도 있다.!
		// hashset에 넣어서 중복을 제거한 목록을 만든 후 프린트
		Set<String> sSet = new HashSet<>();

		// set은 for-each를 허용
		for (String s1 : sList) {
			sSet.add(s1);
		}

		System.out.println(sSet);



//		for (int i = 0; i < set.size(); i++) {
//			System.out.println(set.get(i));//사용불가!
//		}
		System.out.println("------------------");

		// list를 이용해서 중복을 제거한 목록을 만든 후 프린트
		List<String> list = new ArrayList<>();
		for (String x : sList) {
			if (!list.contains(x)) {
				list.add(x);
			}
		}
		Collections.sort(list);


		//ANSWER에 담는방법 1
		String answer2 = "";
		for (String x : list) {
			answer2 += x;
		}
		System.out.println(answer2);
		
		//ANSWER에 담는방법 2
		String answer = String.join(", ", list);
		System.out.println(answer);


		System.out.println("------------------");

		Iterator<String> iterator = sSet.iterator();
		for (int i = 0; i < sSet.size(); i++) {
			String x = iterator.next();// 하나씩 꺼내줄때 사용!
			// iterator.hasNext(); 있는지 없는지 체크가능!
			System.out.println(x);
		}
		System.out.println("------------------");
		
		
		// 한번만등장한 문자를 풀때 
		// 전체 어떤 문자들이 있는지 set을 통해서 목록을 얻음.
		// 이 목록안에 들어있는 문자가 각각 몇개씩 있는지 체크해서
		// 1개인것만 찾아서 모으세요.!!!
		System.out.println(Collections.frequency(list, "c"));//frequency 빈도수 나오는 메소드
		System.out.println("------------------");

		
		String s3 = "aaabbbcdddefe";
		//String에 있는 값들을 하나씩 분리한 후, 
		//중복 제거 리스트를 구해서
		//전체 목록에서 각 글자가 몇 개씩 나오는지 확인(1인 것만 목록 만드세요.)
		//정렬한후, String으로 모으세요.!  이 순서데로 한번 풀어보세요
		String[] sList3 = s3.split("");
		Set<String> sSet3 = new HashSet<>();
		String answer3 = "";
		List<String> list3 = new ArrayList<>();

		for (String x : sList3) {
			sSet3.add(x);
		}

		for (String x : sSet3) {
			list3.add(x);
			System.out.println(Collections.frequency(List.of(sList3), x));
			if (Collections.frequency(List.of(sList3), x) == 1) {
				answer3 += x;
			}
		}

		System.out.println(answer3);

		Collections.sort(list3);

		String a3 = "";
		for (String x : list3) {
			a3 += x;
		}

		System.out.println(a3);

		//list, set 인경우 --> sort, reverse, frequency, min, max, fill (Collections에 제공)
		System.out.println(Collections.min(list3));

		System.out.println(Collections.max(list3));
		System.out.println("------------------");

		ArrayList<String> sub = new ArrayList<String>();
		sub.add("b");
		sub.add("c");
		System.out.println(Collections.indexOfSubList(list3,sub));//aaabbbcdddefe
		System.out.println("------------------");

		Collections.fill(list3, "ttt");
		System.out.println(list3);
		
		
	}
}






