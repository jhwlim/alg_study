import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #17087. 숨바꼭질 6
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		String[] str2 = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);
		
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(Integer.parseInt(str2[i]) - s);
		}
		
		
		bw.write(solution(arr) + "\n");
		
		bw.flush();
		bw.close();
	}

	static int solution(int[] arr) {
		int a = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			a = gcd(a, arr[i]);
		}
		
		return a;
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
