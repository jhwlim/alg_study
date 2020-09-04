import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		IntStack s = new IntStack(n);
		
		for (int i = 0; i < n; i++) {
			switch (sc.next()) {
				case "push" : 
					s.push(sc.nextInt());
					break;
				case "pop" : 
					System.out.println(s.pop());
					break;
				case "size" : 
					System.out.println(s.size());
					break;
				case "empty" : 
					System.out.println(s.empty());
					break;
				case "top" : 
					System.out.println(s.top());
					break;
			}
			
		}
		
		sc.close();
		
	}
	
	static class IntStack {
		int ptr;
		int max;
		int[] stackArr;
		
		public IntStack(int max) {
			this.max = max;
			ptr = 0;
			stackArr = new int[max];
		}
		
		public void push(int x) {
			stackArr[ptr++] = x;
		}
		
		public int pop() {
			return (ptr > 0) ? stackArr[--ptr] : -1;
		}
		
		public int size() {
			return ptr;
		}
		
		public int empty() {
			return (ptr == 0) ? 1 : 0;
		}
		
		public int top() {
			return (ptr > 0) ? stackArr[ptr - 1] : -1;
		}
	}
	
	
	
}
