import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// # 2529. 부등호
public class Main {
	
	static String[] signs;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		signs = br.readLine().split(" ");
		
		boolean[] bools = new boolean[10];
		StringBuilder sb = new StringBuilder();
		permutation(bools, 0, sb);
		
		Arrays.fill(bools, false);
		StringBuilder sb2 = new StringBuilder();
		revPermutation(bools, 0, sb2);
		
		bw.write(max+"\n");
		bw.write(min+"\n");
		
		bw.flush();
		bw.close();
	}
	
	static boolean isFind = false;
	static String min;
	
	static void permutation(boolean[] bools, int depth, StringBuilder sb) {
		if (isFind) {
			return;
		}
		
		if (depth == signs.length + 1) {
			min = sb.toString();
			isFind = true;
			return;
		}
		
		for (int i = 0; i < bools.length; i++) {
			if (!bools[i]) {
				if (depth > 0 && !isSignOk(i, sb, depth)) {
					return;
				}
					
				sb.append(i);
				bools[i] = true;
				permutation(bools, depth+1, sb);					
				sb.deleteCharAt(depth);
				bools[i] = false;
			}
		}
	}
	
	static boolean isSignOk(int nextNum, StringBuilder sb, int nowDepth) {
		
		int prevNum = sb.charAt(nowDepth-1) - '0';

		boolean result; 
		
		if (signs[nowDepth-1].equals("<")) {
			result = prevNum < nextNum;
		} else {
			result = prevNum > nextNum;
		}
		
		return result;
	}
	
	static boolean isFind2 = false;
	static String max;
	
	static void revPermutation(boolean[] bools, int depth, StringBuilder sb) {
		if (isFind2) {
			return;
		}
		
		if (depth == signs.length + 1) {
			max = sb.toString();
			isFind2 = true;
			return;
		}
		
		for (int i = bools.length-1; i >= 0; i--) {
			if (!bools[i]) {
				if (depth > 0 && !isSignOk(i, sb, depth)) {
					return;
				}
					
				sb.append(i);
				bools[i] = true;
				revPermutation(bools, depth+1, sb);					
				sb.deleteCharAt(depth);
				bools[i] = false;
			}
		}
		
	}
}
