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
		
		List<Integer> inputList = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		int max = 0;
		
		while (true) { // O(n)
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			inputList.add(n);		
			if (n > max) max = n;
		}
		
		if (!inputList.isEmpty()) {
			boolean[] arr = new boolean[max]; // not prime number -> true
			
			arr[0] = true; // 1 is not prime number
			
			for (int i = 1; i < arr.length; i++) { // O (n log log n)
				if (!arr[i]) {
					int k = i + 1;
					list.add(k);
					for (int j = 2 * k - 1; j < arr.length; j += k) {
						arr[j] = true;
					}
				} else {
					continue;
				}
			}
			
			for (int n : inputList) { // O (n * n)
				int left = 0;
				int leftV = list.get(left);
				
				while (arr[n - leftV - 1]) {
					leftV = list.get(++left);
				}
				
				bw.write(n + " = " + leftV + " + " + (n - leftV) + "\n");				
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	
}
