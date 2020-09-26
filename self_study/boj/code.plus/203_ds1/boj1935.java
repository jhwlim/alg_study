import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// #1935. 후위 표기식2
public class Main {
	
	/*
	 * 2 * 3 = 6
	 * 1 + 6 = 7
	 * 4 / 5 = 0.8
	 * 7 - 0.8 = 6.2
	 */
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		bw.write(solution(str, arr));
		
		bw.flush();
		bw.close();
		
	}
	
	static String solution(String str, int[] arr) {
		String result = null;
		
		Stack<Double> stack = new Stack<>();
		char c = '0';
		double n1 = 0;
		double n2 = 0;
		
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
//			System.out.println(stack);
			if ((int) c >= 64+1 && (int) c <= 64+26) { // A~Z
				stack.push((double) arr[(int) c - 65]);
			} else {
				n1 = stack.pop();
				n2 = stack.pop();
				switch (c) {
				case '+' :
					stack.push(n2+n1);
					break;
				case '-' :
					stack.push(n2-n1);
					break;
				case '*' :
					stack.push(n2*n1);
					break;
				case '/' :
					stack.push(n2/n1);					
					break;
				case '%' :
					stack.push(n2%n1);
					break;
					
				}
			}
		}
//		System.out.println(stack);
		
		result = String.format("%.2f", stack.pop());
		
		return result;
	}
	
}
