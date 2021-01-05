import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1476. 날짜 계산
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
		e = e % 15;
		m = m % 19;
		
		int i = s;
		
		while (true) {
			if (i % 15 == e && i % 19 == m) break;
			i += 28;
		}
		
		return i;
	}
}
