import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #10971. 외판원 순회 2
// 발생 가능한 케이스 전부에 대하여 합을 구하여 최소값을 찾기.
// 마지막에 다시 반복문을 사용하여 합을 구함.
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
		int[] result = new int[n];
		
		solution(bools, 0, result);
		
		bw.write(min + "\n");

		bw.flush();
		bw.close();
		
	}
	
	static void solution(boolean[] bools, int depth, int[] result) {
		if (depth == arr.length) {
//			System.out.println(Arrays.toString(result));
			int sum = 0;
			int cost = 0;
			for (int i = 0; i < result.length; i++) {
				if (i == result.length-1) cost = arr[result[i]][result[0]];
				else cost = arr[result[i]][result[i+1]];
				
				if (cost == 0) return;
				else sum += cost;
			}
			if (sum < min) min = sum;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!bools[i]) {
				result[depth] = i;
				bools[i] = true;
				solution(bools, depth+1, result);
				bools[i] = false;
			}
		}	
	}
	
}
