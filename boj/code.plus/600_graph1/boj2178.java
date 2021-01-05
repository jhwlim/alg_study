import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// #2179. 미로 탐색
// 메모리 초과
// - 아직 방문하지 않은 지점은 여러번 push 될 수 있다.
//   따라서, 큐에 집어넣으면서 인접 행렬을 찍어줘야한다!
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] move = {
			{1, 0},
			{0, 1},
			{-1, 0},
			{0, -1}
	};
	
	public static void main(String[] args) throws IOException {
		
		String[] str = br.readLine().split(" ");
		
		int h = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		
		boolean[][] visited = new boolean[h][w];
		
		for (int i = 0; i < h; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					visited[i][j] = true;
				} 
			}
		}
		
		bfs(w, h, visited, 1);
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int w, int h, boolean[][] visited, int distance) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		q.add(0);
		q.add(distance);
		visited[0][0] = false;
		
		int x = 0;
		int y = 0;
		int moveX = 0;
		int moveY = 0;
		
		while (!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			distance = q.poll();
			
			if (x == h-1 && y == w-1) {
				bw.write(distance + "\n");
				return;
			}
			
			for (int i = 0; i < move.length; i++) {
				moveX = x + move[i][0];
				moveY = y + move[i][1];
				
				if (moveX < 0 || moveX >= h 
						|| moveY < 0 || moveY >= w) {
					continue;
				}
			
				if (visited[moveX][moveY]) {
					visited[moveX][moveY] = false;
					
					q.add(moveX);
					q.add(moveY);
					q.add(distance+1);
				}
			}
		}
		
		
	}
}
