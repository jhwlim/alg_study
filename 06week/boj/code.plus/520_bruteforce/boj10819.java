import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #10819. 차이를 최대로
public class Main {
	
	static int max = 0;
	static int[] arr;
	static boolean[] bools;
	static int[] perm;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] str = br.readLine().split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		bools = new boolean[n];
		perm = new int[n];
		
		solution(0);
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
	}
	
	static void solution(int depth) {
		if (depth == arr.length) {
			int sum = 0;
			for (int i = 1; i < perm.length; i++) {
				sum += Math.abs(perm[i] - perm[i-1]);
			}
			if (sum > max) max = sum;
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!bools[i]) {
				perm[depth] = arr[i];
				bools[i] = true;
				solution(depth+1);
				bools[i] = false;
			}
		}
	}
	
}
