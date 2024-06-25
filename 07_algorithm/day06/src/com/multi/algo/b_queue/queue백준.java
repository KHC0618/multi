package com.multi.algo.b_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue백준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        Queue<Integer> queue = new LinkedList<>();

        // 큐에 1부터 N까지의 숫자를 넣는다
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 큐에 한 장의 카드가 남을 때까지 반복한다
        while (queue.size() > 1) {
            // 제일 위에 있는 카드를 버린다
            queue.poll();
            // 제일 위에 있는 카드를 제일 아래로 옮긴다
            queue.add(queue.poll());
        }

        // 마지막으로 남은 카드를 출력한다
        System.out.println(queue.poll());
    }
}
