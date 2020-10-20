import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// #1260. DFS와 BFS
/*
 * 반례
1000 1 1
999 1000
>
1
1

9 9 1
1 2
1 3
2 4
2 5
3 7
3 8
5 6
6 9
7 9
>
1 2 4 5 6 9 7 3 8
1 2 3 4 5 7 8 6 9

 */
public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int start = Integer.parseInt(str[2]);
		
		ArrayList<Integer>[] listArr = new ArrayList[n+1];
		
		int from = 0;
		int to = 0;
		
		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			from = Integer.parseInt(s[0]);
			to = Integer.parseInt(s[1]);
			
			if (listArr[from] == null) {
				listArr[from] = new ArrayList<>();
			}
			
			if (listArr[to] == null) {
				listArr[to] = new ArrayList<>();
			}
			
			listArr[from].add(to);
			listArr[to].add(from);
		}
		
		for (ArrayList<Integer> list : listArr) {
			if (list != null) {
				Collections.sort(list);
			}
		}
		
		boolean[] visited = new boolean[n+1];
		
		// dfs
		visited[start] = true;
		
		dfs(listArr, visited, start);
	
		// bfs
		Queue<Integer> q = new LinkedList<Integer>();
		
		Arrays.fill(visited, false);
		visited[start] = true;
		q.add(start);
		
		bfs(listArr, visited, q);
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(ArrayList<Integer>[] listArr, boolean[] visited, int node) throws IOException {

		bw.write(node + " ");
		
		// 모든 노드에 방문하였으면 종료
		if (checkBool(listArr, visited)) {
			bw.write("\n");
			return;
		}
		
		// 노드에 간선이 없는 경우, 종료
		if (listArr[node] == null) {
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < listArr[node].size(); i++) {
			if (!visited[listArr[node].get(i)]) {
				visited[listArr[node].get(i)] = true;
//				bw.write(listArr[node].get(i) + " ");
				dfs(listArr, visited, listArr[node].get(i));
			}
		}
	}
	
	static void bfs(ArrayList<Integer>[] listArr, boolean[] visited, Queue<Integer> q) throws IOException {
		
		// 모든 노드에 방문하였으면 종료
		if (checkBool(listArr, visited)) {
			while (!q.isEmpty()) {
				bw.write(q.poll()+" ");
			}
			bw.write("\n");
			return;
		}
		
		int out = q.poll();
		bw.write(out + " ");
		
		// 노드에 간선이 없는 경우, 종료
		if (listArr[out] == null) {
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < listArr[out].size(); i++) {
			if (!visited[listArr[out].get(i)]) {
				q.add(listArr[out].get(i));
				visited[listArr[out].get(i)] = true;
			}
		}
//		System.out.println(q);
//		System.out.println(Arrays.toString(visited));

		bfs(listArr, visited, q);
	}
	
	static boolean checkBool(ArrayList<Integer>[] listArr, boolean[] bools) {
		
		for (int i = 0; i < listArr.length; i++) {
			if (listArr[i] != null && !bools[i]) return false;
		}
		
		return true;
	}
	
}

