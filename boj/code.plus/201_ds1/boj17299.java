import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// #17299. 오등큰수
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] cntArr = new int[1000000+1];
		String[] s = br.readLine().split(" ");
		
		int[] inArr = new int[n];
		for (int i = 0; i < inArr.length; i++) {
			inArr[i] = Integer.parseInt(s[i]);
			cntArr[inArr[i]]++;
		}
		
		int[] outArr = new int[n];
		int ptr = 0;
		
		for (int i = inArr.length-1; i >= 0; i--) {
			if (i == inArr.length-1) {
				outArr[i] = -1;
				continue;
			}
			
			if (cntArr[inArr[i]] < cntArr[inArr[i+1]]) {
				outArr[i] = i+1;
			} else {
				ptr = outArr[i+1];
				while (ptr != -1) {
					if (cntArr[inArr[i]] < cntArr[inArr[ptr]]) {
						outArr[i] = ptr;
						break;
					} else {
						ptr = outArr[ptr];
					}
				}
				if (ptr == -1) outArr[i] = ptr;
			}
		}
		
		for (int i : outArr) {
			if (i == -1) bw.write(-1 + " ");
			else bw.write(inArr[i] + " ");
		}
		
		bw.flush();
		bw.close();
		
	}

}
