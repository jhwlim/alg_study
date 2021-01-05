import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// # 1977. 알파벳
public class Main {
	
	public static char[][] arr;
	public static int r;
	public static int c;
	
	public static int[][] move = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	
	public static int max = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		
		arr = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		solution();
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void solution() {
		boolean[] visited = new boolean[26];
		StringBuilder sb = new StringBuilder();
		
		sb.append(arr[0][0]);
		visited[arr[0][0] - 'A'] = true;
		checkCases(0, 0, visited, sb);
	}
	
	
	public static void checkCases(int nowX, int nowY, boolean[] visited, StringBuilder sb) {
		
		int moveX = 0;
		int moveY = 0;
		char c = '0';
		
		for (int i = 0; i < move.length; i++) {
			moveX = nowX + move[i][0];
			moveY = nowY + move[i][1];
			if (isPath(moveX, moveY)) {
				c = arr[moveY][moveX];
				if (!visited[c - 'A']) {
					visited[c - 'A'] = true;
					sb.append(c);
					max = Math.max(max, sb.length());
					
					checkCases(moveX, moveY, visited, sb);
					
					visited[c - 'A'] = false;
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
	}
	
	
	public static boolean isPath(int x, int y) {
		
		if (x < 0 || x >= c) {
			return false;
		}
		
		if (y < 0 || y >= r) {
			return false;
		}
		
		return true;
	}
	
}
