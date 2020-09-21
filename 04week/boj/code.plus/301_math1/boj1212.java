import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(solution(sc.nextLine()));
		
		sc.close();
	}
	
	static String octToBinary(int n) {
		Stack<Integer> s = new Stack<>();
		int m = n;
		
		while (m != 0) {
			s.push(m % 2);
			m = m / 2;
		}
		StringBuilder sb = new StringBuilder();
		int stackSize = s.size();
		
		for (int i = 0; i < 3 - stackSize; i++) {
			sb.append("0");
		}
	
		
		while (!s.isEmpty()) {
			sb.append(s.pop());			
		}
		
		
		
		return sb.toString();
			
	}
	
	static String solution(String n) {
		
		String m = n;
		StringBuilder sb = new StringBuilder();
		
		if (n.equals("0")) {
			sb.append("0");
			return sb.toString();
		}
        
		for (int i = 0; i < m.length(); i++) {
			sb.append(octToBinary((int) m.charAt(i) - 48));
		}
		
		int start = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '0') start++;
			else break;
		}
		
		return sb.substring(start).toString();
	}
	
	
}
