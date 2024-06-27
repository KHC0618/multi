package com.multi.algo.e_programmers;

import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11724
public class E_연결요소의개수_백준 {
	static ArrayList<Integer>[] A;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		List<String> testCases = Arrays.asList(
				"6 5\n1 2\n2 5\n5 1\n3 4\n4 6",
				"6 8\n1 2\n2 5\n5 1\n3 4\n4 6\n5 4\n2 4\n2 3"
		);

		for (String data : testCases) {
			InputStream is = new ByteArrayInputStream(data.getBytes());
			System.setIn(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			A = new ArrayList[n + 1];
			visited = new boolean[n + 1]; // 방문 배열 초기화

			for (int i = 1; i <= n; i++) {
				A[i] = new ArrayList<Integer>(); //각 깊이만큼 추가할수 있도록  A 꼭 디버깅
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				A[s].add(e);
				A[e].add(s); // 양방향 간선 추가
			}

			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					DFS(i);
					count++;  // DFS가 실행될 때마다 카운트 증가
				}
			}

			System.out.println(count);  // 연결 요소의 수 출력
		}
	}
	static void DFS(int s) {
		visited[s] = true;
		for (int node : A[s]) { // 각 A 에 들어있는 각 노드를 방문했는지 확인
			if (!visited[node]) {
				DFS(node);
			}
		}
	}
}
