import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// #10973. 이전 순열
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * 주어진 배열의 뒤에서 부터 오름차순으로 정렬되어 있는지 확인한다.
		 * 오름차순이라면 pass, 아니라면 그 지점(인덱스)을 기준으로 왼쪽은 그대로 출력된다.
		 * 그리고, 그 이하의 배열에서 그 인덱스의 값보다 한 단계 작은 값이 다음으로 와야 하고,
		 * 그 이후부터는 그 값을 제외하고, 그 이하의 배열을 내림차순으로 들어간다.  
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] inArr = new int[n];
		
		String[] str = br.readLine().split(" ");
		
		for(int i = 0; i < inArr.length; i++) {
			inArr[i] = Integer.parseInt(str[i]);
		}
		
		int[] tmp;
		int i = 0;
		
		for (i = inArr.length-2; i >= 0; i--) {
			if (inArr[i] < inArr[i+1]) continue;
			
			tmp = new int[inArr.length-i];
			
			for (int j = i; j < inArr.length; j++) {
				tmp[j-i] = inArr[j];
			}
			
			Arrays.sort(tmp);
			
			for (int j = 0; j < i; j++) {
				bw.write(inArr[j] + " ");
			}
			
			int idx = 0;
			for (int j = 0; j < tmp.length; j++) {
				if (tmp[j] == inArr[i]) {
					idx = j-1;
					break;
				}
			}
			
			bw.write(tmp[idx] + " ");
			
			for (int j = tmp.length-1; j >= 0; j--) {
				if (j != idx) bw.write(tmp[j] + " ");
			}
			
			break;
		}
		
		if (i == -1) bw.write("-1");
		
		bw.flush();
		bw.close();
	}

	
}
