package com.uni.data.b_programmers.a_stack;

import java.util.Stack;
//햄버거 만들기
//문제 설명
//햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다.
// 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
// 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다.
// 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
// 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며,
// 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
//
//예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때,
// 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때,
// 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
//
//상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
//
//제한사항
//1 ≤ ingredient의 길이 ≤ 1,000,000
//ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
//입출력 예
//ingredient	result
//[2, 1, 1, 2, 3, 1, 2, 3, 1]	2
//[1, 3, 2, 1, 2, 1, 3, 1, 2]	0
//입출력 예 설명
//입출력 예 #1
//
//문제 예시와 같습니다.
//입출력 예 #2
//
//상수가 포장할 수 있는 햄버거가 없습니다.

public class F_햄버거만들기 {

	public static void main(String[] args) {

		SolutionF solution = new SolutionF();

		// 테스트 케이스
		int[][] testCases = { { 2, 1, 1, 2, 3, 1, 2, 3, 1 },
				{ 1, 3, 2, 1, 2, 1, 3, 1, 2 }
		};

		for (int[] testCase : testCases) {
			int result = solution.solution(testCase);
			System.out.println("ingredient: " + java.util.Arrays.toString(testCase) + " => " + result);
		}
	}

}

class SolutionF {
	public int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>(); // 재료를 저장할 스택

		for (int ing : ingredient) { // 모든 재료를 순회
			stack.push(ing); // 현재 재료를 스택에 추가

			// 방법1
			 // 햄버거 조립이 가능한지 확인
            if (stack.size() >= 4) {
                // 스택의 상위 4개가 햄버거 조립 순서와 일치하는지 확인
                if (stack.get(stack.size() - 4) == 1 &&
                    stack.get(stack.size() - 3) == 2 &&
                    stack.get(stack.size() - 2) == 3 &&
                    stack.get(stack.size() - 1) == 1) {
                    // 햄버거를 조립할 수 있으면 상위 4개 재료를 제거하고 개수 증가
                    for (int i = 0; i < 4; i++) stack.pop();
                    answer++;
                }
            }

//			// 방법2
//
//			// 스택의 크기가 4 이상이면 햄버거 조립 가능성 검사
//			if (stack.size() >= 4) {
//				// 스택에서 상위 4개 재료를 pop
//				int b2 = stack.pop(); // 맨 위 빵
//				int m = stack.pop(); // 고기
//				int v = stack.pop(); // 야채
//				int b1 = stack.pop(); // 아래 빵
//
//				// 조립 순서가 맞으면 햄버거 완성, 아니면 재료 다시 스택에 넣기
//				if (!(b1 == 1 && b2 == 1 && v == 2 && m == 3)) {
//					stack.push(b1);
//					stack.push(v);
//					stack.push(m);
//					stack.push(b2);
//				} else {
//					answer++; // 완성된 햄버거 수 증가
//				}
//			}
//
	}

		return answer;

	}
}
