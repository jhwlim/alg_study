import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
			
		for (int i = 0; i < n; i++) {
			System.out.println(sol(sc.nextLine()));
		}
		
		sc.close();
	}
	
	static StringBuilder sol(String s) {
		String[] sArr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for (String sa : sArr) {
			for (int i = sa.length()-1; i >= 0; i--) {
				sb.append(sa.charAt(i));
			}
			sb.append(" ");
		}

		return sb;
	}

}
