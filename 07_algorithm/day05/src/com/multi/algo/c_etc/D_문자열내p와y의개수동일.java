package com.uni.data.a_programmers;
import java.util.HashMap;
//문자열 내 p와 y의 개수
//문제 설명
//대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
//
//제한사항
//문자열 s의 길이 : 50 이하의 자연수
//문자열 s는 알파벳으로만 이루어져 있습니다.
//입출력 예
//s	answer
//"pPoooyY"	true
//"Pyy"	false
//입출력 예 설명
//입출력 예 #1
//'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.
//
//입출력 예 #2
//'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.
//
//※ 공지 - 2021년 8월 23일 테스트케이스가 추가되었습니다.
public class D_문자열내p와y의개수동일 {

	public static void main(String[] args) {
		  SolutionD solution = new SolutionD();
	        
	        // 테스트 케이스
	        String[] testCases = {"pPoooyY", "Pyy", "pPoooyYyy", ""};
	        
	        for (String testCase : testCases) {
	            boolean result = solution.solution(testCase);
	            System.out.println("Test case: " + testCase + " => " + result);
	        }
		
		
		
//		String s = "pPoooyYyy";
//		//p와 y의 개수가 대소문자 상관없이 동일하면 true/false
//		//대소문자 상관없다 ==> 대문자, 소문자로 바꾸세요.
//		String s2 = s.toLowerCase(); //소문자로 변경 
//		String[] s3 = s2.split(""); //하나씩 분리
//		HashMap<String, Integer> map = new HashMap<>();
//		for (String key : s3) {
//			map.put(key, map.getOrDefault(key, 0) + 1);
//		}
//		System.out.println(map);
//		System.out.println(map);
//		System.out.println(map.get("p") == map.get("y"));
	}
}


class SolutionD {


boolean solution(String s) {
	boolean answer = false;
	int countP = 0;
	int countY = 0;

	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (c == 'p' || c == 'P') {
			countP++;
		}
		if (c == 'y' || c == 'Y') {
			countY++;
		}
	}

	if (countP == countY) {
		answer = true;
	}
	System.out.println("방법 1 : " + answer);
	//return answer;

		String sLower = s.toLowerCase(); // 소문자로 변경

		String[] s3 = sLower.split(""); // 문자열을 한 글자씩 분리하여 배열로 변환
		HashMap<String, Integer> map = new HashMap<>(); // 각 문자의 빈도 수를 저장할 HashMap
		for (String key : s3) {
			map.put(key, map.getOrDefault(key, 0) + 1); // map에 각 문자의 빈도 수 기록
		}
		System.out.println(map); // 맵 출력 (디버깅용)
		System.out.println(map.get("p")); // 'p'의 빈도 수 출력 (디버깅용)

		System.out.println(map.get("p") == map.get("y")); // 'p'와 'y'의 빈도 수 비교 결과 출력 (디버깅용)
	return map.get("p") == map.get("y"); // 'p'와 'y'의 빈도 수가 같으면 true, 다르면 false 반환

}

}