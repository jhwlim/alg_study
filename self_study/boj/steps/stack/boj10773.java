import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> s = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (!s.isEmpty()) s.pop();
			} else {
				s.push(x);
			}
			
		}
		
		int sum = 0;
		for (Integer i : s) {
			sum += i;
		}
		bw.write(sum+"\n");
		
		bw.flush();
		bw.close();
		
	}

}

