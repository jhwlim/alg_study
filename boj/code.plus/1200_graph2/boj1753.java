import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// # 1753. 최단 경로
// - 다익스트라 알고리즘
public class Main {

	private static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int start = Integer.parseInt(br.readLine()) - 1;
		
		List<Node>[] edges = new ArrayList[n];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			String[] str2 = br.readLine().split(" ");
			edges[Integer.parseInt(str2[0])-1].add(new Node(Integer.parseInt(str2[1])-1, Integer.parseInt(str2[2])));
		}
		
		boolean[] visited = new boolean[n];
		int[] distances = new int[n];
		Arrays.fill(distances, INF);
		distances[start] = 0;
		
 		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node e = pq.poll();
			visited[e.vertex] = true;
			List<Node> list = edges[e.vertex];
			for (int i = 0; i < list.size(); i++) {
				Node next = list.get(i);
				if (!visited[next.vertex]
						&& distances[e.vertex] + next.weight < distances[next.vertex]) {
					distances[next.vertex] = distances[e.vertex] + next.weight;
					pq.add(new Node(next.vertex, distances[next.vertex]));
				}
			}
		}
		
		for (int i = 0; i < distances.length; i++) {
			if (distances[i] == INF) {
				bw.write("INF" + "\n");
			} else {
				bw.write(distances[i] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
}
class Node implements Comparable<Node>{
	int vertex;
	int weight;
	
	Node(int vertex, int distance) {
		this.vertex = vertex;
		this.weight = distance;
	}
	
	@Override
	public String toString() {
		return "(" + vertex + ", " + weight + ")";
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}
