import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #9095. 1,2,3 더하기
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i : solution(arr)) {
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}

	static int[] solution(int[] arr) {
		int max = 4;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) max = arr[i];
		}
		
		int[] maxArr = new int[max+1];
		int[] resultArr = new int[arr.length];
		
		// 초기값
		maxArr[1] = 1;
		maxArr[2] = 2;
		maxArr[3] = 4;
		
		for (int i = 4; i < maxArr.length; i++) {
			maxArr[i] = maxArr[i-3] + maxArr[i-2] + maxArr[i-1];
		}
		
		for (int i = 0; i < resultArr.length; i++) {
			resultArr[i] = maxArr[arr[i]];
		}
		
		return resultArr;
	}

}
