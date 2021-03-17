import java.util.*;

// 동적계획법 > 정수 삼각형
class Solution {
    public int solution(int[][] triangle) {
        int[][] tmp = new int[triangle.length][triangle.length];
        int add = 0;
        int max = 0;
        
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                tmp[i][j] = triangle[i][j];
            }
        }
        
        for (int i = 0; i < triangle.length-1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                add = tmp[i][j];
                
                tmp[i+1][j] = Math.max(tmp[i+1][j], triangle[i+1][j] + add);
                tmp[i+1][j+1] = Math.max(tmp[i+1][j+1], triangle[i+1][j+1] + add);    
            
                if (i == triangle.length-2) {
                    if (tmp[i+1][j] > max) {
                        max = tmp[i+1][j];
                    }
                }
            }
        }
        
        return max;
    }
}