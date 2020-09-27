import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #2745. 진법 변환
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		
		bw.write(solution(s[0], Integer.parseInt(s[1]))+"\n");
		
		bw.flush();
		bw.close();
	}

	public static long solution(String b, int n) {
		long result = 0;
		int m = 0;
		
		for (int i = 0; i < b.length(); i++) {
			if ((int) b.charAt(i) >= 65 && (int) b.charAt(i) <= 64+26) {
				m = (int) b.charAt(i) - 55;
			} else {
				m = (int) b.charAt(i) - 48;
			}
			
			result += (long) m * Math.pow(n, b.length() - i - 1);
		}
		
		return result;
	}
	
}
