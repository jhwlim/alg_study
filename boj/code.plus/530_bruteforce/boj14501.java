import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// # 14501. 퇴사
public class Main {
	
	public static int n;
	public static int[] tArr; // 기간
	public static int[] pArr; // 받을 수 있는 금액
	
	public static final int TIME = 0;
	public static final int PAY = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
	
		tArr = new int[n];
		pArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			String[] strs = br.readLine().split(" ");
			tArr[i] = Integer.parseInt(strs[TIME]);
			pArr[i] = Integer.parseInt(strs[PAY]);
		}
		
		checkCases(0, 0);
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
	
	static int max = Integer.MIN_VALUE;
	
	public static void checkCases(int now, int result) {
		if (now >= n) {
			max = Math.max(max, result);
			return;
		}
		
		for (int i = now; i < n; i++) {
			if (i + tArr[i] <= n) {
				result += pArr[i];				
				checkCases(i + tArr[i], result);
				result -= pArr[i];				
			} else {
				checkCases(i + tArr[i], result);
			}
			
		}
	}
	
	
}
