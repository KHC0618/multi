package com.multi.algo.b_programmers;

import java.util.Scanner;

public class A_두수의차 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        SolutionA sol = new SolutionA();
        int answer = sol.solution(num1, num2); //int
        System.out.println(answer);
        sc.close();
    }
}

class SolutionA {
    public int solution(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }
}
