// 재귀에 대한 이해를 돕는 순수 재귀 메서드(재귀를 제거)
package com.multi.algo.d_recursion;

import java.util.Stack;

class C_RecurX2 {
    //--- 재귀를 제거한 recur ---//
    static void recur(int n) {
       Stack<Integer> s = new Stack<>();

        while (true) {
            if (n > 0) {
                s.push(n);                                
                // n 값을 푸시
                n = n - 1;
                continue;
            }
            if (s.isEmpty() != true) {    
            	// 스택이 비어 있지 않으면
                n = s.pop();
                // 저장하고 있던 값을 n에 팝
                System.out.println("pop한 값>>" + n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        int x = 5;

        recur(x);
    }
}

