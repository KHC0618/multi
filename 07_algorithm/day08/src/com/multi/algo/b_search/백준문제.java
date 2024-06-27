package com.multi.algo.b_search;

import java.util.HashSet;
import java.util.Scanner;

public class 백준문제 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 N을 입력 받습니다.
        int N = scanner.nextInt();

        // N개의 정수를 HashSet에 추가합니다.
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(scanner.nextInt());
        }

        // 세 번째 줄에서 M을 입력 받습니다.
        int M = scanner.nextInt();

        // M개의 질의에 대해 결과를 출력합니다.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = scanner.nextInt();
            if (set.contains(query)) {
                result.append(1).append('\n');
            } else {
                result.append(0).append('\n');
            }
        }

        // 결과 출력
        System.out.print(result);

        scanner.close();
    }
}
