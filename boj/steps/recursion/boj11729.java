import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
		
		int n = Integer.parseInt(br.readLine());
		
		List<String> result = hanoi(n);
		
		bw.write(result.size()+"\n");
		for (String s : result) {
			bw.write(s + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static List<String> hanoi(int n) throws IOException{
		List<String> result = new ArrayList<>();
		
		solution(n, 1, 3, 2, result);
		
		return result;
	}
	
	// begin의 1 ~ n 요소를 end로 보내기 
	public static void solution(int n, int begin, int end, int mid, List<String> result){
		if (n > 0) {
			solution(n-1, begin, mid, end, result);
			result.add(begin + " " + end);
			solution(n-1, mid, end, begin, result);
		}
	}
	
}
