import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// # 14889. 스타트와 링크
public class Main {
	
	public static int n;
	public static int[][] arr;
	
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			String[] strs = br.readLine().split(" ");
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		solution();
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static void solution() {
		
		// n개 중 n/2개 뽑는 케이스 확인 - 재귀
		int[] result = new int[n/2];
		
		checkCase(0, result, 0);
		
	}
	
	public static void checkCase(int start, int[] result, int depth) {
		if (depth == result.length) { // 재귀 종료 조건
			// 생성된 조합 케이스를 이용하여 능력치를 계산
			min = Math.min(min, Math.abs(calcStats(result) - calcStats(findOppositeCase(result))));
			return;
		}
		
		for (int i = start; i < n; i++) {
			result[depth] = i;
			checkCase(i+1, result, depth+1);
		}
		
	}
	
	public static int[] findOppositeCase(int[] originCase) {
		int[] oppositeCase = new int[n/2];
		int index = 0;
		int originIndex = 0;
		
		for (int i = 0; i < n; i++) {
			if (originIndex < originCase.length && i == originCase[originIndex]) {
				originIndex++;
				continue;
			} else {
				oppositeCase[index++] = i;
			}
		}
		
		return oppositeCase;
	}
	
	public static int calcStats(int[] numbers) {
		
		int result = 0;
		
		int n = 0;
		int m = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			n = numbers[i];
			for (int j = 0; j < numbers.length; j++) {
				m = numbers[j];
				if (m != n) {
					result += arr[n][m];
				}
			}
		}
		
		return result;
	}
	
	
}




