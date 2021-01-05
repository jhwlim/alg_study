import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				
		String s = sc.nextLine(); 
//		String s = "<ab cd>ef gh<ij kl>";
//		String s = "<open>tag<close>";
//		String s = "one1 two2 three3 4fourr 5five 6six";
//		String s = "<problem>17413<is hardest>problem ever<end>";
//		String s = "<   space   >space space space<    spa   c e>";
		
		boolean flag = false; // 태그 내부인지 외부인지를 판단
				
		Stack<Character> s2 = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// '<' 를 만나면 flag = true
			// 만약 스택이 비어있지 않은 경우, 스택을 모두 반환한다.
			if (c == '<') {
				while(!s2.empty()) {
					sb.append(s2.pop());
				}
				flag = true;
			}
			
			if (flag) { // 태그 내부에 있는 경우
				sb.append(c);
				
				// '>' 를 만나면 flag = false
				if (c == '>') flag = false;
			} else { // 태그가 아닌 경우
				if (c == ' ') { // 공백을 만나면, 스택 모두 반환하고 공백을 추가
					while(!s2.empty()) {
						sb.append(s2.pop());
					}
					sb.append(c);
				} else { // 공백이 아니라면 스택에 추가한다.
					s2.push(c);
				}
				
				// end of String
				if (i == s.length()-1) {
					while(!s2.empty()) {
						sb.append(s2.pop());
					}
				}
			}
			
		}
			
		System.out.println(sb);
				
		sc.close();
		
	}

}
