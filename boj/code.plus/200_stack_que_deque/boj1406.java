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
		
		String str = br.readLine();
		Stack<Character> s = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			solution(s, s2, br.readLine());
		}
		
		while (!s.empty()) {
			s2.push(s.pop());
		}
		
		while (!s2.empty()) {
			bw.write(s2.pop());	
		}
			
		
		bw.flush();
		bw.close();
	}

	static void solution(Stack<Character> s, Stack<Character> s2, String cmd) {
		switch (cmd.charAt(0)) {
		case 'L' :
			if (!s.empty()) s2.push(s.pop());
			break;
		case 'D' :
			if (!s2.empty()) s.push(s2.pop());
			break;
		case 'B' :
			if (!s.empty()) s.pop();
			break;
		case 'P' :
			s.push(cmd.charAt(2));
			break;
		}
	}
	
}
