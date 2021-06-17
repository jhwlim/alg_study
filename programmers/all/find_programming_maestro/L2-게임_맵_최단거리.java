import java.util.*;

class Solution {
    
    private static final int[][] moves = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1},  
    };
    
    public int solution(int[][] maps) {
        int rowSize = maps.length;
        int colSize = maps[0].length;
        
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            int d = queue.poll();;
            
            if (r == rowSize-1 && c == colSize-1) {
                return d;
            }
            
            for (int i = 0; i < moves.length; i++) {
                int moveR = r + moves[i][0];
                int moveC = c + moves[i][1];
                
                if (moveR < 0
                    || moveR >= rowSize
                    || moveC < 0
                    || moveC >= colSize) {
                    continue;
                }
                
                if (maps[moveR][moveC] == 1 && !visited[moveR][moveC]) {
                    visited[moveR][moveC] = true;
                    queue.add(moveR);
                    queue.add(moveC);
                    queue.add(d + 1);
                }
            }
        }
        
        return -1;
    }
    
}