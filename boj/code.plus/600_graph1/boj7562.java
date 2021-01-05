import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// #7562. 나이트의 이동
// bfs, 최단거리
// Memory & Time too bad.
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] arr = new int[][] {
							{-1, -2},
							{-2, -1},
							{1, -2},
							{2 , -1},
							{-1 , 2},
							{-2 , 1},
							{1 , 2},
							{2 , 1}
						};

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int l = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int nowX = Integer.parseInt(s[0]);
			int nowY = Integer.parseInt(s[1]);
			
			String[] s2 = br.readLine().split(" ");
			int targetX = Integer.parseInt(s2[0]);
			int targetY = Integer.parseInt(s2[1]);
			
			int[][] visited = new int[l][l];	
			
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(nowX, nowY));
			
			bfs(q, targetX, targetY, visited, 0);
			
		}
		
		bw.flush();
		bw.close();
	}
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
	}
	
	static void bfs (Queue<Point> q, int targetX, int targetY, int[][] visited, int distance) throws IOException {
		Point p;
		int x = 0;
		int y = 0;
		int initX = 0;
		int initY = 0;
		
		while (!q.isEmpty()) {
			p = q.poll();
			initX = p.x;
			initY = p.y;
			
//			for (int j = 0; j < visited.length; j++) {
//				System.out.println(Arrays.toString(visited[j]));
//			}
			
			if (initX == targetX && initY == targetY) {
				bw.write(visited[initX][initY] + "\n");
				return;
			}
			
			for (int i = 0; i < arr.length; i++) {
				x = initX - arr[i][0];
				y = initY - arr[i][1];
				
				if (x >= 0 && x < visited.length && y >= 0 && y < visited.length) {
					if (visited[x][y] == 0 || visited[x][y] < visited[initX][initY] + 1) {
						visited[x][y] = visited[initX][initY] + 1;
						q.add(new Point(x, y));
					}
				}
			}
		}
		
	}
	
}

