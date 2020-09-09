import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {

		/*
		 * (N, K) ; N번까지, K번째 제거하는 순서
		 * 1, 2, 3, 4, 5, 6, 7 -> 1, 2, 3 -> 3
		 * 1, 2, 4, 5, 6, 7 -> 4, 5, 6 -> 6
		 * 1, 2, 4, 5, 6 -> 7, 1, 2 -> 2
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		
		
		bw.write(solution(Integer.parseInt(s[0]), Integer.parseInt(s[1])).toString());
		bw.flush();
		bw.close();
		
	}

	static StringBuilder solution(int n, int k){
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		int idx = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i < n+1; i++) {
			q.add(i);
		}
		
		while (!q.isEmpty()) {
			for (int i = 0; i < k-1; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll());
			if (idx != n-1) sb.append(", ");
		
			idx++;
		}
		
		sb.append('>');
		return sb;
		}
}
