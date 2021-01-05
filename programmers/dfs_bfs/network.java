// 깊이/너비 우선 탐색 (DFS/BFS) > 네트워크
public class Solution {

	public int solution(int n, int[][] computers) {
		boolean[] visited = new boolean[n];

		int cnt = 0;

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(visited, computers, i);
				cnt++;
			}
		}

		return cnt;
	}


	public void dfs (boolean[] visited, int[][] computers, int start) {
		for (int j = 0; j < computers[start].length; j++) {
			if (computers[start][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(visited, computers, j);
			}
		}

		return;
	}
}
