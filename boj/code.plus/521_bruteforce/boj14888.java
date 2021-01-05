import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

// # 14888. 연산자 끼워넣기
public class Main {
	
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] numbersStr = br.readLine().split(" ");
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(numbersStr[i]);
		}
		
		String[] operatorsStr = br.readLine().split(" ");
		int[] operators = new int[4]; // 0 : +, 1 : -, 2 : *, 3 : /
		int operator = 0;
		int maxDepth = 0;
		for (int i = 0; i < operators.length; i++) {
			operator = Integer.parseInt(operatorsStr[i]);
			maxDepth += operator;
			operators[i] = operator;
		}
			
		int[] results = new int[maxDepth];	
		permutation(operators, maxDepth, results, 0);
	
		bw.write(max+"\n");
		bw.write(min+"\n");
		
		bw.flush();
		bw.close();
	}
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void permutation(int[] operators, int maxDepth, int[] results, int depth) {
		
		if (depth == maxDepth) {
			int result = getResult(results);	
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for (int i = 0; i < operators.length; i++) {
			if (operators[i] != 0) {
				results[depth] = i;
				operators[i]--;
				
				permutation(operators, maxDepth, results, depth+1);
				operators[i]++;
			}
		}
		
	}
	
	static int getResult(int[] results) {
		
		int a = numbers[0];
		int b = 0;
		int index = 1;
		int resultIdx = 0;
		
		while (index < numbers.length) {
			b = numbers[index++];
			
			int operator = results[resultIdx++];
			switch (operator) {
			case 0 :
				a += b;
				break;
			case 1 :
				a -= b;
				break;
			case 2 :
				a *= b;
				break;
			case 3 :
				a /= b;
				break;
			}
		}
		
		return a;
	}
}



