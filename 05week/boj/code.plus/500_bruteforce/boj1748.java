import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1748. 수 이어 쓰기 1
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(solution(Integer.parseInt(br.readLine()))+"\n");
		
		bw.flush();
		bw.close();
	}

	static int solution(int n) {
		int cnt = 0;
		int left = 0;
		int right = 0;
		
		for (int i = 1; i <= (int) Math.log10(n)+1; i++) {
			left = (int) Math.pow(10, i-1);
			if (i == (int) Math.log10(n) + 1) {
				right = n;
			} else {
				right = (int) Math.pow(10, i) - 1;				
			}
			cnt += (right - left + 1) * i;
		}
		
		return cnt;
	}
	
}
