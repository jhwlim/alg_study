import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #6603. 로또
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		while (true) {
			String[] s = br.readLine().split(" ");
			int k = Integer.parseInt(s[0]);
			if (k == 0) break;
			else {
				int[] arr = new int[k];
				
				for (int i = 0; i < k; i++) {
					arr[i] = Integer.parseInt(s[i+1]);
				}
				
				int limit = 6;
				int[] result = new int[limit];
				
				solution(arr, 0, 0, limit, result);
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static void solution(int[] arr, int depth, int arrIdx, int limit, int[] result) throws IOException {
		if (depth == limit) {
			for (int i : result) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}
		
		for (int i = arrIdx; i < arr.length; i++) {
			result[depth] = arr[i];	
			solution(arr, depth+1, i+1, limit, result);
		}
	}
	
	
}
