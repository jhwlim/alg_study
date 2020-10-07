import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #15655. N과 M (6)
public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		String[] str1 = br.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);
		
		String[] str2 = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str2[i]);
		}
		
		Arrays.sort(arr);
		
		int[] result = new int[m];
		
		sol(arr, result, 0, 0);
		
		bw.flush();
	}
	
	static void sol(int[] arr, int[] result, int start, int idx) throws IOException {
		
		if(idx == result.length) {
			for (int i : result) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			result[idx] = arr[i];
			sol(arr, result, i+1, idx+1);
		}
		
	}
}
