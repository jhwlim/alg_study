import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// # 11047. 동전 0
public class Main {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] strs = br.readLine().split(" ");
		
		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]);
		
		int[] coins = new int[n];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		bw.write(solution(coins, k) + "\n");
		bw.flush();
		bw.close();
	}

	public static int solution(int[] arr, int sum) {
		
		int totalCnt = 0;
		int cnt = 0;
		
		for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i] > sum) {
				continue;
			}
			cnt = sum / arr[i];
			totalCnt += cnt;
			sum -= cnt * arr[i];
				
		}
		
		return totalCnt;
	}
}
