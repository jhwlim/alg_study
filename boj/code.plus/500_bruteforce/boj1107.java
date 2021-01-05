import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #1107. 리모컨 ; memory, time is bad -> need to improve!
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine(); // find
		boolean[] arr = new boolean[10];
		Arrays.fill(arr, true);
		
		int num = Integer.parseInt(br.readLine());
		
		if (num > 0) {
			String[] s2 = br.readLine().split(" ");
			
			for (int i = 0; i < s2.length; i++) {
				arr[Integer.parseInt(s2[i])] = false;
			}
		}
		
		bw.write(solution(s, arr)+"\n");
		
		bw.flush();
		bw.close();
	}

	static int solution(String s, boolean[] arr) {
		int n = Integer.parseInt(s);
		int result = Math.abs(n - 100);
		
		if (n == 100) {
			result = 0;
		} else if (!judge(n, arr)) {
			int aroundMin = n-1;
			
			while (aroundMin >= 0 && !judge(aroundMin, arr)) {
				aroundMin--;
			}
            
			if (aroundMin >= 0) {
				int cnt1 = n - aroundMin + String.valueOf(aroundMin).length();
				if (result > cnt1) result = cnt1;
			}
            
            int aroundMax = n+1;
			
			while (aroundMax < 10000000 && !judge(aroundMax, arr)) {
				aroundMax++;
			}
			
			if (aroundMax < 10000000) {
				int cnt2 = aroundMax - n + String.valueOf(aroundMax).length();
				if (result > cnt2) result = cnt2;	
			}
			
		} else {
			int cnt3 = s.length();
			if (result > cnt3) result = cnt3;
		}
		
		return result;
	}
	
	static boolean judge(int n, boolean[] arr) {
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			if (!arr[s.charAt(i) - '0']) {
				return false;
			} 
		}
		return true;
	}
	
}
