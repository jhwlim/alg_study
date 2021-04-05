/*
	# 48. Rotate Image
	- Difficulty : Medium
	- Related Topics : Array
	- Runtime : 1ms, Memory : 38.9MB
*/
class Solution {
    
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 1; j < len; j++) {
                rotate(matrix, i, i, len);    
            }
            len -= 2;
        }
    }
    
    public static int[][] move = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}  
    };
    
    public final int ROW = 0;
    public final int COL = 1;
    
    public void rotate(int[][] matrix, int row, int col, int len) {
        int r = row;
        int c = col;
        int prev = matrix[r][c];
        
        for (int i = 0; i < move.length; i++) {
            for (int j = 1; j < len; j++) { 
                r += move[i][ROW];
                c += move[i][COL];
                
                int tmp = matrix[r][c];
                matrix[r][c] = prev;
                prev = tmp;
            }
        }
        
    }
    
}