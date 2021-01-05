import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		bw.write(String.valueOf(solution(arr)));
		
		bw.flush();
		bw.close();
	}
	
	// O(n^2)
	static int solution(int[] arr) {
		int max = 1;
		
		// O(n)
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) max = arr[i];
		}
		
		// O(n^2)
		List<Integer> l = findPrimeNum(max);
		
		int cnt = 0;
		
		// O(n)
		for (int i = 0; i < arr.length; i++) {
			if (l.indexOf(arr[i]) >= 0) cnt++;
		}
		
		return cnt;
	}
	
	// O(n^2)
	static List<Integer> findPrimeNum(int n) {
		List<Integer> l = new ArrayList<Integer>();
		
		for (int i = 2; i <= n; i++) {
			boolean flag = false;
			
			if (i == 2) {
				l.add(2);
				continue;
			}
			
			for (int j : l) {
				if (i % j == 0) {
					flag = true; // i is prime number.
					break;
				} 
			}
			
			if (!flag) l.add(i);
		}
		
			
		return l;
	}
}
