package com.multi.algo.e_programmers;

import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13023

//첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
//
//둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
public class F_ABCDE친구관계_백준_DFS {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static boolean found = false;

	public static void main(String[] args) throws IOException {
		List<String> testCases = new ArrayList<>();
		// 테스트 케이스 정의
		testCases.add("5 4\n0 1\n1 2\n2 3\n3 4");
		testCases.add("5 5\n0 1\n1 2\n2 3\n3 0\n1 4");
		testCases.add("6 5\n0 1\n0 2\n0 3\n0 4\n0 5");
		testCases.add("8 8\n1 7\n3 7\n4 7\n3 4\n4 6\n3 5\n0 4\n2 7");

		for (String data : testCases) {
			InputStream is = new ByteArrayInputStream(data.getBytes());
			System.setIn(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			adj = new ArrayList[N];

			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adj[s].add(e);
				adj[e].add(s); // 양방향 간선 추가
			}

			found = false;
			for (int i = 0; i < N && !found; i++) {
				visited = new boolean[N];
				DFS(i, 0);
			}

			System.out.println(found ? 1 : 0);
		}
	}

	static void DFS(int node, int depth) {
		if (depth == 4) {
			found = true;
			return;
		}

		visited[node] = true;
		for (int neighbor : adj[node]) {
			if (!visited[neighbor]) {
				DFS(neighbor, depth + 1);
				if (found) return;
			}
		}
		visited[node] = false;  // Backtrack
	}
}
