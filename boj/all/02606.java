import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// # 2606. 바이러스
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> adjacents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacents.add(new ArrayList<>());
        }
        
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String[] strs = br.readLine().split(" ");
            int from = Integer.parseInt(strs[0])-1;
            int to = Integer.parseInt(strs[1])-1;
            
            adjacents.get(from).add(to);
            adjacents.get(to).add(from);
        }
        
        bw.write(bfs(adjacents) + "\n");
        bw.flush();
        bw.close();
    }
    
    private static int bfs(List<List<Integer>> list) {
        boolean[] visited = new boolean[list.size()];
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        visited[0] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> adj = list.get(num);
            for (int i : adj) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
        
        return count;
    }
}
