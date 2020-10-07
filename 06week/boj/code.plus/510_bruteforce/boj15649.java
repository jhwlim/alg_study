import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #15649. N과 M (1)
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	
	public static void main(String[] args) throws IOException {
		String[] str1 = br.readLine().split(" ");
		
		n = Integer.parseInt(str1[0]);
		
		int[] result = new int[Integer.parseInt(str1[1])];
		boolean[] bools = new boolean[n+1];
		
		solution(bools, 1, result);
		
		bw.flush();
	}
	
	static void solution(boolean[] bools, int nowLevel, int[] result) throws IOException {
		if (nowLevel > result.length) {
			for (int i : result) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!bools[i]) {
				result[nowLevel-1] = i;
				bools[i] = true;
				solution(bools, nowLevel+1, result);
				bools[i] = false;
			}
		}
		
	}
}
