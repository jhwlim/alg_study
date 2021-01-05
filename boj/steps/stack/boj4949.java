import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String s = br.readLine();
			if (s.charAt(0) == '.') break; // 반복문 종료조건
			bw.write(solution(s));
			bw.newLine();
			
		}
		
		bw.flush();
		bw.close();
	}

	static String solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[') {
				stack.push(s.charAt(i));
				continue;
			}
			if (c == ')' ) {
				if (stack.isEmpty()) return "no";
				else {
					if (stack.pop() == '(') continue;
					else return "no";
				}
			}
			if (c == ']') {
				if (stack.isEmpty()) return "no";
				else {
					if (stack.pop() == '[') continue;
					else return "no";
				}
			}
		}
		
		return (stack.isEmpty() ? "yes" : "no");
	}
	
}
