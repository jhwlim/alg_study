import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #15650. N과 M (2)
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		int[] result = new int[m];
		
		solution(0, 1, result);
		
		bw.flush();
		bw.close();
	}

	static void solution(int depth, int start, int[] result) throws IOException {
		if (depth == result.length) {
			for (int i : result) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}
		
		for (int i = start; i <= n; i++) {
			result[depth] = i;
			solution(depth+1, i+1, result);
		}
		
	}
}
