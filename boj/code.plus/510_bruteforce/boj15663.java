import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #15663. N과 M (9)
public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int n;
	static int m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		String[] str1 = br.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		m = Integer.parseInt(str1[1]);
		
		String[] str2 = br.readLine().split(" ");
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str2[i]);
		}
		
		Arrays.sort(arr);
		
		int[] result = new int[m];
		boolean[] bools = new boolean[n];
		
		solution(0, bools, result);
		
		bw.flush();
		bw.close();
	}
	
	static void solution(int depth, boolean[] bools, int[] result) throws IOException {
		if (depth == m) {
			for (int i : result) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!bools[i]) {		
				result[depth] = arr[i];
				bools[i] = true;
				solution(depth+1, bools, result);
				bools[i] = false;
				
				if (i < arr.length-1) {
					while (arr[i] == arr[i+1]) {
						i++;
						if (i >= arr.length-1) break;
					}
				}
			}
		}
		
	}
	
}
