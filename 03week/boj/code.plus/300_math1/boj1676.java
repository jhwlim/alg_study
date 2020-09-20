import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #1676. 팩토리얼 0의 개수
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(solution(n)+"");
		
		bw.flush();
		bw.close();
		
	}
	
	static int solution(int n) {
		int cnt2 = 0;
		int cnt5 = 0;
		
		int n2 = 2;
		
		while (n2 < n) {
			cnt2 += n / n2;
			n2 *= 2;
		}
		
		int n5 = 5;
		while (n5 < n) {
			cnt5 += n / n5;
			n5 *= 5;
		}
		return (cnt2 < cnt5) ? cnt2 : cnt5;
	}
	
}
