import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// #2089. -2진수
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(solution(Integer.parseInt(br.readLine()))+"\n");
		
		bw.flush();
		bw.close();
	
	}
	
	/*
	 * X = (-2) * Q + R
	 * R = X + 2 * Q ; R = 0 (X가 짝수) or 1 (X가 홀수)
	 * Q = (R - X) / 2
	 * 예) n = 7 -> 11011
	 * X  R  Q
	 * 7  1 -3
	 * -3 1  2
	 * 2  0 -1
	 * -1 1  1
	 * 1  1  0 (종료)
	 */
	static String solution(int n) {
		if (n == 0) return "0";
		
		int q = 0;
		int r = 0;
		Stack<Integer> stack = new Stack<>();
		
		while (n != 0) {
			// System.out.println("n : " + n);
			if (n % 2 == 0) r = 0;
			else r = 1;
			q = (r - n) / 2;
			stack.push(r);
			n = q;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
}
