import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// #2667. 단지번호붙이기
// dfs
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					visited[i][j] = true;
				}
				
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if (visited[i][j]) {
					visited[i][j] = false;
					count = 1;
					
					dfs(i, j, visited);
					
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		
		bw.write(list.size()+"\n");
		for (int i : list) {
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
	}

	static int[][] move = {
			{-1, 0},
			{1, 0},
			{0, 1},
			{0, -1}
	};
	
	static void dfs(int x, int y, boolean[][] visited) {
		int moveX = 0;
		int moveY = 0;
		
		for (int i = 0; i < move.length; i++) {
			moveX = x + move[i][0];
			moveY = y + move[i][1];
			
			if (moveX < 0 || moveX > visited.length-1) {
				continue;
			}
			
			if (moveY < 0 || moveY > visited.length-1) {
				continue;
			}
			
//			System.out.println(moveX + ", " + moveY);
			if (visited[moveX][moveY]) {
				visited[moveX][moveY] = false;
				count++;
				dfs (moveX, moveY, visited);
			}
				
			
		}
		
	}
	
	
}
