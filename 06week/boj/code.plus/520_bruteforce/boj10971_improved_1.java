import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #10971. 외판원 순회 2 : code refactoring (1)
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
	
	static int sum = 0;
	
	static void solution(boolean[] bools, int depth, int[] result) {
		int cost = 0;
		if (depth == arr.length) {
			cost = arr[result[depth-1]][result[0]];
			if (cost == 0) return;
			else {
				sum += cost;
				if (sum < min) min = sum;
//				System.out.println(Arrays.toString(result));
//				System.out.println(sum);
				sum -= cost;
				return;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!bools[i]) {
				result[depth] = i;
				bools[i] = true;
				
				cost = 0;
				if (depth > 0) {
					cost = arr[result[depth-1]][result[depth]];
					if (cost == 0) {
						bools[i] = false;
						continue;
					}
					else sum += cost;
				} 
                
				solution(bools, depth+1, result);
				
				sum -= cost;
				bools[i] = false;
			}
		}	
	}
	
}
