import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = i * columns + j + 1;
            }
        }
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = rotate(arr, queries[i]);
        }
        
        return result;
    }
    
    public static int[][] move = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    
    public int rotate(int[][] arr, int[] query) {
        int beginRow = query[0]-1; 
        int beginCol = query[1]-1;
        int endRow = query[2]-1;
        int endCol = query[3]-1;
            
        int row = beginRow;
        int col = beginCol;
        int prev = arr[row][col];
        int min = prev;
        
        for (int i = 0; i < move.length; i++) {
            int moveCnt = i % 2 == 0 ? (endCol - beginCol) : (endRow - beginRow);
            
            for (int j = 0; j < moveCnt; j++) {
                col += move[i][0];
                row += move[i][1];
                
                int tmp = arr[row][col];
                arr[row][col] = prev;
                prev = tmp;
                min = Math.min(prev, min);
            }
        }
        
        return min;
    }
    
}