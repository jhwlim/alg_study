import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #10971. 외판원 순회 2 : code refactoring (1)
// 발생 가능한 케이스 전부에 대하여 합을 구하여 최소값을 찾기.
// 마지막에 다시 반복문을 사용하여 합을 구하지 않고
// 케이스를 구하는 과정에서 합을 구함. (시간 단축)
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
