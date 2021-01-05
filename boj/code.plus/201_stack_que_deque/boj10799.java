import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		int cnt = 0;
		int sum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1) {
				if (s.charAt(i) == '(' && s.charAt(i+1) == ')') {
					sum += cnt;
					//System.out.println(cnt);
					i++;
					continue;
				}
			}
			if (s.charAt(i) == '(') {
				cnt++;
			}
			if (s.charAt(i) == ')') {
				cnt--;
				//System.out.println(cnt);
				sum += 1;
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
