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
		Queue<Point> q;
		int[][] visited;
		
		for (int i = 0; i < n; i++) {
			int l = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int nowX = Integer.parseInt(s[0]);
			int nowY = Integer.parseInt(s[1]);
			
			String[] s2 = br.readLine().split(" ");
			int targetX = Integer.parseInt(s2[0]);
			int targetY = Integer.parseInt(s2[1]);
			
			visited = new int[l][l];	
			
			q = new LinkedList<>();
			q.add(new Point(nowX, nowY));
			
			bfs(q, targetX, targetY, visited);
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
	
	static void bfs (Queue<Point> q, int targetX, int targetY, int[][] visited) throws IOException {
		Point p;
		int x = 0;
		int y = 0;
		int initValue = 0;
		
		while (!q.isEmpty()) {
			p = q.poll();
			initValue = visited[p.x][p.y];
			if (p.x == targetX && p.y == targetY) {
				bw.write(initValue + "\n");
				return;
			}
			
	
			for (int i = 0; i < arr.length; i++) {
				x = p.x - arr[i][0];
				y = p.y - arr[i][1];
				
				if (x < 0 || x > visited.length-1 || y < 0 || y > visited.length-1) {
					continue;
				}
				
				if (visited[x][y] == 0) {
					visited[x][y] = initValue + 1;
					q.add(new Point(x, y));
				}
			}
		}
		
		
	}
	
	
}


