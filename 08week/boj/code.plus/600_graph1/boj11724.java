import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// #11724. 연결 요소의 개수
// 주의사항 : 정점도 선에 포함됨.
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		ArrayList<Integer>[] listArr = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
		
		int to = 0;
		int from = 0;
		
		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			to = Integer.parseInt(s[0]);
			from = Integer.parseInt(s[1]);
			
			if (listArr[to] == null) {
				listArr[to] = new ArrayList<>();
			}
			listArr[to].add(from);
			
			if (listArr[from] == null) {
				listArr[from] = new ArrayList<>();
			}
			listArr[from].add(to);
		}
		
		int cnt = 0;
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(listArr, visited, i);
				cnt++;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		
	}

	static void dfs(ArrayList<Integer>[] listArr, boolean[] visited, int node) {
		
		visited[node] = true;
		
		if (listArr[node] == null) return;
		
		int n = 0;
		
		for (int i = 0; i < listArr[node].size(); i++) {
			n = listArr[node].get(i);
			if (!visited[n]) {
				dfs(listArr, visited, n);
			}
		}			
		
		
	}
	

}
