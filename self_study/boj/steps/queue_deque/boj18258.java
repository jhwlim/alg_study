import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		int back = 0;
		
		for (int i = 0; i < n; i++) {
			String[] cmd = br.readLine().split(" ");
			
			switch (cmd[0]) {
			case "push" :
				back = Integer.parseInt(cmd[1]);
				q.add(back);
				break;
			case "pop" :
				bw.write((!q.isEmpty() ? q.poll() : -1)+"\n");
				break;
			case "size" :
				bw.write(q.size()+"\n");
				break;
			case "empty" :
				bw.write((q.isEmpty() ? 1 : 0) + "\n");
				break;
			case "front" :
				bw.write((!q.isEmpty() ? q.peek() : -1)+"\n");
				break;
			case "back" :
				bw.write((!q.isEmpty() ? back : -1) + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		
	}

}
