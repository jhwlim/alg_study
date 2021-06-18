import java.util.*;

class Solution {
    
    private static boolean[] isPrimeNumbers;
    
    static {
        int n = 3000;
        isPrimeNumbers = new boolean[n+1];
        Arrays.fill(isPrimeNumbers, true);
        isPrimeNumbers[0] = false;
        isPrimeNumbers[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrimeNumbers[i]) {
                for (int j = 2; i * j <= n; j++) {
                    isPrimeNumbers[i * j] = false;
                }
            }
        }
    }
    
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int result = nums[i] + nums[j] + nums[k];
                    if (isPrimeNumbers[result]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
}