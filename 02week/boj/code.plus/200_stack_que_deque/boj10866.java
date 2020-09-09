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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> frontList = new ArrayList<Integer>();
		List<Integer> backList = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int result = -1;
			
			switch (s[0]) {
			case "push_back" :
				backList.add(Integer.parseInt(s[1]));
				break;
			case "push_front" :
				frontList.add(Integer.parseInt(s[1]));
				break;
			case "pop_front" :
				if(!frontList.isEmpty()) {
					result = frontList.remove(frontList.size()-1);
				} else {
					if(!backList.isEmpty()) {
						result = backList.remove(0);
					} 
				}
				bw.write(result + "\n");
				break;
			case "pop_back" :
				if(!backList.isEmpty()) {
					result = backList.remove(backList.size()-1);
				} else {
					if(!frontList.isEmpty()) {
						result = frontList.remove(0);
					} 
				}

				bw.write(result + "\n");
				break;
			case "size" :
				bw.write(frontList.size()+backList.size() + "\n");
				break;
			case "empty" :
				bw.write(((frontList.size()+backList.size() == 0) ? 1 : 0) + "\n");
				break;
			case "front" :
				if(!frontList.isEmpty()) {
					result = frontList.get(frontList.size()-1);
				} else {
					if(!backList.isEmpty()) {
						result = backList.get(0);
					} 
				}
				bw.write(result + "\n");
				break;
			case "back" :
				if(!backList.isEmpty()) {
					result = backList.get(backList.size()-1);
				} else {
					if(!frontList.isEmpty()) {
						result = frontList.get(0);
					} 
				}

				bw.write(result + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
	}
}