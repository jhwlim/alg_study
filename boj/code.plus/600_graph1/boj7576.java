import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// #7576. 토마토
public class Main {

	static int w;
	static int h;

	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		w = Integer.parseInt(str[0]);
		h = Integer.parseInt(str[1]);
		
		int[][] box = new int[h][w];
		
		for (int i = 0; i < box.length; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < box[i].length; j++) {
				box[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		q = new LinkedList<Integer>();
		boolean[][] visited = new boolean[h][w];
		
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] == 1) {
					visited[i][j] = true;
					q.add(i);
					q.add(j);
				}
			}
		}
		
		// 시간초과 -> '1' 인 지점을 우선 큐에 넣고서, bfs를 한번만 실행한다.
		bfs(visited, box);
		
		boolean flag = true;
		int max = 0;
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] == 0) {
					max = 0;
					flag = false;
					break;
				}
				
				if (box[i][j] > max) {
					max = box[i][j];
				}
			}
			if (!flag) {
				break;
			}
		}
		
		bw.write(--max + "\n");
		
		bw.flush();
		bw.close();
		
	}
	
	static int[][] move = {
			{1, 0},
			{0, 1},
			{-1, 0},
			{0, -1}
	};
	
	
	static void bfs(boolean[][] visited, int[][] box) {
		int initX = 0, initY = 0;
		int moveX = 0, moveY = 0;
		
		while (!q.isEmpty()) {
//			System.out.println(q);
			
//			for (int i = 0; i < box.length; i++) {
//				System.out.println(Arrays.toString(box[i]));
//			}
//			System.out.println();
			
			initX = q.poll();
			initY = q.poll();
			
			for (int i = 0; i < move.length; i++) {
				moveX = initX + move[i][0];
				moveY = initY + move[i][1];
			
				if (moveX < 0 || moveX >= h) {
					continue;
				}
				
				if (moveY < 0 || moveY >= w) {
					continue;
				}
				
				// -1 이 아니고, 0 또는 작은 수라면 큐에 추가
				// 메모리초과 -> 큐에 중복된 내용이 들어간다.
				if (box[moveX][moveY] != -1 
						&& !visited[moveX][moveY]
						&& (box[moveX][moveY] == 0 || box[moveX][moveY] > box[initX][initY] + 1)) {
					visited[moveX][moveY] = true;
					box[moveX][moveY] = box[initX][initY] + 1;
					q.add(moveX);
					q.add(moveY);
				}
			}
		}
		
	}
	
}
