import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1476. 날짜 계산 (by 중국인의 나머지정리)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		
		bw.write(solution(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]))+"\n");
		
		bw.flush();
		bw.close();
	}

	static int solution(int e, int s, int m) {
		e -= 1;
		s -= 1;
		m -= 1;
		int n = s;
		
		for (int i = 0; i < 15; i++) {
			if (n % 15 == e) break;
			else n += 28;
		}
		
		for (int i = 0; i < 28; i++) {
			if (n % 19 == m) break;
			else n += 28 * 15;
		}
		return 1 + n % (15 * 28 * 19);
	}
}
