import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #2309. 일곱 난쟁이
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[9];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i : solution(arr)) {
			bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int[] solution(int[] arr) {
		int[] resultArr = new int[7];
		int i = 0;
		int j = 1;
		int sum = 0;
		
		for (int k = 0; k < arr.length; k++) {
			sum += arr[k];
		}
		
		int tmp = 0;
		int tmp2 = 0;
		boolean flag = false;
		
		for (i = 0; i < arr.length-1; i++) {
			tmp = sum;
			tmp -= arr[i];
			
			if (tmp <= 100) continue;
			for (j = i + 1; j < arr.length; j++) {
				tmp2 = tmp;
				tmp2 -= arr[j];
				if (tmp2 == 100) {
					flag = true;
					break;
				}
			}
			if (flag) break;
		}
		
		int idx = 0;
		for (int k = 0; k < arr.length; k++) {
			if (k == i || k == j) continue;
			else resultArr[idx++] = arr[k];
		}
		
		Arrays.sort(resultArr);
		
		return resultArr;
	}
	
}
