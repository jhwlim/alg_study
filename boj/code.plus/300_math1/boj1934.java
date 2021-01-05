import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1934. 최소공배수
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			bw.write(solution(Integer.parseInt(s[0]), Integer.parseInt(s[1]))+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static int solution(int n, int m) {
		int a = n;
		int b = m;
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return m * n / a;
	}
	
}
