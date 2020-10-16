import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #15666. N과 M (12)
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		String[] str1 = br.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);
		
		arr = new int[n];
		String[] str2 = br.readLine().split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str2[i]);
		}
	
		Arrays.sort(arr);
		
		int[] result = new int[m];
		
		solution(0, result);
		
		bw.flush();
		bw.close();
	}

	static void solution(int depth, int[] result) throws IOException {
		if (depth == result.length) {
			printArr(result);
			return;
		}
		int before = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != before) {
				if (depth > 0 && result[depth-1] > arr[i]) continue;
				before = arr[i];
                
				result[depth] = arr[i];
				
				solution(depth+1, result);
			} else {
				continue;
			}
		}
		
		return;
	}
	
	static void printArr(int[] arr) throws IOException {
		for (int i : arr) {
			bw.write(i + " ");
		}
		bw.newLine();
		return;
	}
	
}
