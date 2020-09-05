import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			solution(sc.next());
		}
		
		sc.close();
		
	}
	
	static void solution(String s) {
		int cnt = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') cnt++;
			else if (s.charAt(i) == ')') cnt--;
			
			if (cnt < 0) break;
		}
		
		System.out.println((cnt == 0) ? "YES" : "NO");
	}
	
}
