import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #6064. 카잉달력 (by 중국인의 나머지정리)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] s;
		
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			bw.write(solution(Integer.parseInt(s[0]),
							  Integer.parseInt(s[1]),
							  Integer.parseInt(s[2]),
							  Integer.parseInt(s[3]))+"\n");
		}
		
		bw.flush();
		bw.close();
	}

	static int solution(int m, int n, int x, int y) {
		x -= 1;
		y -= 1;
		
		int k = x;
		int lcm = lcm(m, n);
		
		for (int i = 0; i < lcm / m; i++) {
			if (k % n == y) break;
			else k += m;
		}
		
		return (k % n == y) ? k + 1 : -1;
	}
	
	// 최소공배수
	static int lcm(int x, int y) {
		int a = x;
		int b = y;
		int tmp = 0;
		
		while (b != 0) {
			tmp = b;
			b = a % b;
			a = tmp;
		}
		
		return x * y / a;
	}
	
}
