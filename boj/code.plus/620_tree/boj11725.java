import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// # 11725. 트리의 부모 찾기
public class Main {

/*
4
1 2
4 3
2 3

1
2
3
 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		List<List<Integer>> connects = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			connects.add(new ArrayList<Integer>());
		}
		
		int data1 = 0;
		int data2 = 0;
		for (int i = 0; i < n-1; i++) {
			String[] strs = br.readLine().split(" ");
			data1 = Integer.parseInt(strs[0]);
			data2 = Integer.parseInt(strs[1]);
			connects.get(data1).add(data2);
			connects.get(data2).add(data1);
		}
		
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[1] = true;
		q.add(1);
		
		int[] parents = new int[n+1];
		
		int data = 0;
		while (!q.isEmpty()) {
			data = q.poll();
			for (int i : connects.get(data)) {
				if (!visited[i]) {
					visited[i] = true;
					parents[i] = data;
					q.add(i);
				}
			}
		}
		
		for (int i = 2; i < parents.length; i++) {
			bw.write(parents[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
