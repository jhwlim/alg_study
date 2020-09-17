import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		long n = Long.parseLong(s[0]);
		long m = Long.parseLong(s[1]);
		
		long cnt2 = cntK(n, 2) - cntK(m, 2) - cntK(n-m, 2);
		long cnt5 = cntK(n, 5) - cntK(m, 5) - cntK(n-m, 5);
		
		System.out.println((String.valueOf((cnt2 < cnt5) ? cnt2 : cnt5)));
		
	}
	
	// n!의 소인수분해 했을 때, k의 개수
	static long cntK (long n, long k) {
		long cnt = 0;
		long i = k;
		
		while (n >= i) {
			cnt += n / i;
			i *= k;
		}
		
		return cnt;
	}
	
	
}
