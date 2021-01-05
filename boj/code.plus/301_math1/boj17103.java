import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// #17103. 골드바흐 파티션
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max) max = arr[i];
		}
		
		for (int i : solution(max, arr)) {
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
	}

	public static int[] solution(int n, int[] arr) {
		int[] resultArr = new int[arr.length];
		boolean[] primeArr = new boolean[n+1];
		Arrays.fill(primeArr, true);
		List<Integer> primeList = new ArrayList<Integer>();
		
		for (int i = 2; i < primeArr.length; i++) {
			if (primeArr[i]) {
				primeList.add(i);
				for (int j = 2; i * j <= n; j++) {
					primeArr[i * j] = false;
				}
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; primeList.get(j) <= arr[i] / 2; j++) {
				if (primeArr[arr[i] - primeList.get(j)]) cnt++;
			}
			resultArr[i] = cnt;
			cnt = 0;
		}
		
		return resultArr;
	}
}
