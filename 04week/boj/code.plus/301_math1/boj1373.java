import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// #1373. 2진수 8진수
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(solution(br.readLine()));
		
		bw.flush();
		bw.close();
	}

	static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> sbStack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			stack.push((int)s.charAt(i) - 48);
		}
		
//		System.out.println(stack);
		int m = 0;
		
		while (!stack.isEmpty()) {
			for (int i = 1; i < 8; i *= 2) {
				m += i * stack.pop();
				if (stack.isEmpty()) break;
			}
			sbStack.push(m);
			m = 0;
		}
//		System.out.println(sbStack);
		
		while (!sbStack.isEmpty()) {
			sb.append(sbStack.pop());
		}
		
		return sb.toString();
	}
	
	
}
