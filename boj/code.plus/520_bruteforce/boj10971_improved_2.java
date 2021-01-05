import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #10971. 외판원 순회 2 : code refactoring (2)
// 발생 가능한 케이스 전부에 대하여 합을 구하여 최소값을 찾기.
// 케이스를 구하는 과정에서 합을 구함.
// 합을 구하는 과정에서 이전까지의 케이스의 최소값과 비교하여 더 크다면 Pass. (시간 단축)
public class Main {
	
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			String[] s = br.readLine().split(" ");
			
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));			
//		}
		
		boolean[] bools = new boolean[n];
		
		solution(bools, 0, 0, 0);
		
		bw.write(min + "\n");

		bw.flush();
		bw.close();
	}
	
	static int sum = 0;
	
	static void solution(boolean[] bools, int depth, int first, int prev) {
		int cost = 0;
		if (depth == arr.length) {
			cost = arr[prev][first];
			
			if (cost == 0) return;
			else {
				sum += cost;
				if (sum < min) min = sum;
				sum -= cost;
				return;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!bools[i]) {
				if (depth == 0) {
					bools[i] = true;
					first = i;		
					
				} else {
					cost = arr[prev][i];	
					if (cost == 0) continue;
					
					bools[i] = true;
					sum += cost;													
				}
				
				if (sum < min) solution(bools, depth+1, first, i);
				
				sum -= cost;
				bools[i] = false;
			}
		}	
	}
	
}
