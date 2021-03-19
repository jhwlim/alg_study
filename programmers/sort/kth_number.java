import java.util.*;

// 정렬 > K번째수
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int begin = commands[i][0]-1;
            int finish = commands[i][1]-1;
            int index = commands[i][2]-1;
            
            int[] arr = new int[finish-begin+1];
            int k = 0;
            for (int j = begin; j <= finish; j++) {
                arr[k++] = array[j];
            }
            
            Arrays.sort(arr);
            
            result[i] = arr[index];
        }
        
        return result;
    }
}