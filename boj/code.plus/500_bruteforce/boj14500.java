import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// # 14500. 테트로미노
public class Main {

	static int row;
	static int col;

	static int[][] arr;

	public static int[][] move = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};

	public static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");

		row = Integer.parseInt(str[0]);
		col = Integer.parseInt(str[1]);

		arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			String[] str2 = br.readLine().split(" ");
			for (int j = 0; j < str2.length; j++) {
				arr[i][j] = Integer.parseInt(str2[j]);
			}
		}

		solution();

		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}

	public static void solution() {
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				visited[i][j] = true;

				checkCase(j, i, visited, arr[i][j], 1);		

				visited[i][j] = false;
				
				checkCase2(j, i);
			}
		}
	}


	public static void checkCase(int nowX, int nowY, boolean[][] visited, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(sum, max);

			return;
		}

		int moveX = 0;
		int moveY = 0;

		for (int i = 0; i < move.length; i++) {
			moveX = nowX + move[i][0];
			moveY = nowY + move[i][1];

			if (isPath(moveX, moveY) 
					&& !visited[moveY][moveX]) {
				visited[moveY][moveX] = true;

				checkCase(moveX, moveY, visited, sum + arr[moveY][moveX], depth+1);

				visited[moveY][moveX] = false;
			}
		}

	}

	public static boolean isPath(int x, int y) {
		if (x >= 0 && x < col
				&& y >= 0 && y < row) {
			return true;
		}

		return false;
	}

	// ㅏ, ㅗ, ㅓ, ㅜ
	public static void checkCase2(int nowX, int nowY) {
		int sum = 0;

		int moveX = 0;
		int moveY = 0;
		boolean flag = true;

		for (int i = 0; i < move.length; i++) {
			sum = arr[nowY][nowX];
			flag = true;

			for (int j = 0; j < move.length; j++) {
				if (i != j) {
					moveX = nowX + move[j][0];
					moveY = nowY + move[j][1];
					if (isPath(moveX, moveY)) {
						sum += arr[moveY][moveX];
					} else {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				max = Math.max(sum, max);
			}
		}

	}

}
