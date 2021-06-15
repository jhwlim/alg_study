import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int maxSize = 0;
        int count = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int size = getSize(picture, i, j, visited);
                    maxSize = Math.max(size, maxSize);
                    count++;
                }
            }
        }
        
        return new int[]{count, maxSize};
    }
    
    public static int[][] moves = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1},
    };
    
    public int getSize(int[][] picture, int row, int col, boolean[][] visited) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(row);
        q.add(col);
        visited[row][col] = true;
        
        int size = 0;
        while (!q.isEmpty()) {
            size++;
            int r = q.poll();
            int c = q.poll();
            
            for (int i = 0; i < moves.length; i++) {
                int moveR = r + moves[i][0];
                int moveC = c + moves[i][1];
                
                if (moveR < 0 
                    || moveR >= visited.length
                    || moveC < 0
                    || moveC >= visited[0].length) {
                    continue;
                }
                
                if (!visited[moveR][moveC]
                   && picture[moveR][moveC] == picture[row][col]) {
                    visited[moveR][moveC] = true;
                    q.add(moveR);
                    q.add(moveC);
                }
            }
            
        }
        
        
        return size;
    }
    
}