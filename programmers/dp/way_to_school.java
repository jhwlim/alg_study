import java.util.*;

// 동적계획법 > 등굣길
class Solution {
    
    final int NUM = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddle = new boolean[n+1][m+1];
        int[][] path = new int[n+1][m+1];
        
        for (int i = 0; i < puddles.length; i++) {
            isPuddle[puddles[i][1]][puddles[i][0]] = true;
        }
        
        for (int i = 1; i < path.length; i++) {
            for (int j = 1; j < path[i].length; j++) {
                if (i == 1 && j == 1) {
                    path[i][j] = 1;
                    continue;
                }
                
                if (isPuddle[i][j]) {
                    continue;
                }
                
                if ((i == 1 && path[i][j-1] != 0) || (j == 1 && path[i-1][j] != 0)) {
                    path[i][j] = 1;
                    continue;
                }
                
                path[i][j] = (path[i-1][j] + path[i][j-1]) % NUM;
            }
        }
        return path[n][m];
    }
}