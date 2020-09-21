import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// #1212. 8진수 2진수
// 메모리 및 실행시간 개선
// 기존의 octToBinary() 메서드를 solution() 메서드 내부로 통합함. -> octToBinary() 메서드 내부에서 사용하던 객체를 사용하지 않음.
// 추가로, 반복문 내부에서 계속 변수를 선언하지 않고, 변수를 하나 선언하고 그 변수에 반복문 내부에서 재사용함.
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(solution(br.readLine()));
		
		bw.flush();
		bw.close();
	}
	
	static String solution(String m) {		
		if (m.equals("0")) return "0";
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		int n = 0;
		
		for (int i = 0; i < m.length(); i++) {
			n = (int) m.charAt(i) - 48;
			
			if (i == 0) {
				while (n != 0) {
					s.push(n % 2);
					n = n / 2;
				}
			} else {
				for (int j = 0; j < 3; j++) {
					s.push(n % 2);
					n = n / 2;
				}
			}
			
			while (!s.isEmpty()) {
				sb.append(s.pop());
			}
		}
		
		return sb.toString();
	}
}
