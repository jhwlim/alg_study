import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #17298. 오큰수
public class Main3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		int[] resultArr = new int[n]; // 오큰수를 가리키는 인덱스를 저장하는 배열
		int ptr = 0;
		
		for (int i = arr.length-1; i >= 0; i--) {
			if (i == arr.length-1) {
				resultArr[i] = -1;
				continue;
			}
			
			if (arr[i] < arr[i+1]) {
				resultArr[i] = i+1;
			} else {
				ptr = resultArr[i+1];
				while (true) {
					if (ptr == -1 || arr[i] < arr[ptr]) {
						resultArr[i] = ptr;
						break;
					} else {
						ptr = resultArr[ptr];
					}
				}
			}
			
		}
		
		for (int i : resultArr) {
			if (i == -1) bw.write(-1 + " ");
			else bw.write(arr[i] + " ");
		}
		
		bw.flush();
		bw.close();

	}

}
