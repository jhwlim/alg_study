import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #4963. 섬의 개수
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String[] str = br.readLine().split(" ");
			
			int w = Integer.parseInt(str[0]);
			int h = Integer.parseInt(str[1]);
			
			if (w == 0 && h == 0) break;
			
			int cnt = 0;
			
			boolean[][] arr = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				String[] str2 = br.readLine().split(" ");
				
				for (int j = 0; j < w; j++) {
					if (str2[j].equals("1")) {			
						arr[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j]) {
						dfs(arr, i, j, h, w);
						cnt++;
					}
				}
			}
		
			bw.write(cnt+"\n");
		}
		
		bw.flush();
		bw.close();
	}

	static void dfs(boolean[][] arr, int x, int y, int h, int w) {
		
		// 방문 check
		arr[x][y] = false;
		
		if (x+1 < h && arr[x+1][y]) dfs(arr, x+1, y, h, w); // 세로 아래
		if (y+1 < w && arr[x][y+1]) dfs(arr, x, y+1, h, w); // 가로 오른쪽
		if (x-1 >= 0 && arr[x-1][y]) dfs(arr, x-1, y, h, w); // 세로 위
		if (y-1 >= 0 && arr[x][y-1]) dfs(arr, x, y-1, h, w); // 가로 왼쪽
				
		if (x+1 < h && y+1 < w && arr[x+1][y+1]) dfs(arr, x+1, y+1, h, w); // 오른쪽 아래 대각선
		if (x+1 < h && y-1 >= 0 && arr[x+1][y-1]) dfs(arr, x+1, y-1, h, w); // 왼쪽 아래 대각선
		if (x-1 >= 0 && y+1 < w && arr[x-1][y+1]) dfs(arr, x-1, y+1, h, w); // 오른쪽 위 대각선
		if (x-1 >= 0 && y-1 >= 0 && arr[x-1][y-1]) dfs(arr, x-1, y-1, h, w); // 왼쪽 위 대각선
		
		return;
	}
	
}
