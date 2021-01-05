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
		
		String[] s = br.readLine().split(" ");
		
		int startRange = Integer.parseInt(s[0]);
		int endRange = Integer.parseInt(s[1]);
		
		findPrimeNum(startRange, endRange);

		
	}

	// O(n * lg(n))
	static void findPrimeNum(int min, int n) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		List<Integer> l = new ArrayList<Integer>();
		
		for (int i = 2; i <= n; i++) {
			boolean flag = false;

			if (i == 2) {
				l.add(2);
			}
			
			for (int j = 0; l.get(j) * l.get(j) <= i; j++) {
				if (i % l.get(j) == 0) {
					flag = true; // i is prime number.
					break;
				}
			}

			if (!flag) {
				l.add(i);
				if (i >= min) bw.write(i+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
