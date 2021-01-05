import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #10972. 다음 순열
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] str = br.readLine().split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		solution(arr);
		
		bw.flush();
		bw.close();
	}

	static void solution(int[] arr) throws IOException {
		int i = 0;
        
		for (i = arr.length-1; i >= 0; i--) {
			if (isDesc(arr, arr.length-1, i)) {
				continue;
			} else {	
				// arr[i]와 그 이후의 인덱스에서 다음으로 큰 수와 스위치
				switchWithNextNumber(arr, i);
				
				Arrays.sort(arr, i+1, arr.length);
				
				print(arr);
				
				break;
			}
		}
		
		if (i < 0) {
			bw.write(-1+"\n");
		}
		
	}
	
	static boolean isDesc(int[] arr, int rightIdx, int leftIdx) {
		for (int i = rightIdx; i > leftIdx; i--) {
			if (arr[i] > arr[i-1]) {
				return false;
			}
		}		
		return true;
	}
	
	static void switchWithNextNumber(int[] arr, int idx) {
		int nextNum = Integer.MAX_VALUE;
		int nextNumIdx = 0;
		
		for (int i = idx+1; i < arr.length; i++) {
			if (arr[i] > arr[idx] && arr[i] < nextNum) {
				nextNum = arr[i];
				nextNumIdx = i; 
			}
		}
        
		int tmp = arr[nextNumIdx];
		arr[nextNumIdx] = arr[idx];
		arr[idx] = tmp;		
	}
	
	// print array
	static void print(int[] arr) throws IOException {
		
		for (int i : arr) {
			bw.write(i + " ");
		}
		bw.newLine();
	}
}
