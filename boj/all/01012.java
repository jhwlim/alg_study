import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


// # 1012. 유기농 배추
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] strs = br.readLine().split(" ");
            int m = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);
            int k = Integer.parseInt(strs[2]);
            
            boolean[][] maps = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                String[] strs2 = br.readLine().split(" ");
                maps[Integer.parseInt(strs2[0])][Integer.parseInt(strs2[1])] = true;
            }
            
            bw.write(countBfs(maps) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    private static int[][] moves = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    
    private static int countBfs(boolean[][] maps) {
        int count = 0;
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j]) {
                    bfs(maps, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private static void bfs(boolean[][] maps, int row, int col) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(row);
        queue.add(col);
        maps[row][col] = false;
        
        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            
            for (int i = 0; i < moves.length; i++) {
                int moveR = r + moves[i][0];
                int moveC = c + moves[i][1];
                
                if (moveR < 0 || moveR >= maps.length
                        || moveC < 0 || moveC >= maps[0].length) {
                    continue;
                }
                
                if (maps[moveR][moveC]) {
                    queue.add(moveR);
                    queue.add(moveC);
                    maps[moveR][moveC] = false;
                }
            }
        }
    }
    
}
