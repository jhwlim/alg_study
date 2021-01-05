import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		solution(sc.nextInt(), sc.nextInt());
		
		sc.close();
		
	}
	
	static void solution(int n, int m) {
		int a = n;
		int b = m;
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		System.out.println(a);
		
		System.out.println(n * m / a);
	}
	
}
