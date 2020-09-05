import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] iArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			iArr[i] = sc.nextInt();
		}
		
//		int[] iArr = {4, 3, 6, 8, 7, 5, 2, 1};
//		int[] iArr = {1, 2, 5, 3, 4};

		solution(iArr);
		
		sc.close();
		
	}

	static void solution(int[] arr) {
		StringBuilder result = new StringBuilder();
		
		Stack<Integer> s = new Stack<>();
		int num = 1;
		
		
		for (int i = 0; i < arr.length; i++) {
			if (s.empty()) {
				s.add(num++);
				result.append("+\n");
			}
			
			while (arr[i] > s.peek()) {
				s.add(num++);
				result.append("+\n");
			}
			
			if(arr[i] == s.peek()) {
				s.pop();
				result.append("-\n");
			} else { 
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(result);
	}
	
	
	
}
