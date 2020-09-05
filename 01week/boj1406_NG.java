import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		Stack<Character> s = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
		}
		
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			solution(s, s2, sc.nextLine());
		}
		
		while (!s2.empty()) {
			s.push(s2.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.size(); i++) {
			sb.append(s.elementAt(i));
		}
		System.out.println(sb);
		
		sc.close();
		
	}

	static void solution(Stack<Character> s, Stack<Character> s2, String cmd) {
		switch (cmd.charAt(0)) {
		case 'L' :
			if (s.size() > 0) s2.push(s.pop());
			break;
		case 'D' :
			if (s2.size() > 0) s.push(s2.pop());
			break;
		case 'B' :
			if (s.size() > 0) s.pop();
			break;
		case 'P' :
			s.push(cmd.charAt(2));
			break;
		}
	}
	
}
