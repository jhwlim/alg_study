import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #9613. GCD 합
// gcd의 합을 구할 때, 해당 변수의 데이터타입은 long.
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int len = Integer.parseInt(s[0]);
			int[] arr = new int[len];
			
			for (int j = 0; j < len; j++) {
				arr[j] = Integer.parseInt(s[j+1]);
			}
			
			bw.write(solution(arr)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static long solution(int[] arr) {
		long sum = 0;
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				sum += gcd(arr[i], arr[j]);
			}
		}
		
		return sum;
	}
	
	static int gcd(int a, int b) {		
		int tmp = 0;
		while (b != 0) {
			tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
	
	
}
