import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #3085. 사탕 게임
public class Main {

	static int max = 1;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
	
		solution(arr);
		bw.write(max+"\n");
		
		bw.flush();
		bw.close();
	}

	static void solution(char[][] arr) {
		char tmp = '0';
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				findRowMax(arr, i);
				findColMax(arr, j);
				
				// (i, j) <-> (i+1, j)
				if (i < arr.length-1 && arr[i][j] != arr[i+1][j]) {
					tmp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = tmp;
					
					findRowMax(arr, i);
					findRowMax(arr, i+1);
					findColMax(arr, j);
					
					arr[i+1][j] = arr[i][j];
					arr[i][j] = tmp;
				}
				
				// (i, j) <-> (i, j+1)
				if (j < arr[i].length-1 && arr[i][j] != arr[i][j+1]) {	
					tmp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = tmp;
					
					findRowMax(arr, i);
					findColMax(arr, j);
					findColMax(arr, j+1);
					
					arr[i][j+1] = arr[i][j];
					arr[i][j] = tmp;				
					
				}
			}
		}
		
	}
	
	static void findRowMax(char[][] arr, int row) {
		int cnt = 1;
		char c = '0';
		
		for (int i = 0; i < arr[row].length; i++) {
			if (c == arr[row][i]) {
				cnt++;
				
			} else {
				if (cnt > max) {
					max = cnt;
				}
				c = arr[row][i];
				cnt = 1;
			}
		}
		
		if (cnt > max) max = cnt;
	}
	
	static void findColMax(char[][] arr, int col) {
		int cnt = 1;
		char c = '0';
		
		for (int i = 0; i < arr.length; i++) {
			if (c == arr[i][col]) {
				cnt++;
			} else {
				if (cnt > max) {
					max = cnt;
				}
				c = arr[i][col];
				cnt = 1;
			}
		}
		
		if (cnt > max) max = cnt;
	}

}
