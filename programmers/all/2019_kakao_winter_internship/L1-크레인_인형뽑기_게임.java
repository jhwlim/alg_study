import java.util.*;

// 2019 카카오 개발자 겨울 인턴십 > 크레인 인형뽑기 게임, lv1
class Solution {
    public int solution(int[][] board, int[] moves) {
        int[] idxOfBoard = new int[board.length];
        
        for (int i = 0; i < board.length; i++) {
            int j = 0;
            for (; j < board.length; j++) {
                if (board[j][i] != 0) {
                    idxOfBoard[i] = j;
                    break;
                } 
            }
            if (j == board.length) {
                idxOfBoard[i] = j;
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        
        for (int move : moves) {
            int idx = idxOfBoard[move-1];
            if (idx < board.length) {
                int doll = board[idx][move-1];
                if (!stack.isEmpty() && doll == stack.peek()) {
                    cnt += 2;
                    stack.pop();
                } else {
                    stack.push(doll);
                }
                
                idxOfBoard[move-1] += 1;
            }
        }
        
        return cnt;
    }
}