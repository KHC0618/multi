package com.uni.data.e_programmers;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1260

//dfs - 노드 타고 내려 갔다가 더이상  갈수 없으면 다시 한칸 위로 올라감 다시 내려감.  -> 스택
//bfs - 너비 레벨 중심. 한단계 아래 레벨 갔다가 그다음 레벨 탐색  -> 큐


public class F_DFSBFS_백준 {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static StringBuilder dfsResult = new StringBuilder();
	static StringBuilder bfsResult = new StringBuilder();

	public static void main(String[] args) throws IOException {
		List<String> testCases = Arrays.asList(
				"4 5 1\n1 2\n1 3\n1 4\n2 4\n3 4",
				"5 5 3\n5 4\n5 2\n1 2\n3 4\n3 1",
				"1000 1 1000\n999 1000"
		);

		for (String data : testCases) {
			InputStream is = new ByteArrayInputStream(data.getBytes());
			System.setIn(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());  // 정점의 수
			int M = Integer.parseInt(st.nextToken());  // 간선의 수
			int Start = Integer.parseInt(st.nextToken());  // 시작 정점

			adjList = new ArrayList[N + 1]; // 인덱스 +1

			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				adjList[e].add(s);  // 양방향 간선 추가
			}

			for (int i = 1; i <= N; i++) {
				Collections.sort(adjList[i]);  // 연결된 정점 정렬  오름차순
			}

			// DFS
			visited = new boolean[N + 1];
			DFS(Start);

			// BFS
			visited = new boolean[N + 1];
			BFS(Start);

			System.out.println("DFS Result: " + dfsResult.toString().trim());
			System.out.println("BFS Result: " + bfsResult.toString().trim());

			// Reset string builders for the next test case
			dfsResult.setLength(0);
			bfsResult.setLength(0);
		}
	}

	public static void DFS(int node) {

		System.out.println(node);
		visited[node] = true;  // 방문했으면 true 로 변경
		dfsResult.append(node).append(" ");
		for (int neighbor : adjList[node]) {
			if (!visited[neighbor]) { // 이미 방문한 노드는 방문하지않는다
				DFS(neighbor);
			}
		}
	}

	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start); // 시작 노드 추가
		visited[start] = true; // 방문했으면 true 로 변경

		while (!queue.isEmpty()) {  // 큐가 빌때까지
			int node = queue.poll();// 시작노드 가 제일먼저 출력 - 먼저들어간게 먼저나옴
			bfsResult.append(node).append(" ");
			for (int neighbor : adjList[node]) {
				if (!visited[neighbor]) { //방문안했으면 다시 큐에 넣어줌
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}
}